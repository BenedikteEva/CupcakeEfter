package data;

import static data.Connector.getConnection;
import domain.Bottom;
import domain.CupCake;
import domain.LineItem;
import domain.Topping;
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
 * @author Ticondrus
 */
public class LineItemsMapper {

   

    public List<LineItem> getAllLineItemslist() throws SQLException {
        List<LineItem> cupcakeLineItemList = new ArrayList();
        String sql = "SELECT invoice_id, topname, top_price FROM toppinglist";
        ResultSet rsi = getConnection().prepareStatement(sql).executeQuery();
        int lastId = -1;
        LineItem lineitems = null;
        while (rsi.next()) {
            int invoice_id = rsi.getInt("invoice_id");
            if (invoice_id != lastId) {
                String u = rsi.getString("u_name");
                double top_Price = rsi.getDouble("top_price");
                lineitems = new LineItem(invoice_id, u, top_Price);
                cupcakeLineItemList.add(lineitems);
            }
//            person.addPhone(new Phone(rs.getString("phoneNo"), rs.getString("description")));
//            lastId = personId;
        }
        return cupcakeLineItemList;
    }
// jeg forstår ikke hvorfor min get topping og bottomprice by name ikke virker. 



    public static void main(String[] args) throws SQLException {
        LineItemsMapper lim = new LineItemsMapper();
        //Recipe p = new Recipe("Kalle", "Karlsen");
        System.out.println("LineItems:");
        System.out.println(lim.getAllLineItemslist());

    //    System.out.println("Topping:");
    //    System.out.println(pm.getAllTopping());
    //    System.out.println(pm.getAllBottom());
    //    System.out.println(pm.getBottomPricebyName("Chocolate"));
    //    System.out.println(pm.getToppingPricebyName("Orange"));
        //try {
//            int id = pm.addPerson(p); 
//            pm.addPhone(id, "11334355", "mobile"); 
//            pm.addPhone(id, "22340443", "home"); 
        //pm.getAllRecipe().forEach(recipe->System.out.println(recipe));
        //} catch (Exception ex) {
        //ex.printStackTrace();
    }

}
