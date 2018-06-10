import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class AddTransaction extends HttpServlet {
    private final String addTransactionQuery = "INSERT INTO transaction (beer_name, beer_size, quantity, time, customer_id) VALUES (?, ?, ?, ?, ?);";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addtransaction.jsp");
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC+00:00"));
        String formattedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        try {
            if(Integer.parseInt(request.getParameter("quantity")) < 1) {
                throw new IllegalArgumentException("Quantity must be greater than 0");
            }

            Connection conn = DatabaseWrapper.getConnection();
            PreparedStatement stmt = conn.prepareStatement(addTransactionQuery);
            stmt.setString(1, request.getParameter("beer_name"));
            stmt.setFloat(2, Float.parseFloat(request.getParameter("beer_size")));
            stmt.setInt(3, Integer.parseInt(request.getParameter("quantity")));
            stmt.setString(4, formattedNow);
            stmt.setInt(5, Integer.parseInt(request.getParameter("customer_id")));

            // Referential Integrity Check occurs here!
            // Our database is configured so that beer_name, beer_size, and customer_id are foreign keys, and if any of
            // these fields do not point to an existing reference then SQLException is thrown, and the client is served
            // a 400 response with a prompt to try again and a link to the original form.  Also note that the system can
            // even detect violations of the composite key of beer, i.e. if a user attempts to add a transaction with a
            // beer name that our database contains, but not in a size we have, this transaction will also be rejected
            stmt.executeUpdate();

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addtransactionsuccess.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            response.setStatus(400);
            request.setAttribute("errorMessage", e.getMessage());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addtransactionfailure.jsp");
            dispatcher.forward(request, response);
        }
    }
}
