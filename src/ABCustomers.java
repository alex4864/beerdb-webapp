import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ABCustomers extends HttpServlet {

    // query returns names of customers who have purchased Anheuser-Busch beers
    private final String ABCustomersQuery = "SELECT name FROM customer WHERE(customer_id IN (SELECT customer_id FROM transaction WHERE (beer_name IN (SELECT name FROM beer WHERE (supplier_id IN (SELECT supplier_id FROM supplier WHERE name = 'Anheuser-Busch'))))))";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        ArrayList<String> customerNames = new ArrayList<String>();
        try {
            Connection conn = DatabaseWrapper.getConnection();

            Statement stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery(ABCustomersQuery);

            while(results.next()){
                customerNames.add(results.getString(1));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        request.setAttribute("customers", customerNames);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/abcustomers.jsp");
        dispatcher.forward(request, response);
    }
}
