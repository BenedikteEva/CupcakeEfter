package Utilities;

import domain.LineItem;
import java.util.List;

/**
 *
 * @author Bo Henriksen
 */
public class RendUtilAllId {
    
    /**
     * Her generes en liste af LineItem
     * @param allId
     * @return 
     */

    public static String allInvoiceIdTabel(List<LineItem> allId) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table>\n"
                + "<tr><th>Invoices</th><th></th><th></th></tr>\n");
        for (LineItem i : allId) {
            sb.append("<tr><form action=\"InvoiceDetailServlet\" method=POST>"); //Method kan være skrevet forkert!
            sb.append("<td>").append("Invoice " + i.getInvoiceId()).append("</td>");
            //sb.append("<a href=invoice_detail.jsp").append(i.getInvoiceId()).append(">").append(i).append("</a>\n");

            sb.append("<td> \n <input type=\"button\" onclick=\"location.href='invoice_detail.jsp';\" name=\"id").append("\" value=\"Details for invoice ").append(i.getInvoiceId()).append("\"><br>\n\n</td>");
            
            //sb.append("<td> \n <input name=\"id\" value=\"" + i.getInvoiceId()
                    //+ "\"><br>\n\n</td>");
            
            sb.append("</tr>\n");
        }
        sb.append("</table>\n");
        return sb.toString();

    }

}
