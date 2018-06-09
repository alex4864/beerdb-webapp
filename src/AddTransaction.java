import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class AddTransaction extends HttpServlet {
    private final String addTransactionQuery = "INSERT INTO transaction (beer_name, beer_size, quantity, time, customer_id) VALUES ('%s', %f, %d, '%s', %d)";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addtransaction.jsp");
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC+00:00"));
        String formattedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        try {
            Connection conn = DatabaseWrapper.getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(String.format(addTransactionQuery, request.getParameter("beer_name"),
                    Float.parseFloat(request.getParameter("beer_size")),
                    Integer.parseInt(request.getParameter("quantity")),
                    formattedNow,
                    Integer.parseInt(request.getParameter("customer_id"))));

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addtransactionsuccess.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addtransactionfailure.jsp");
            dispatcher.forward(request, response);
        }
    }
}
