package Utilities;

import domain.User;

/**
 *
 * @author Ejer
 */
public class UserRendUtil {
    
    /**
     * Her oprettes en velkomst tekst til en kunde bruger.
     * @param userWelcome The method takes a string and create a message for the user.
     * @return Returns the created string.
     */
    public static String user(String userWelcome) {
        StringBuilder sb = new StringBuilder();
        User u = new User();
        
        sb.append("<table>\n"
                + "<tr><th>CupCake</th><th>Pris</th><th></th><th></th></tr>\n");
    
            sb.append("<tr><form action=\"ProductControlServlet\">");
            sb.append("<td>").append(u.getUserName()).append("</td>");
            sb.append("<td> \n <input type=\"checkbox\" name=\"cupcakename\" value=\"Welcome " + u.getUserName() + "\"><br>\n\n</td>");
       
        sb.append("</table>\n");
        return sb.toString();

    }
    
    public double calculateBalance (double a, double b){
        double c = a-b;
        return c;
    }
    
    
}
