package data;

import static data.Connector.getConnection;
import domain.LineItem;
import domain.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The class InfoToAdmin handels all the methods that makes querries about line items to the database.
 * @author Bo Henriksen
 */
public class InfoToAdminMapper {
   
     /**
     * TODO The method gets all order id. Is not implemented.
     * (Denne metode er til admin page og henter order id )
     * @return a list of order id's.
     * @throws SQLException if an sql error occur.
     */
    public List<LineItem> getAllOrderId() throws SQLException {
        List<LineItem> allOrderId = new ArrayList();

        String sql = "SELECT order_id FROM orderlist;";

        ResultSet rs = getConnection().prepareStatement(sql).executeQuery();
        int lastId = -1;
        LineItem id = null;
        while (rs.next()) {
            int order_id = rs.getInt("order_id");
            if (order_id != lastId) {
                int invoiceid = rs.getInt("order_id");
                id = new LineItem(invoiceid);
                allOrderId.add(id);
            }
//            person.addPhone(new Phone(rs.getString("phoneNo"), rs.getString("description")));
//            lastId = personId;
        }
        return allOrderId;
    }

    /**
     * TODO Her fås alle ordre id'er fra dabasen, som efterfølgende puttes i en liste.
     * (Denne metode er til admin page og henter order id men fra ordrelisten)
     * @param user_id takes the user id to get the order id.
     * @return a list of all the order id's.
     * @throws SQLException if an sql error occur.
     */
    public List<Order> getAllOrderId2(int user_id) throws SQLException {
        List<Order> allOrderId = new ArrayList();
         user_id = 0;
        String sql = "SELECT order_id FROM orderlist where user_id=" + user_id;

        ResultSet rs = getConnection().prepareStatement(sql).executeQuery();
        int lastId = -1;
        Order id = null;
        while (rs.next()) {
            int order_id = rs.getInt("order_id");
            if (order_id != lastId) {
                int invoiceid = rs.getInt("order_id");
                id = new Order(invoiceid);

            }
//            person.addPhone(new Phone(rs.getString("phoneNo"), rs.getString("description")));
//            lastId = personId;
        }
        return allOrderId;
    }

    /**
     * TODO Her fås alle ordre detaljerne fra databseen, som kunden har bestilt.
     * This method does not work and is not implemented.
     * @param invoiceID gets the invoice id from the admin_page and find the order based on the id.
     * @return a list all the order details
     * @throws SQLException if an sql error occur.
     */
    public LineItem getODetail(int invoiceID) throws SQLException {

        LineItem oDetail = null;
        try {

            Connection conn = new Connector().getConnection();
            String sql = "SELECT order_id, priceprcc, total_price, quantity FROM odetail WHERE order_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, invoiceID);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {

                int invoiceId = rs.getInt("order_id");
                int pricePrCc = rs.getInt("priceprcc");
                int totalPrice = rs.getInt("total_price");
                int quantity = rs.getInt("quantity");

                oDetail = new LineItem(invoiceId, pricePrCc, totalPrice, quantity);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return oDetail;
    }

    /**
     *  TODO Get the cupcake name based on an id. The method does not work and is not implemented.    
     * @param invoiceID gets the invoice id from the admin_page
     * @return a cupcake name.
     * @throws SQLException if an sql error occur.
     */
    public LineItem getCupcakeName(int invoiceID) throws SQLException {

        LineItem name = null;
        try {

            Connection conn = new Connector().getConnection();
            String sql = "SELECT cupcakename from cupcakelist INNER JOIN odetail ON cupcakelist.cupcake_id  WHERE order_id = ?";//Forkert sql statement
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, invoiceID);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {

                String cupcakeName = rs.getString("cupcakename");

                name = new LineItem(cupcakeName);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return name;
    }

    /**
     * Her tilføjes en kundes ordrer til databasen.
     *
     * @param user_id insert the users id in the method
     * @param conf insert the string confirmation in the method.
     * @return an id.
     * @throws SQLException if an sql error occur.
     */
    public int addConfirmation(int user_id, String conf) throws SQLException {
        Connection conn = Connector.getConnection();
        String insertUser = "INSERT INTO orderlist (user_id, confirmation) VALUES (?, ?)";
        PreparedStatement confPstmt = conn.prepareStatement(insertUser, Statement.RETURN_GENERATED_KEYS);

        confPstmt.setInt(1, user_id);
        confPstmt.setString(2, conf);

        int result = confPstmt.executeUpdate();
        ResultSet rs = confPstmt.getGeneratedKeys();
        rs.next();
        int id = rs.getInt(1);
        return id;
    }

    /**
     * Adds the users id into the orderlist.
     * @param user_id the method takes the users id.
     * @return the users id.
     * @throws SQLException if an sql error occur.
     */
    public int addOrder(int user_id) throws SQLException {
        Connection conn = Connector.getConnection();
        String insertUser = "INSERT INTO orderlist (user_id) VALUES (?)";
        PreparedStatement confPstmt = conn.prepareStatement(insertUser, Statement.RETURN_GENERATED_KEYS);

        confPstmt.setInt(1, user_id);

        int result = confPstmt.executeUpdate();
        ResultSet rs = confPstmt.getGeneratedKeys();
        rs.next();
        int id = rs.getInt(1);
        return id;
    }

    //The main method is the test purpose
    public static void main(String[] args) {

        InfoToAdminMapper info = new InfoToAdminMapper();

        //Tester getCupcakeName
        System.out.println("CUPCAKENAME");
        try {
            System.out.println(info.getCupcakeName(1));
        } catch (SQLException ex) {
            Logger.getLogger(InfoToAdminMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Tester getODetail metoden
        try {
            System.out.println("GETODETAIL");
            System.out.println(info.getODetail(1));
        } catch (SQLException ex) {
            Logger.getLogger(InfoToAdminMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Tester getAllOrderId metoden
        try {
            System.out.println("GETALLORDERID");
            System.out.println(info.getAllOrderId().toString());
        } catch (SQLException ex) {
            Logger.getLogger(InfoToAdminMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addOrder(Order o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
