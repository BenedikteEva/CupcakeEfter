package Controller.Utilities;

import domain.InfoToAdmin;
import java.util.List;

/**
 *
 * @author Bo Henriksen
 */
public class RendUtilAllId {
    
    public static String allInvoiceId(List<InfoToAdmin> allId) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table>\n"
                + "<tr><th>Invoices</th><th></th><th></th></tr>\n");
        for (InfoToAdmin i : allId) {
            sb.append("<tr><form action=\"products.jsp\">");
            sb.append("<td>").append(i.getInvoiceId()).append("</td>");
            //sb.append("<td>").append(i.getTop_Price()).append("</td>");
            //sb.append("<td> \n <input type=\"checkbox\" name=\"topname\" value=\"" + i.getTopname() + "\"><br>\n\n</td>");
            sb.append("</tr>\n");
        }
        sb.append("</table>\n");
        return sb.toString();

    }
    
}
