package domain;

import java.util.ArrayList;

/**
 *
 * @author Ejer
 */
public class ShoppingCart {
    private ArrayList <LineItem>cart;
    private User user;
    

    /**
     * Construct a new ShoppingCart for the customer.
     *
     * @param user - user is the customers userename in the object User. That holdes the information about the user.
     * @see User
     */
    
    public ShoppingCart(User user) {
	
    }

    /** 
     * Add the specified LineItem to this ShoppingCart.
     *
     * @param li the LineItem to be added to this ShoppingCart.
     */
    public void addProduct(LineItem li) {
	cart.add(li);
    }

    /**
     * Get a string describing the contents of this ShoppingCart.
     *
     * @return a string describing the contents of this ShoppingCart.
     */
    public String getContents() {
	String s = "";
	// Get the description of each LineItemProduct in this ShoppingCart
	// and append it to the end of a String, producing one long
	// string describing all of the Products. 
	for (int i=0; i<cart.size(); i++) {
	    Object obj = cart.get(i);
	    LineItem li = (LineItem)obj;
	    s = s + "\n" + li.toString();
	}
	return s;
    }

     /**
     * Get the total price of all of the LineItems contained
     * in this ShoppingCart.
     *
     * @return the total price of all LineItems in this 
     *         ShoppingCart.
     */
    public double getTotalOrderPrice() {
	double totalOrderPrice = 0;
	// Get the price of each LineItem in this ShoppingCart and
	// add it to the totalPrice.  
	for (int i=0; i<cart.size(); i++) {
	    Object obj = cart.get(i);
	    LineItem li = (LineItem)obj;
	    totalOrderPrice = totalOrderPrice + li.getTotalPrice();
	}
	return totalOrderPrice;
    }

    /**
     * Remove the specified LineIte, from this ShoppingCart.
     *
     * @param li the LineItem to be removed from this ShoppingCart.
     */
    public void removeLineItem(LineItem li) {
	cart.remove(li);
    }
    
     public String getUserName() {
	return user.getUserName();
    }

    public int getItemCount() {
	return cart.size();
    }
}    


