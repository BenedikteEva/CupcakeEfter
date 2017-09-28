package data;

import static data.DBConnector.getConnection;
import domain.InfoToAdmin;
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
   public List<InfoToAdmin> getAllOrderId() throws SQLException {
        List<InfoToAdmin> allOrderId = new ArrayList();

        String sql = "SELECT order_id FROM orderlist";

        ResultSet rs = getConnection().prepareStatement(sql).executeQuery();
        int lastId = -1;
        InfoToAdmin lineItem = null;
        while (rs.next()) {
            int order_id = rs.getInt("order_id");
            if (order_id != lastId) {
                int invoice_id = rs.getInt("order_id");
                lineItem = new InfoToAdmin(invoice_id);
                allOrderId.add(lineItem);
            }
//            person.addPhone(new Phone(rs.getString("phoneNo"), rs.getString("description")));
//            lastId = personId;
        }
        return allOrderId;
    }
   
   
    public static void main(String[] args) {
        
        InfoToAdminMapper info = new InfoToAdminMapper();
        
       try {
           System.out.println(info.getAllOrderId());
       } catch (SQLException ex) {
           Logger.getLogger(InfoToAdminMapper.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
}
