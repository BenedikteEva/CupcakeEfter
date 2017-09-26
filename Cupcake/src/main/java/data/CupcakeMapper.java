package data;

import static data.Connector.getConnection;
import domain.Bottom;
import domain.CupCake;
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
public class CupcakeMapper {

   

    public List<Topping> getAllTopping() throws SQLException {
        List<Topping> cupcakeToppingList = new ArrayList();
        String sql = "SELECT top_id, topname, top_price FROM toppinglist";
        ResultSet rs = getConnection().prepareStatement(sql).executeQuery();
        int lastId = -1;
        Topping topping = null;
        while (rs.next()) {
            int top_id = rs.getInt("top_id");
            if (top_id != lastId) {
                String topname = rs.getString("topname");
                double top_Price = rs.getDouble("top_price");
                topping = new Topping(top_id, topname, top_Price);
                cupcakeToppingList.add(topping);
            }
//            person.addPhone(new Phone(rs.getString("phoneNo"), rs.getString("description")));
//            lastId = personId;
        }
        return cupcakeToppingList;
    }
// jeg forstår ikke hvorfor min get topping og bottomprice by name ikke virker. 
    public double getToppingPricebyName(String topname) throws SQLException {
        Topping t = null;
        double topprice = 0;

        String sql = "SELECT top_id, top_price, topname FROM toppinglist where topname ="+"'"+topname+"'";
        ResultSet rs = getConnection().prepareStatement(sql).executeQuery();
        if (rs.next()) {

            int top_id = rs.getInt("top_id");
            topname = rs.getString("topname");
            topprice = rs.getDouble("top_price");

            t = new Topping(top_id, topname, topprice);
        }
        return t.getTop_Price();
    }

    public double getBottomPricebyName(String botname) throws SQLException {
        double botprice = 0;
        Bottom b = null;

        String sql = "SELECT bot_id, bot_price, bottomname FROM bottomlist WHERE bottomname ="+"'"+botname+"'";
        ResultSet rs = getConnection().prepareStatement(sql).executeQuery();
        if (rs.next()) {
            int bot_id = rs.getInt("bot_id");
            botname = rs.getString("bottomname");
            botprice = rs.getDouble("bot_price");
            b = new Bottom(bot_id, botname, botprice);
        }
        return b.getBot_Price();
    }

    public List<Bottom> getAllBottom() throws SQLException {
        List<Bottom> cupcakeBottomList = new ArrayList();
        String sql = "SELECT bot_id, bottomname, bot_price FROM bottomlist";

        ResultSet rs = getConnection().prepareStatement(sql).executeQuery();
        int lastId = -1;
        Bottom bottom = null;
        while (rs.next()) {
            int bot_id = rs.getInt("bot_id");
            if (bot_id != lastId) {
                String botName = rs.getString("bottomname");
                double bot_Price = rs.getDouble("bot_price");
                bottom = new Bottom(bot_id, botName, bot_Price);
                cupcakeBottomList.add(bottom);
            }
//            person.addPhone(new Phone(rs.getString("phoneNo"), rs.getString("description")));
//            lastId = personId;
        }
        return cupcakeBottomList;
    }

    public static void main(String[] args) throws SQLException {
        CupcakeMapper pm = new CupcakeMapper();
        //Recipe p = new Recipe("Kalle", "Karlsen");
        System.out.println("Bottom:");
        System.out.println(pm.getAllBottom());

        System.out.println("Topping:");
        System.out.println(pm.getAllTopping());
        System.out.println(pm.getAllBottom());
        System.out.println(pm.getBottomPricebyName("Chocolate"));
        System.out.println(pm.getToppingPricebyName("Orange"));
        //try {
//            int id = pm.addPerson(p); 
//            pm.addPhone(id, "11334355", "mobile"); 
//            pm.addPhone(id, "22340443", "home"); 
        //pm.getAllRecipe().forEach(recipe->System.out.println(recipe));
        //} catch (Exception ex) {
        //ex.printStackTrace();
    }

}
