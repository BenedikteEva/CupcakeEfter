package data;

import domain.Bottom;
import domain.LineItem;
import domain.MakingAnException;
import domain.Odetail;
import domain.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BenedikteEva
 */
public class LineItemsMapper {

    Connection conn;

    public LineItemsMapper() {
        this.conn = DBConnector.getConnection();
    }

    public int addOrderToOrderList(Order or) throws SQLException {

        String insertOrder = "INSERT INTO orderlist (user_id, received) VALUES (?, ?)";
        PreparedStatement orderPstmt = conn.prepareStatement(insertOrder, Statement.RETURN_GENERATED_KEYS);

        orderPstmt.setInt(1, or.getUser_id());
        orderPstmt.setString(2, or.getReciveddate());
        int result = orderPstmt.executeUpdate();
        ResultSet rs = orderPstmt.getGeneratedKeys();
        rs.next();
        int id = rs.getInt(1);
        return id;
    }

    public int addLineItemToDb(LineItem li) throws SQLException {

        String insertLineItem = "INSERT INTO lineitem (order_id,  top_id, bot_id, ccname, quantity, prisprcc, totalprice) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement confPstmt = conn.prepareStatement(insertLineItem, Statement.RETURN_GENERATED_KEYS);

        confPstmt.setInt(1, li.getInvoiceId());
        confPstmt.setInt(2, li.getTop_id());
        confPstmt.setInt(3, li.getBot_id());
        confPstmt.setString(4, li.getCupcakeName());
        confPstmt.setInt(5, li.getQuantity());
        confPstmt.setDouble(6, li.getPricePrCc());
        confPstmt.setDouble(7, li.getTotalPrice());

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
            ex.getMessage();
        }

        return li;
    }

    public String getLineItemDataByUserId(int user_id, int order_id) throws SQLException {
        String li = null;
        try {

            String sql = " SELECT orderlist.order_id, lineitem_id, quantity, ccname, prisprcc, totalprice \n"
                    + " FROM lineitem, orderlist, userlist WHERE orderlist.user_id=userlist.user_id and userlist.user_id=" + user_id + " \n"
                    + " and orderlist.order_id=" + order_id + ")";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user_id);
            pstmt.setInt(2, order_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                li = rs.toString();

            }
        } catch (SQLException ex) {
            ex.getMessage();
        }

        return li;
    }

    public List<Odetail> getInvoiceDetailByOrderId(int orderId) throws SQLException {

        List<Odetail> orderDetailList = new ArrayList();
        try {

            String sql = "SELECT lineitem.lineitem_id, orderlist.order_id, orderlist.received, lineitem.ccname, "
                    + "lineitem.quantity, lineitem.prisprcc, lineitem.totalprice \n"
                    + "From orderlist INNER JOIN lineitem ON orderlist.order_id = lineitem.order_id "
                    + "where orderlist.order_id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, orderId);

            ResultSet rs = pstmt.executeQuery();
            int lastId = -1;
            Odetail odetail = null;
            while (rs.next()) {

                int lineitem_id = rs.getInt("lineitem_id");
                if (lineitem_id != lastId) {
                    int order_id = rs.getInt("order_id");
                    String received = rs.getString("received");
                    String ccname = rs.getString("ccname");
                    int quantity = rs.getInt("quantity");
                    double prisprcc = rs.getDouble("prisprcc");
                    double totalprice = rs.getDouble("totalprice");

                    odetail = new Odetail(lineitem_id, order_id, received, ccname, quantity, prisprcc, totalprice);
                    orderDetailList.add(odetail);
                }
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }

        return orderDetailList;
    }

    public List<Odetail> getInvoiceDetailForUser(int userId) throws SQLException {

        List<Odetail> orderDetailList = new ArrayList();
        try {

            String sql = "SELECT lineitem.lineitem_id, orderlist.order_id, orderlist.received, lineitem.ccname, "
                    + "lineitem.quantity, lineitem.prisprcc, lineitem.totalprice "
                    + "From orderlist "
                    + "INNER JOIN lineitem ON orderlist.order_id = lineitem.order_id "
                    + "WHERE user_id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);

            ResultSet rs = pstmt.executeQuery();
            int lastId = -1;
            Odetail odetail = null;
            while (rs.next()) {

                int lineitem_id = rs.getInt("lineitem_id");
                if (lineitem_id != lastId) {
                    int order_id = rs.getInt("order_id");
                    String received = rs.getString("received");
                    String ccname = rs.getString("ccname");
                    int quantity = rs.getInt("quantity");
                    double prisprcc = rs.getDouble("prisprcc");
                    double totalprice = rs.getDouble("totalprice");

                    odetail = new Odetail(lineitem_id, order_id, received, ccname, quantity, prisprcc, totalprice);
                    orderDetailList.add(odetail);
                }
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }

        return orderDetailList;
    }

    public static void main(String[] args) throws SQLException, Exception {
        LineItemsMapper lim = new LineItemsMapper();

        //Test getInvoiceDetailForUser
        Odetail odetail = new Odetail();
        System.out.println(lim.getInvoiceDetailByOrderId(5));

        //Test insert into orderlist
//        Order or = new Order(3);
//        lim.addOrderToOrderList(or);
//        InfoToAdminMapper itam = new InfoToAdminMapper();
//        LineItem orderDetail = new LineItem(5, 1, 2, 1, "Orange with Chocolate", 10.00, 30.00);
        //            lim.addLineItemToDb(orderDetail);
//        System.out.println(lim.getLineItemDataByUserId(3, 1));
    }
}
