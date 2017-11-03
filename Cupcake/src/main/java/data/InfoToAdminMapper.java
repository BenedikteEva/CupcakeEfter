package data;

import domain.LineItem;
import domain.MakingAnException;
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
 * The class InfoToAdmin handels all the methods that makes querries about line
 * items to the database.
 *
 * @author Bo Henriksen
 */
public class InfoToAdminMapper {

    Connection conn;

    public InfoToAdminMapper() {
        this.conn = DBConnector.getConnection();
    }

    /**
     * TODO The method gets all order id. Is not implemented. (Denne metode er
     * til admin page og henter order id )
     *
     * @return a list of order id's.
     * @throws SQLException if an sql error occur.
     */
    public List<Order> getAllOrderId() throws SQLException {
        List<Order> allOrderId = new ArrayList();

        String sql = "SELECT order_id FROM orderlist;";

        ResultSet rs = conn.prepareStatement(sql).executeQuery();
        int lastId = -1;
       Order id = null;
        while (rs.next()) {
            int order_id = rs.getInt("order_id");
            if (order_id != lastId) {
                int invoiceid = rs.getInt("order_id");
                id = new Order(invoiceid);
                allOrderId.add(id);
            }
//            person.addPhone(new Phone(rs.getString("phoneNo"), rs.getString("description")));
//            lastId = personId;
        }
        return allOrderId;
    }

    /**
     * TODO Her fås alle ordre id'er fra dabasen, som efterfølgende puttes i en
     * liste. (Denne metode er til admin page og henter order id men fra
     * ordrelisten)
     *
     * @param user_id takes the user id to get the order id.
     * @return a list of all the order id's.
     * @throws SQLException if an sql error occur.
     */
    public List<Order> getAllOrderId2(int user_id) throws SQLException {
        List<Order> allOrderId = new ArrayList();
        user_id = 0;
        String sql = "SELECT order_id FROM orderlist where user_id=" + user_id;

        ResultSet rs = conn.prepareStatement(sql).executeQuery();
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
        return (List<Order>) id;
    }

    /**
     * TODO Her fås alle ordre detaljerne fra databseen, som kunden har bestilt.
     * This method does not work and is not implemented.
     *
     * @param invoiceID gets the invoice id from the admin_page and find the
     * order based on the id.
     * @return a list all the order details
     * @throws SQLException if an sql error occur.
     */
    public LineItem getODetail(int invoiceID) throws SQLException {

        LineItem oDetail = null;
     

            String sql = "SELECT order_id, priceprcc, total_price, quantity FROM lineitem WHERE order_id = ?";
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
       

        return oDetail;
    }
    
    public int getUserIdByOrderId(int order_id) throws SQLException{
        int user_id = 0;
        
        String sql = "SELECT user_id FROM orderlist WHERE order_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, order_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user_id = rs.getInt("user_id");
            }
        return user_id;
        
    }
    



    /**
     * Adds the users id into the orderlist.
     *
     * @param user_id the method takes the users id.
     * @return the users id.
     * @throws SQLException if an sql error occur.
     */
    /**
     * Her tilføjes en kundes ordrer til databasen.
     *
     * @param o
     * @return id
     * @throws SQLException
     */
    public int addOrder(Order o) throws SQLException {

        int user_id = 0;

        String insertOrder = "INSERT INTO orderlist (user_id) VALUES (?)";
        PreparedStatement confPstmt = conn.prepareStatement(insertOrder, Statement.RETURN_GENERATED_KEYS);

        confPstmt.setInt(1, user_id);

        int result = confPstmt.executeUpdate();
        ResultSet rs = confPstmt.getGeneratedKeys();
        rs.next();
        int id = rs.getInt(1);
        return id;
    }

   

    public int getLastInvoiceId() throws MakingAnException {
        int invoiceid = 0;
        try {

            String sql = "SELECT MAX(order_id) as order_id from orderlist";
            ResultSet rs = conn.prepareStatement(sql).executeQuery();

            if (rs.next()) {

                invoiceid = rs.getInt("order_id");

            }
        } catch (SQLException| NumberFormatException| NullPointerException| IndexOutOfBoundsException ex) {

        }

        return invoiceid;
    }
    
    public List<Order>  getOrders() throws MakingAnException {
    List<Order> orderIds=new ArrayList<>();
  Order o;
      try {
           
            String sql = "SELECT * FROM orderlist";
            ResultSet rs = conn.prepareStatement(sql).executeQuery();
            
              while (rs.next()) {
                int order_id = rs.getInt("order_id");
                int user_id = rs.getInt("user_id");
                String received_date=rs.getString("received");

                    o = new Order(order_id, user_id, received_date);
                    orderIds.add(o);
                }

         
            return orderIds;
        } catch (SQLException| NumberFormatException| NullPointerException ex) {
            ex.getCause();
        }
        return orderIds;
    }


    //The main method is the test purpose
    public static void main(String[] args) throws SQLException, MakingAnException {

        InfoToAdminMapper info = new InfoToAdminMapper();
        
         System.out.println("getOrderId");
            System.out.println(info.getOrders());
     
        //Tester getCupcakeName
//        System.out.println("CUPCAKENAME");
//        try {
//            System.out.println(info.getCupcakeName(1));
//        } catch (SQLException ex) {
//            Logger.getLogger(InfoToAdminMapper.class.getName()).log(Level.SEVERE, null, ex);
//        }
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

}
