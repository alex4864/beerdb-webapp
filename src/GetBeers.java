import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.*;

public class GetBeers extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        ArrayList<Beer> beerList = new ArrayList<Beer>();
        try {
            Connection conn = DatabaseWrapper.getConnection();

            Statement stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM beer");

            while(results.next()){
                beerList.add(new Beer(results.getString(1), results.getFloat(2), results.getFloat(6)));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        request.setAttribute("beers", beerList);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/getbeers.jsp");
        dispatcher.forward(request, response);
    }
}
