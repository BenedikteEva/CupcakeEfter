package domain;

import java.util.Date;

/**
 *
 * @author Ticondrus
 */
public class Order {

    public Order() {

    }

    /**
     * Her oprettes nogle af attributterne (eller resten f attirbutterne) for en
     * order.
     *
     * @param order_id 1
     * @param user_id 2
     * @param reciveddate 3
     * @param confirmation 4
     */
    private int order_id;
    private String reciveddate;
    private int user_id;
    private String confirmation;

    public Order(int order_id, int user_id, String reciveddate, String confirmation) {
        this.order_id = order_id;
        this.reciveddate = reciveddate;
        this.user_id = user_id;
        this.confirmation = confirmation;
    }

    public Order(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Order{" + "order_id=" + order_id + ", reciveddate=" + reciveddate + ", user_id=" + user_id + ", confirmation=" + confirmation + '}';
    }

    public Order(int order_id, String reciveddate, int user_id, String confirmation) {
        this.order_id = order_id;
        this.reciveddate = reciveddate;
        this.user_id = user_id;
        this.confirmation = confirmation;
    }

    public Order(int order_id, String reciveddate) {
        this.order_id = order_id;
        this.reciveddate = reciveddate;
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

    public String getReciveddate() {
        return reciveddate;
    }

    public void setReciveddate(String reciveddate) {
        this.reciveddate = reciveddate;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

}
