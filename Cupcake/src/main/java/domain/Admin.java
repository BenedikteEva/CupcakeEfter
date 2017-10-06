package domain;

/**
 *
 * @author Bo Henriksen
 */
public class Admin {
    
    private int adminId;
    private String adminUserName;
    private String adminEmail;
    private String adminPassword;
    
    /**
     * Her oprettes attributterne for Admin brugren, med et unikt id, et navn, email og password.
     * Programmet har en boolean, som tjekker hvorvidt brugeren er admin eller ej, og det boolean laves i user classen.
     * @param adminId 1
     * @param adminUserName 2
     * @param adminEmail 3
     * @param adminPassword 4
     */

    public Admin(int adminId, String adminUserName, String adminEmail, String adminPassword) {
        this.adminId = adminId;
        this.adminUserName = adminUserName;
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
    }
    
    public Admin() {
        
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminUserName() {
        return adminUserName;
    }

    public void setAdminUserName(String adminUserName) {
        this.adminUserName = adminUserName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Override
    public String toString() {
        return "Admin{" + "adminId=" + adminId + ", adminUserName=" + adminUserName + ", adminEmail=" + adminEmail + ", adminPassword=" + adminPassword + '}';
    }
    
    
    
}
