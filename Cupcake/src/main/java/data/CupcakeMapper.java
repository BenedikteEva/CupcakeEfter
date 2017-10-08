package data;

import domain.Bottom;
import domain.LineItem;
import domain.Topping;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The class CupcakeMapper handels all the methods that makes querries to the
 * database about the cupcakes.
 *
 */
public class CupcakeMapper {

    Connection conn;

    public CupcakeMapper() {
        this.conn = DBConnector.getConnection();
    }

    /**
     * Her oprettes en liste af alle kage toppe fra databasen.
     *
     * @return Return a list of cupcake toppings.
     * @throws SQLException if an sql error occur.
     */
    public List<Topping> getAllTopping() throws SQLException {

        List<Topping> cupcakeToppingList = new ArrayList();
        try {
            String sql = "SELECT top_id, topname, top_price FROM toppinglist";
            ResultSet rs = conn.prepareStatement(sql).executeQuery();
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
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cupcakeToppingList;
    }
// Har været et problem med en nullpointer dereference grundet tOpping t= null og topprice= 0 er løst

    /**
     * Her fås en top, dens navn og dens pris fra databasen.
     *
     * @param topname is the name of the topping that you want to find in the
     * database.
     * @return the price of the topping
     * @throws SQLException if an sql error occur.
     */
    public double getToppingPricebyName(String topname) throws SQLException {
        Topping t = new Topping();
        double topprice;
        try {
            String sql = "SELECT top_id, top_price, topname FROM toppinglist where topname =" + "'" + topname + "'";
            ResultSet rs = conn.prepareStatement(sql).executeQuery();
            if (rs.next()) {

                int top_id = rs.getInt("top_id");
                topname = rs.getString("topname");
                topprice = rs.getDouble("top_price");

                t = new Topping(top_id, topname, topprice);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return t.getTop_Price();
    }

    /**
     * Her fås en Bund, dens navn og pris fra databasen.
     *
     * @param botname is the name of the bottom you want to find in the
     * database.
     * @return the price of the botton based on the name.
     * @throws SQLException if an sql error occur.
     */
    public double getBottomPricebyName(String botname) throws SQLException {
        double botprice;
        Bottom b = new Bottom();
        try {
            String sql = "SELECT bot_id, bot_price, bottomname FROM bottomlist WHERE bottomname =" + "'" + botname + "'";
            ResultSet rs = conn.prepareStatement(sql).executeQuery();
            if (rs.next()) {
                int bot_id = rs.getInt("bot_id");
                botname = rs.getString("bottomname");
                botprice = rs.getDouble("bot_price");
                b = new Bottom(bot_id, botname, botprice);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return b.getBot_Price();
    }

    /**
     * Her fås all Bunde fra databasen.
     *
     * @return a list of all the bottoms
     * @throws SQLException if an sql error occur.
     */
    public List<Bottom> getAllBottom() throws SQLException {
        List<Bottom> cupcakeBottomList = new ArrayList();

        String sql = "SELECT bot_id, bottomname, bot_price FROM bottomlist";

        ResultSet rs = conn.prepareStatement(sql).executeQuery();
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

    //This is for test purpose.
    public static void main(String[] args) throws SQLException {
        List<LineItem> test = new ArrayList<>();
//         LineItem li = new LineItem("kage2", 11.00, 2,22.00);
//         LineItem li2 = new LineItem("kage3", 10.00, 2,20.00);
//         test.add(li);test.add(li2);
        System.out.println(test.get(0));
        System.out.println(test.get(1));
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
