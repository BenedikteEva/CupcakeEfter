/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.util.Date;

/**
 *
 * @author Ticondrus
 */
public class Order {
    
    private int order_id;
    User Users = new User();
    private Date reciveddate;
    
        public int getOrder_id() {
        return order_id;
    }

    public User getUsers() {
        return Users;
    }
    
}
