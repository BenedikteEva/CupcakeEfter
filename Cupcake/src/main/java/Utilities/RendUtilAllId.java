package Utilities;

import domain.InfoToAdmin;
import java.util.List;

/**
 *
 * @author Bo Henriksen
 */
public class RendUtilAllId {
    
    public static String allInvoiceIdTabel(List<InfoToAdmin> allId) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table>\n"
                + "<tr><th>Invoices</th><th></th><th></th></tr>\n");
        for (InfoToAdmin i : allId) {
            sb.append("<tr><form action=\"admin_page.jsp\">");
            sb.append("<td>").append(i.getInvoiceId()).append("</td>");
            //sb.append("<td>").append(i.getInvoiceId()).append("</td>");
            //sb.append("<td> \n <input type=\"checkbox\" name=\"id\" value=\"" + i.getInvoiceId() + "\"><br>\n\n</td>");
            sb.append("</tr>\n");
        }
        sb.append("</table>\n");
        return sb.toString();

    }
    
}
