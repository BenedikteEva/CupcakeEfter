package domain;


import java.util.Date;

/**
 *
 * @author Ticondrus
 */
public class Order {
    
    private int order_id;
    private Date reciveddate;
    User Users = new User();

    public Order(int order_id, Date reciveddate) {
        this.order_id = order_id;
        this.reciveddate = reciveddate;
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
