package Utilities;

import domain.LineItem;
import java.util.List;

/**
 *
 * @author Bo Henriksen
 */
public class RendUtilAllId {
    
    /**
     * TODO Generates a tabel with invoice id's.
     * Still needs some work.
     * @param allId allId is the list og all the invoice id's.
     * @return Returns a tabel with all the invoice id's.
     */
    public static String allInvoiceIdTabel(List<LineItem> allId) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table>\n"
                + "<tr><th>Invoices</th><th></th><th></th></tr>\n");
        for (LineItem i : allId) {
            sb.append("<tr><form action=\"#\" method=POST>"); //Method kan være skrevet forkert! action=\"InvoiceDetailServlet\" method=POST>
            sb.append("<td>").append("Invoice " + i.getInvoiceId()).append("</td>");
            //sb.append("<a href=invoice_detail.jsp").append(i.getInvoiceId()).append(">").append(i).append("</a>\n");

            sb.append("<td> \n <input type=\"button\" onclick=\"location.href='#';\" name=\"id").append("\" value=\"Details for invoice ").append(i.getInvoiceId()).append("\"><br>\n\n</td>"); //location.href='invoice_detail.jsp';\
            
            //sb.append("<td> \n <input name=\"id\" value=\"" + i.getInvoiceId()
                    //+ "\"><br>\n\n</td>");
            
            sb.append("</tr>\n");
        }
        sb.append("</table>\n");
        return sb.toString();

    }

}
