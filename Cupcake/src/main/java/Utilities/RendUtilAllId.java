package Utilities;

import domain.LineItem;
import domain.Order;
import java.util.List;

/**
 *
 * @author Bo Henriksen
 */
public class RendUtilAllId {

    /**
     * TODO Generates a tabel with invoice id's. Still needs some work.
     *
     * @param allId allId is the list og all the invoice id's.
     * @return Returns a tabel with all the invoice id's.
     */
    public static String allInvoiceIdTabel(List<Order> allId) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table>\n"
                + "<tr><th>Invoices</th><th></th><th></th></tr>\n"
         + "<tr><th>InvoiceId </th><th>UserId  </th><th>Date </th><th></th></tr>\n");
        for (Order o : allId) {
   
            sb.append("<tr><form name=\"invoice_detail\" action=\"InvoiceDetailServlet\" method=\"POST\">"); //Method kan være skrevet forkert! action=\"InvoiceDetailServlet\" method=POST>
            sb.append("<tr> <input type=\"hidden\" name=\"origin\" value=\"invoice_detail\">");
            sb.append("<td>").append("" + o.getOrder_id()).append("</td>");
            sb.append("<td>").append("" + o.getUser_id()).append("</td>");
            sb.append("<td>").append("" + o.getReciveddate()).append("</td>");
            sb.append("<td>\n <input type=\"radio\" name=\"id\" value=\""+o.getOrder_id()+"\"><br>\n\n</td>"); //location.href='invoice_detail.jsp';\
            sb.append("</tr>\n");
        }
        sb.append("</table>\n");
        return sb.toString();

    }

}
