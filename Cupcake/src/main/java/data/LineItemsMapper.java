package data;

import domain.LineItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author BenedikteEva
 */
public class LineItemsMapper {
 Connection conn;

    public LineItemsMapper() {
        this.conn = DBConnector.getConnection();
    }
    public int addLineItemToDb(LineItem li) throws Exception {
     
            String insertLineItem = "INSERT INTO lineitem (order_id, quantity, ccname, prisprcc, totalprice) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement confPstmt = conn.prepareStatement(insertLineItem, Statement.RETURN_GENERATED_KEYS);

            confPstmt.setInt(1, li.getInvoiceId());
            confPstmt.setInt(2, li.getQuantity());
            confPstmt.setString(3, li.getCupcakeName());
            confPstmt.setDouble(4, li.getPricePrCc());
            confPstmt.setDouble(5, li.getTotalPrice());

            int result = confPstmt.executeUpdate();
            ResultSet rs = confPstmt.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);

            return id;
    }
    
    public LineItem getLineItemData(int lineItemId) throws SQLException {

        LineItem li = null;
        try {

            String sql = "SELECT * FROM lineitem WHERE lineitem_id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, lineItemId);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {

                int id = rs.getInt("order_id");
                String ccname = rs.getString("ccname");
                int qty = rs.getInt("quantity");

                double totalprice = rs.getDouble("totalprice");
                double prisprcc = rs.getDouble("prisprcc");

                li = new LineItem(id, qty, ccname, prisprcc, totalprice);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return li;
    }

    public static void main(String[] args) throws SQLException, Exception {
//        LineItemsMapper lim = new LineItemsMapper();
//
//        LineItem li = new LineItem(2, 2, "ko", 2.00, 4.00);
//     
//        lim.addLineItemToDb(li);
//         System.out.println(lim.getLineItemData(2));
        //Test af getUserData
        //System.out.println(pm.getUserData("admin"));
        //System.out.println(pm.getAdminData("admin"));

        //pm.changeUserBalance("tr", 25.0);
        //System.out.println(pm.getUserData("tr"));
    }
}
