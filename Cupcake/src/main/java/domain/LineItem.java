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
public class LineItem {


//    static void add(String invoice_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    public int invoice_id;
//   private User u = new User();
  
    private String cupcakename;
    private double cupcakepriceapiece;
    private int quantity;
    private double totalprice;

    public LineItem(String cupcakename, double cupcakepriceapiece, int quantity, double totalprice) {

        this.cupcakename = cupcakename;
        this.cupcakepriceapiece = cupcakepriceapiece;
        this.quantity = quantity;
        this.totalprice = totalprice;
    }

    public String getAllLineItems() {
        return cupcakename + cupcakepriceapiece + quantity + totalprice;
    }

    public String getCupcakename() {
        return cupcakename;
    }

    public void setCupcakename(String cupcakename) {
        this.cupcakename = cupcakename;
    }

    public double getCupcakepriceapiece() {
        return cupcakepriceapiece;
    }

    public void setCupcakepriceapiece(double cupcakepriceapiece) {
        this.cupcakepriceapiece = cupcakepriceapiece;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }
    
    
    @Override
    public String toString() {
        return quantity+"  " +cupcakename + " à " + cupcakepriceapiece + " fiktive currency pr. cake       total=" + totalprice + '}';
    }
 
}

/*I lineItem skal der være String cupcakename double cupcakepriceapiece int quantity 
og double totalprice*/
