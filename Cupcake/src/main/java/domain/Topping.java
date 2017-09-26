/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Ticondrus
 */
public class Topping {
    
    private int top_id;
    private String topname;
    private double top_Price;

    public Topping(int top_id, String topname, double top_Price) {
        this.top_id = top_id;
        this.topname = topname;
        this.top_Price = top_Price;
    }

    public Topping() {
    }

    @Override
    public String toString() {
        return "Topping{" + "top_id=" + top_id + ", topname=" + topname + ", top_Price=" + top_Price + '}';
    }
    
    public int getTop_id() {
        return top_id;
    }

    public String getTopname() {
        return topname;
    }

    public double getTop_Price() {
        return top_Price;
    }
    
}
