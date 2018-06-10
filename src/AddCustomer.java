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

public class AddCustomer extends HttpServlet {
    private final String addCustomerQuery = "INSERT INTO customer (name, address) VALUES (?, ?);";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addcustomer.jsp");
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        try {
            Connection conn = DatabaseWrapper.getConnection();
            PreparedStatement stmt = conn.prepareStatement(addCustomerQuery);
            stmt.setString(1, request.getParameter("name"));
            stmt.setString(2, request.getParameter("address"));
            stmt.executeUpdate();

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addcustomersuccess.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addcustomerfailure.jsp");
            dispatcher.forward(request, response);
        }
    }
}
