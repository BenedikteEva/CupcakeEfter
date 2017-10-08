package data;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Benedikte
 * This DBConnector should connect to my remote server and a database called cupcake
 * 
 */


public class DBConnector {
    
    
    
    private final static String DRIVER = "com.mysql.jdbc.Driver";
    private final static String URL = "jdbc:mysql://46.101.179.58:3306/cupcake";
    private final static String USER = "testuser";
    private final static String PASSWORD = "password123";
 private static Connection conn = null;
 
    public static Connection getConnection() {
        if (conn == null) {
            try { 
                Class.forName(DRIVER);
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                //se hele sekvenst til det gik galt. Dette kan skrives til logfil. 
                ex.printStackTrace();
            } 
        } 
        return conn;
    }
}  