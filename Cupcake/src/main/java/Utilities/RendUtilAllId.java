package Utilities;

import domain.Order;
import java.util.List;

/**
 *
 * @author Bo
 */
public class RendUtilAllId {

    public static String allInvoiceIdTabel(List<Order> allId) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table>\n"
                + "<tr><th>Invoices</th><th></th><th></th></tr>\n"
                + "<tr><th>InvoiceId</th><th>Date</th><th></th></tr>\n");
        for (Order o : allId) {

            sb.append("<tr><form name=\"invoice_detail\" action=\"InvoiceDetailServlet\" method=\"POST\">"); 
            sb.append("<tr> <input type=\"hidden\" name=\"origin\" value=\"invoice_detail\">");
            sb.append("<td>").append("" + o.getOrder_id()).append("</td>");
            sb.append("<td>").append("" + o.getReciveddate()).append("</td>");
            sb.append("<td>\n <input type=\"radio\" name=\" oid\" value=\"" + o.getOrder_id() + "\"><br>\n\n</td>"); //location.href='invoice_detail.jsp';\
            sb.append("</tr>\n");
        }
        sb.append("</table>\n");
        sb.append("<button type=\"submit\" value=\"action\" name=\"invoice_detail\">See order</button> ");
        sb.append("</form>\n");
        return sb.toString();

    }
}
