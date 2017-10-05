/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import domain.LineItem;
import domain.User;
import java.util.ArrayList;

/**
 *
 * @author Ejer
 */
public class ShoppingCart {
    private ArrayList <LineItem>cart;
    private User user;

    /**
     * Construct a new ShoppingCart for the customer
     * with the specified customerID.
     *
     * @param the id of the customer for which this 
     *        ShoppingCart is being created.
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
     * Get the name of the customer who owns this ShoppingCart.
     * 
     * @param username of the customer who owns this ShoppingCart.
     */
    public String getUserName() {
	return user.getUserName();
    }

    /**
     * Get the number of LineItem contained in this ShoppingCart.
     *
     * @return the number of LineItem contained in this ShoppingCart.
     */ 
    public int getItemCount() {
	return cart.size();
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
}
    


