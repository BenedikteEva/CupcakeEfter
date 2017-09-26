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

    static void add(String invoice_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int invoice_id;
    public User u = new User();
    String cupcakename;
    

    public LineItem(int invoice_id, String cupcakename, double cupcakepriceapiece, int quantity, double totalprice) {
        this.invoice_id = invoice_id;
        this.cupcakename = cupcakename;
        this.cupcakepriceapiece = cupcakepriceapiece;
        this.quantity = quantity;
        this.totalprice = totalprice;
    }

    public LineItem(int invoice_id, String u, double top_Price) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        public String getAllLineItems() {
        return invoice_id + cupcakename + cupcakepriceapiece + quantity + totalprice;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
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
    double cupcakepriceapiece;
    int quantity;
    double totalprice;

    static class add {

        public add() {
        }
    }
}
/*I lineItem skal der være String cupcakename double cupcakepriceapiece int quantity 
og double totalprice*/
