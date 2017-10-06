package domain;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.util.Date;

/**
 *
 * @author Ticondrus
 */
public class Order {
    
    

    public Order() {
        
    }
    
    /**
     * Her oprettes nogle af attributterne (eller resten f attirbutterne) for en order.
     * @param order_id 1
     * @param user_id 2
     * @param date 3
     * @param confirmation 4
     */

    public Order(int order_id, int user_id, Date date, String confirmation) {
       this.order_id = order_id;
        this.reciveddate = reciveddate;
        this.user_id=user_id;
        this.confirmation = confirmation;
    }

    @Override
    public String toString() {
        return "Order{" + "order_id=" + order_id + ", reciveddate=" + reciveddate + ", Users=" + user_id + ", confirmation=" + confirmation + '}';
    }

    private int order_id;
    private Date reciveddate;
    private int user_id;
    private String confirmation;

    public Order(int order_id, Date reciveddate, User Users, String confirmation) {
        this.order_id = order_id;
        this.reciveddate = reciveddate;
        this.user_id = user_id;
        this.confirmation = confirmation;
    }

    public Order(int order_id, Date reciveddate) {
        this.order_id = order_id;
        this.reciveddate = reciveddate;
    }

    public Order(int invoiceid) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation;
    }

    public int getOrder_id() {
        return order_id;
    }

   

    public Date getReciveddate() {
        return reciveddate;
    }

    public void setReciveddate(Date reciveddate) {
        this.reciveddate = new Date();
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

 

}
