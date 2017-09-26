package data;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Benedikte
 * This DBConnector should connect to my remote server and a database called RecipesDB
 * 
 */
@WebServlet(name = "RecipesServlet", urlPatterns = {"/recipesServlet"})

public class Connector {
    
    
    
    private final static String DRIVER = "com.mysql.jdbc.Driver";
    private final static String URL = "jdbc:mysql://46.101.179.58:3306/cupcake";
    private final static String USER = "testuser";
    private final static String PASSWORD = "password123";

    public static Connection getConnection() throws SQLException {
        Connection conn = null ;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }
}