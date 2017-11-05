package domain;

/**
 *
 * @author Ticondrus
 */
public class Odetail {
    
    private int lineitem_id;
    private int order_id;
    private String received;
    private String ccname;
    private int quantity;
    private double priceprcc;
    private double totalprice;
    private int user_id;

    public Odetail(int lineitem_id, int order_id, String received, String ccname, int quantity, double priceprcc, double totalprice, int user_id) {
        this.lineitem_id = lineitem_id;
        this.order_id = order_id;
        this.received = received;
        this.ccname = ccname;
        this.quantity = quantity;
        this.priceprcc = priceprcc;
        this.totalprice = totalprice;
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    public Odetail(int lineitem_id, int order_id, String received, String ccname, int quantity, double priceprcc, double totalprice) {
        this.lineitem_id = lineitem_id;
        this.order_id = order_id;
        this.received = received;
        this.ccname = ccname;
        this.quantity = quantity;
        this.priceprcc = priceprcc;
        this.totalprice = totalprice;
        
    }

    public Odetail() {
    }

    public int getLineitem_id() {
        return lineitem_id;
    }

    public void setLineitem_id(int lineitem_id) {
        this.lineitem_id = lineitem_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getReceived() {
        return received;
    }

    public void setReceived(String received) {
        this.received = received;
    }

    public String getCcname() {
        return ccname;
    }

    public void setCcname(String ccname) {
        this.ccname = ccname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPriceprcc() {
        return priceprcc;
    }

    public void setPriceprcc(double priceprcc) {
        this.priceprcc = priceprcc;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    @Override
    public String toString() {
        return "Odetail{" + "lineitem_id=" + lineitem_id + ", order_id=" + order_id + ", received=" + received + ", ccname=" + ccname + ", quantity=" + quantity + ", priceprcc=" + priceprcc + ", totalprice=" + totalprice + '}';
    }

    

    
    
    
    
    
    
}
