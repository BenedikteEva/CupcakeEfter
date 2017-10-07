package data;

import static data.DBConnector.getConnection;
import domain.LineItem;
import domain.Order;
import domain.User;
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
 *
 * @author Bo Henriksen
 */
public class InfoToAdminMapper {
    
    /**
     * Her fås alle ordre id'er fra dabasen, som efterfølgende puttes i en liste.
     * @return allOrderId
     * @throws SQLException 
     */

    //Denne metode er til admin page og henter order id 
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
     * Her fås alle ordre detaljerne fra databseen, som kunden har bestilt.
     * @param invoiceID
     * @return oDetail
     * @throws SQLException 
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
     * Her fås et helt LineItem af en Cupcake, dvs kagens top, bund, navn, pris og id.
     * @param invoiceID
     * @return name
     * @throws SQLException 
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
     * @param user_id
     * @param conf
     * @return id
     * @throws SQLException 
     */
    
    public int addConfirmation(int user_id, String conf) throws SQLException{
          Connection conn = Connector.getConnection();
        String insertUser = "INSERT INTO orderlist (user_id, confirmation) VALUES (?, ?)";
        PreparedStatement confPstmt = conn.prepareStatement(insertUser, Statement.RETURN_GENERATED_KEYS);

        confPstmt.setInt(1, user_id);
        confPstmt.setString(2,conf);
        
        int result = confPstmt.executeUpdate();
        ResultSet rs = confPstmt.getGeneratedKeys();
        rs.next();
        int id = rs.getInt(1);
        return id;
    }
 
    /**
     * Her udskrives oplysninger til adminbrugren om en kundes ordrer.
     * @param args 
     */
    

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

}
