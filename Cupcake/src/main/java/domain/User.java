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
public class User {

    private int user_id;
    private String userName;
    private String password;
    private String email;
    private boolean admindStatus;
    private double Balance;

    public User(int user_id, String userName, String password, String email, boolean admindStatus, double Balance) {
        this.user_id = user_id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.admindStatus = admindStatus;
        this.Balance = Balance;
    }

    public User(String userName, String password, String email, boolean admindStatus, double Balance) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.admindStatus = admindStatus;
        this.Balance = Balance;
    }

    public User(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }
    
    public User () {
        
    }
    
    public int getUser_id() {
        return user_id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAdmindStatus() {
        return admindStatus;
    }

    public double getBalance() {
        return Balance;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdmindStatus(boolean admindStatus) {
        this.admindStatus = admindStatus;
    }

    public void setBalance(double Balance) {
        this.Balance = Balance;
    }
    
    @Override
    public String toString() {
        return "User{" + "user_id=" + user_id + ", userName=" + userName + ", password=" + password + ", email=" + email + ", admindStatus=" + admindStatus + ", Balance=" + Balance + '}';
    }

    
    
    
}
