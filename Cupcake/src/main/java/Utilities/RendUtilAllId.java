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
            sb.append("<tr><form action=\"InvoiceDetailServlet\" method=POST>"); //Method kan være skrevet forkert!
            sb.append("<td>").append("Invoice " +  i.getInvoiceId()).append("</td>");
            //sb.append("<a href=").append(i.getInvoiceId()).append(">").append(i).append("</a>\n");
            
            sb.append("<td> \n <input type=\"button\" onclick=\"location.href='invoice_detail.jsp';\" name=\"").append(i.getInvoiceId()).append("\" value=\"Details for invoice ").append(i.getInvoiceId()).append("\"><br>\n\n</td>");
            
            
            //sb.append("<td>").append(i.getInvoiceId()).append("</td>");
            //sb.append("<td> \n <input type=\"checkbox\" name=\"id\" value=\"" + i.getInvoiceId() + "\"><br>\n\n</td>");
            sb.append("</tr>\n");
        }
        sb.append("</table>\n");
        return sb.toString();

    }
    
}
