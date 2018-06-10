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

public class GeorgeBeers extends HttpServlet {

    // query returns names of customers who have purchased Anheuser-Busch beers
    private final String GeorgeBeersQuery = "SELECT name, type, size, price FROM beer " +
            "WHERE (name IN (SELECT beer_name FROM transaction GROUP BY beer_name HAVING price > 2.0)) " +
            "AND (name IN (SELECT beer_name FROM transaction WHERE (customer_id IN (SELECT customer_id FROM customer WHERE name = 'Georgie'))));";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        ArrayList<Beer> beerList = new ArrayList<Beer>();
        try {
            Connection conn = DatabaseWrapper.getConnection();

            Statement stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery(GeorgeBeersQuery);

            while(results.next()){
                beerList.add(new Beer(results.getString(1), results.getString(2), results.getFloat(3), results.getFloat(4)));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        request.setAttribute("beers", beerList);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/georgebeers.jsp");
        dispatcher.forward(request, response);
    }
}
