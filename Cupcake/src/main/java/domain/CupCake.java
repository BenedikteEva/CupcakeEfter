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
public class CupCake {
    
    private int cupcake_id;

    CupCake() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getCupcake_id() {
        return cupcake_id;
    }

    public void setCupcake_id(int cupcake_id) {
        this.cupcake_id = cupcake_id;
    }

    public String getCupcakeName() {
        return cupcakeName;
    }

    public void setCupcakeName(String cupcakeName) {
        this.cupcakeName = cupcakeName;
    }

    public double getCupCakePrice() {
        return cupCakePrice;
    }

    public void setCupCakePrice(double cupCakePrice) {
        this.cupCakePrice = cupCakePrice;
    }

    public Topping getTop() {
        return top;
    }

    public void setTop(Topping top) {
        this.top = top;
    }

    public Bottom getBots() {
        return Bots;
    }

    public void setBots(Bottom Bots) {
        this.Bots = Bots;
    }
    private String cupcakeName;
    private double cupCakePrice;
    
    Topping top = new Topping();
    Bottom Bots = new Bottom();

    public CupCake(int cupcake_Id, String cupcakeName, double cupcake_Price) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
