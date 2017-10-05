package domain;

import java.util.Date;

/**
 *
 * @author Ticondrus
 */
public class Order {

    private int order_id;
    private Date reciveddate;
    private User Users;
    private String confirmation;

    public Order(int order_id, Date reciveddate, User Users, String confirmation) {
        this.order_id = order_id;
        this.reciveddate = reciveddate;
        this.Users = Users;
        this.confirmation = confirmation;
    }

    public Order(int order_id, Date reciveddate) {
        this.order_id = order_id;
        this.reciveddate = reciveddate;
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

    public User getUsers() {
        return Users;
    }

    public Date getReciveddate() {
        return reciveddate;
    }

    public void setReciveddate(Date reciveddate) {
        this.reciveddate = reciveddate;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setUsers(User Users) {
        this.Users = Users;
    }

}
