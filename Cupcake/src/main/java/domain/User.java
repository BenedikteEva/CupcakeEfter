package domain;

/**
 * The class User is our object for user and admin.
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
     * This constructor create the object User. It is used at the UsserMapper to get alle the details about a user and admin from the database.
     * @see data.UserMapper#getUserData(String username)
     * @param user_id A unik number to identify the user.
     * @param userName The user name.
     * @param password The password for the user.
     * @param email The email for the user.
     * @param adminStatus If the user is admin this is true.
     * @param balance How much credit the user has.
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

    public User(String name, String password) {
      this.userName = userName;
        this.password = password;
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
