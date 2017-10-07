/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import domain.CupCake;
import domain.User;
import java.util.List;

/**
 *
 * @author BenedikteEva
 */
public class UserRendUtil {
    
    /**
     * Her oprettes en velkomst tekst til en kunde bruger.
     * @param userWelcome
     * @return 
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
