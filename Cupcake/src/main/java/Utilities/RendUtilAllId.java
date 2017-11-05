package Utilities;

import domain.MakingAnException;
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
     * @throws domain.MakingAnException
     */
    public static String allInvoiceIdTabel(List<Order> allId) throws MakingAnException {
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
        sb.append("<button type=\"submit\" value=\"action\" name=\"invoice_detail\">See order</button> " );
        sb.append("</form>\n");
        return sb.toString();

    }
    
      public static String allInvoiceIdSearch()  {
        StringBuilder sb = new StringBuilder();
        sb.append("<tr><th>enter InvoiceId to see invoicedetail</th></tr>\n");
    
            sb.append("<tr><form name=\"invoice_detail\" action=\"InvoiceDetailServlet\" method=\"POST\">"); //Method kan være skrevet forkert! action=\"InvoiceDetailServlet\" method=POST>
            sb.append("<tr> <input type=\"hidden\" name=\"origin\" value=\"invoice_detail\">");
            sb.append("<td>\n <input type=\"number\" name=\"id\" value=\"orderid\"><br>\n\n</td>"); //location.href='invoice_detail.jsp';\
        sb.append("<button type=\"submit\" value=\"action\" name=\"invoice_detail\">See order</button> " );
        sb.append("</form>\n");
        return sb.toString();

    }


}
