/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static data.DBConnector.getConnection;
import domain.Bottom;
import domain.CupCake;
import domain.LineItem;
import domain.Topping;
import domain.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ticondrus
 */
public class ShoppingCartMapper {

     public ArrayList<LineItem> getAllShoppingcartData() throws SQLException {
    ArrayList<LineItem> lineItemsall = new ArrayList<LineItem>();
    
         System.out.println(lineItemsall);
         return null;
         
     }
}

         
   // String sql = "SELECT invoice_id, botname, bot_Price, topname, top_price FROM shoppingcartlist, bottomlist, toppinglist";
   // ResultSet rs = getConnection().prepareStatement(sql).executeQuery();
   // int lastId = -1;
     

   
   
    

  //  while (rs.next () ) { throwsSQLException {
  //      int invoice_id = rs.getInt("invoice_id");
  //      if (invoice_id != lastId) {
  //          String botlLI = rs.getString("botlLI");
  //          String topLI = rs.getString("topLI");
  //          liningTheItems = new LineItem{invoice_id, topLI, botlLI};
  //          lineItemsall.add(liningTheItems);
  //      }
   //         person.addPhone(new Phone(rs.getString("phoneNo"), rs.getString("description")));
   //         lastId = personId;
   // }
   // return lineItemsall;
    
     
     
    
//    public static void /*main*/(String[] args) throws SQLException {
//        ShoppingCartMapper scm = new ShoppingCartMapper();
//        //Recipe p = new Recipe("Kalle", "Karlsen");
//        System.out.println("ShoppingCart:");
//        System.out.println(scm.getAllShoppingcartData());
        

        
        //try {
//            int id = pm.addPerson(p); 
//            pm.addPhone(id, "11334355", "mobile"); 
//            pm.addPhone(id, "22340443", "home"); 
            //pm.getAllRecipe().forEach(recipe->System.out.println(recipe));
            

        //} catch (Exception ex) {
            //ex.printStackTrace();
        
//    }
    
    
