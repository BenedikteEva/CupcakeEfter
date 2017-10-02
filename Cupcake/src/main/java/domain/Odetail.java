package domain;

/**
 *
 * @author Ticondrus
 */
public class Odetail {
    
    private int qty;
    private double priceprcc;
    
    public Odetail(int qty, double priceprcc) {
        this.qty = qty;
        this.priceprcc = priceprcc;
    }
    
    public Odetail() {
        
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPriceprcc() {
        return priceprcc;
    }

    public void setPriceprcc(double priceprcc) {
        this.priceprcc = priceprcc;
    }

    @Override
    public String toString() {
        return "Odetail{" + "qty=" + qty + ", priceprcc=" + priceprcc + '}';
    }
    
    
    
    
    
}
