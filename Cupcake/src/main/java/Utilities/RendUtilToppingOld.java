package Utilities;

import static Utilities.RendUtilToppingOld.toppingTable;
import domain.Topping;
import java.util.List;

/**
 *
 * @author Bo Henriksen
 */
public class RendUtilToppingOld {
    
    /**
     * Her generes en liste af Toppings.
     * @param topps
     * @return 
     */

    public static String toppingTable(List<Topping> topps) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table>\n"
                + "<tr><th>Topping</th><th>Pris</th><th></th><th></th></tr>\n");
        for (Topping t : topps) {
            sb.append("<tr><form action=\"NewProductControlServlet\" name=\"toppings\">");
            sb.append("<td>").append(t.getTopname()).append("</td>");
            sb.append("<td>").append(t.getTop_Price()).append("</td>");
            sb.append("<td> \n <input type=\"checkbox\" name=\"topname\" value=\"" + t.getTopname() + "\"><br>\n\n</td>");
            sb.append("</tr>\n");
        }
        sb.append("</table>\n");
        return sb.toString();

    }

}
