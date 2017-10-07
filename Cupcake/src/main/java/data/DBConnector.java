package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Bo Henriksen
 */
public class DBConnector {
    
    
    
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://138.197.181.3/cupcake"; //"jdbc:mysql://localhost:3306/test"
    private static String USER = "henriksen";
    private static String PASSWORD = "tryl";
    private static Connection conn = null;
    
    /**
     * Her etableres forbindelse med vores MySQL Database cupcake.
     * @return conn
     */
       
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
    
 
    public static void main(String[] args) {
        //Test connection 
        try { 
            String sql = "SELECT * FROM bottomlist where bot_id=1";
            ResultSet rs = getConnection().prepareStatement(sql).executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("bottomname")+" koster: "+rs.getString("bot_price"));
            } 
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    } 
    
}
