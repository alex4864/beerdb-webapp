import java.sql.*;
import java.util.Properties;

public class DatabaseWrapper {
    static String user = "javaapp";
    static String pass = "password";

    public static Connection getConnection() throws SQLException {
        Properties connProps = new Properties();
        connProps.put("user", user);
        connProps.put("password", pass);

        // load and register JDBC driver for MySQL
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/beerdb?useLegacyDatetimeCode=false&serverTimezone=UTC", connProps);
    }
}
