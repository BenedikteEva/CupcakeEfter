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
    private boolean adminStatus;
    private double balance;

    /**
     *  Her får useren et unikt id med et navn, en kode, et password, 
     * en email, og der oprettes en boolean til at adskille brugren mellem en kunde og en admin, og endeligt får brugren en pris i form af balance.
     * @param user_id 1
     * @param userName 2
     * @param password 3
     * @param email 4
     * @param adminStatus 5
     * @param balance 6
     */
    public User(int user_id, String userName, String password, String email, boolean adminStatus, double balance) {
        this.user_id = user_id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.adminStatus = adminStatus;
        this.balance = balance;
    }

    public User(String userName, String password, String email, boolean adminStatus, double balance) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.adminStatus = adminStatus;
        this.balance = balance;
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

    public boolean isAdminStatus() {
        return adminStatus;
    }

    public double getBalance() {
        return balance;
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

    public void setAdminStatus(boolean admindStatus) {
        this.adminStatus = admindStatus;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    @Override
    public String toString() {
        return "User{" + "user_id=" + user_id + ", userName=" + userName + ", password=" + password + ", email=" + email + ", adminStatus=" + adminStatus + ", balance=" + balance + '}';
    }

    
    
    
}
