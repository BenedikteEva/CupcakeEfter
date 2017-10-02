package data;

import static data.DBConnector.getConnection;
import domain.LineItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bo Henriksen
 */
public class InfoToAdminMapper {

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
