package domain;

import java.util.ArrayList;
import domain.LineItem;

/**
 *
 * @author Ticondrus
 */
public class Cart {
    
    /**
     * Her oprettes en Array, LineItem, som benyttes udfyles med en kundes bestillinger af kager.
     * @return 1
     */

    @Override
    public String toString() {
        return "Cart{" + "LineItems=" + LineItems + '}';
    }

    public ArrayList<LineItem> getLineItems() {
        return LineItems;
    }

    public void setLineItems(ArrayList<LineItem> LineItems) {
        this.LineItems = LineItems;
    }

    public Cart() {
    }
    
ArrayList<LineItem> LineItems =  new ArrayList<LineItem>();

  
         

   
}
   
    
    

