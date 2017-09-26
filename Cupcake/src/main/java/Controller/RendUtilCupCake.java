/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import domain.CupCake;
import java.util.List;

/**
 *
 * @author Ejer
 */
public class RendUtilCupCake {

    public static void cupcakeTable(List<CupCake> cuck) {
        StringBuilder sb = new StringBuilder();

        sb.append("<table>\n"
                + "<tr><th>CupCake</th><th>Pris</th><th></th><th></th></tr>\n");
        for (CupCake c : cuck) {
            sb.append("<tr><form action=\"ProductControlServlet\">");
            sb.append("<td>").append(c.getCupcake_id()).append("</td>");
            sb.append("<td>").append(c.getCupcakeName()).append("</td>");
            sb.append("<td>").append(c.getCupCakePrice()).append("</td>");
            sb.append("<td> \n <input type=\"checkbox\" name=\"cupcakename\" value=\"" + c.getCupcakeName() + "\"><br>\n\n</td>");
        }
        sb.append("</table>\n");
       

    }

    public static String cupCakeMaker(CupCake cuck) {
        StringBuilder sb = new StringBuilder();

        int cupcake_Id = 0;
        String cupcakeName = null;
        double cupcake_Price = 0;
        CupCake c = new CupCake(cupcake_Id, cupcakeName, cupcake_Price);

        sb.append("<table>\n"
                + "<tr><th>CupCake</th><th>Pris</th><th></th><th></th></tr>\n");

        sb.append("<tr><form action=\"products.jsp\">");
        sb.append("<td>").append(c.getCupcakeName()).append("</td>");
        sb.append("<td>").append(c.getCupCakePrice()).append("</td>");
        sb.append("<td> \n <input type=\"checkbox\" name=\"botname\" value=\"" + c.getCupcakeName() + "\"><br>\n\n</td>");

        sb.append("</table>\n");
        return c.getCupcakeName();

    }

    public double calculateCakePrice( double a, double b  ) {
     double c;
   c = a + b;
        return c;
    }

    public String createCakeName(String d, String e) {
        String f;
        f = d + " with " + e;
        return f;
    }
}
