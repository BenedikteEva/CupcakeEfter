package Utilities;

import domain.Odetail;
import java.util.List;

/**
 *
 * @author Bo
 */
public class RendUtilAllIdForCustomer {
    
    public static String allInvoiceIdTabelCustomer(List<Odetail> allId) {
    StringBuilder sb = new StringBuilder();
        sb.append("<table>\n"
                + "<tr><th>Invoices</th><th></th><th></th></tr>\n"
         + "<tr><th>InvoiceId</th><th>Date</th><th></th></tr>\n");
        for (Odetail o : allId) {
   
            sb.append("<tr><form name=\"invoicecustomer\" action=\"InvoiceHistoryCustomerServlet\" method=\"POST\">"); //Method kan være skrevet forkert! action=\"InvoiceDetailServlet\" method=POST>
           sb.append("<tr> <input type=\"hidden\" name=\"onemore\" value=\"invoicecustomer\">");
            sb.append("<td>").append("" + o.getOrder_id()).append("</td>");
            sb.append("<td>").append("" + o.getReceived()).append("</td>");
            sb.append("<td>\n <input type=\"radio\" name=\" orderid\" value=\""+o.getOrder_id()+"\"><br>\n\n</td>"); //location.href='invoice_detail.jsp';\
            sb.append("</tr>\n");
        }
        sb.append("</table>\n"); 
        sb.append("<button type=\"submit\" value=\"action\" name=invoicecustomer\">See order</button> " );
        sb.append("</form>\n");
        return sb.toString();

    }
}