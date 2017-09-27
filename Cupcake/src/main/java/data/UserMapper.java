package data;

import Controller.Utilities.UserRendUtil;
import domain.Admin;
import domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bo Henriksen
 */
public class UserMapper {
    
    public User getUserData(String username) throws SQLException {
        
        User user = null;
        try {

            Connection conn = new Connector().getConnection();
            String sql = "SELECT * FROM userlist WHERE username=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            
           ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {

                int id = rs.getInt("user_id");
                String email = rs.getString("email");
                String password = rs.getString("password");
                boolean adminStatus = rs.getBoolean("admin_status");
                username = rs.getString("username"); 
                double balance = rs.getInt("balance");

                user = new User(id, username, password, email, adminStatus, balance);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return user;
    }
    
    public int addUser(User u) throws Exception {
        Connection conn = Connector.getConnection();
        String insertUser = "INSERT INTO userlist (email, password, username) VALUES (?, ?, ?)";
        PreparedStatement userPstmt = conn.prepareStatement(insertUser, Statement.RETURN_GENERATED_KEYS);

        userPstmt.setString(1, u.getEmail());
        userPstmt.setString(2, u.getPassword());
        userPstmt.setString(3, u.getUserName());
        int result = userPstmt.executeUpdate();
        ResultSet rs = userPstmt.getGeneratedKeys();
        rs.next();
        int id = rs.getInt(1);
        return id;
    }
    
 
    
    public boolean godkendBruger(User loginUser) {
        
        //Holder brugens indtastet værdier her
        String userName = loginUser.getUserName();
        String password = loginUser.getPassword();
                
        try {

            Connection conn = new Connector().getConnection();
            
            String sql = "SELECT username, password FROM userlist WHERE username=? AND password=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userName);//Det som sættes ind sql stringen
            pstmt.setString(2, password);
                      
           //ResultSet holder det som bliver hentet i databasen 
           ResultSet rs = pstmt.executeQuery();
            
           //Returner true hvis der er en next record og false hvis ikke.
           return rs.next();
//           
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }
        return false;
    }
    
    public boolean godkendAdmin(Admin adminLogin) {
        
        //Holder brugens indtastet værdier her
        String adminUserName = adminLogin.getAdminUserName();
        String adminPassword = adminLogin.getAdminPassword();
                
        try {

            Connection conn = new Connector().getConnection();
            
            String sql = "SELECT adminUser, adminPassword FROM adminList WHERE username=? AND password=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, adminUserName);//Det som sættes ind sql stringen
            pstmt.setString(2, adminPassword);
                      
           //ResultSet holder det som bliver hentet i databasen 
           ResultSet rs = pstmt.executeQuery();
            
           //Returner true hvis der er en next record og false hvis ikke.
           return rs.next();
//           
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }
        return false;
    }
    
    public Admin getAdminData(String adminUsername) throws SQLException {
        
        Admin admin = null;
        try {

            Connection conn = new Connector().getConnection();
            String sql = "SELECT * FROM adminlist WHERE username=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, adminUsername);
            
           ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {

                int id = rs.getInt("admin_id");
                String email = rs.getString("adminEmail");
                String password = rs.getString("adminPassword");
                adminUsername = rs.getString("adminUser"); 
                
                admin = new Admin(id, adminUsername, password, email);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return admin;
    }
    
       public int changeUserBalance (String username, double b) throws Exception {
        User u = null;double total=0;
        UserRendUtil uru = new UserRendUtil();
        try {
        Connection conn = new Connector().getConnection();
        String changeBalance = "UPDATE userlist set balance= (?) WHERE username ="+username;
          PreparedStatement balancePstmt = conn.prepareStatement(changeBalance, Statement.RETURN_GENERATED_KEYS);
          balancePstmt.setString(1, username);
            
          balancePstmt.setDouble(2, getUserData(username).getBalance()); // her skal der være en calculator
        
          b= uru.calculateBalance(getUserData(username).getBalance(), total);
           
          ResultSet rs = balancePstmt.executeQuery(); int result = balancePstmt.executeUpdate();
          getUserData(username).setBalance(b);
         
           if(rs.next()) {

                int id = rs.getInt("user_id");
                String email = rs.getString("email");
                String password = rs.getString("password");
                boolean adminStatus = rs.getBoolean("admin_status");
                username = rs.getString("username"); 
                 b = rs.getDouble("balance");
                u= new User(id, email , password, username, adminStatus,  b);
            }
          
        
          int id = rs.getInt(1); 
          return id;
    }
        catch (Exception ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }return 0;
}
    
    public static void main(String[] args) throws SQLException, Exception {
        UserMapper pm = new UserMapper();
        
        //Test af getUserData
        System.out.println(pm.getUserData("admin"));
        System.out.println(pm.getAdminData("admin"));
        
            pm.changeUserBalance("tr", 25.0);
            System.out.println(pm.getUserData("tr"));
    }}
        
        
        //Test af addUser
//        try {
            
//            User u = null;
//            int id = pm.addUser(u);
//            pm.addUser(id,"bo");
        
//            int id = pm.addUser(u); 
//            pm.addUser(id, "bo@bo.bo", "bo","bo"); 
//            pm.addPhone(id, "22340443", "home"); 
//            pm.getAllRecipe().forEach(recipe->System.out.println(recipe));
//            
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        
    
    

