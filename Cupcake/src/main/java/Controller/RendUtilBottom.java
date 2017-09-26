package Controller;

import domain.Bottom;
import java.util.List;

/**
 *
 * @author Bo Henriksen
 */
public class RendUtilBottom {

    public static String bottomTable(List<Bottom> boot) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table>\n"
                + "<tr><th>Bottom</th><th>Pris</th><th></th><th></th></tr>\n");
        for (Bottom b : boot) {
            sb.append("<tr><form action=\"products.jsp\">");
            sb.append("<td>").append(b.getBotName()).append("</td>");
            sb.append("<td>").append(b.getBot_Price()).append("</td>");
            sb.append("<td> \n <input type=\"checkbox\" name=\"bottomname\" value=\"" + b.getBotName() + "\"><br>\n\n</td>");
          
        }
        sb.append("</table>\n");
        return sb.toString();

    }

}
