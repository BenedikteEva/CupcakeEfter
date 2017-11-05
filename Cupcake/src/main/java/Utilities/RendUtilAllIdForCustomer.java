package Utilities;

import data.InfoToAdminMapper;
import domain.MakingAnException;
import domain.Order;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Bo
 */
public class RendUtilAllIdForCustomer {
    
    public static String allInvoiceIdTabelCustomer(List<Order> allId) {
    StringBuilder sb = new StringBuilder();
        sb.append("<table>\n"
                + "<tr><th></th><th></th></tr>\n"
         + "<tr><th>InvoiceId</th><th>Date</th><th></th></tr>\n");
        for (Order o : allId) {
   
            sb.append("<tr><form name=\"invoice_detail\" action=\"InvoiceHistoryCustomerServlet\" method=\"POST\">"); //Method kan være skrevet forkert! action=\"InvoiceDetailServlet\" method=POST>
            sb.append("<tr> <input type=\"hidden\" name=\"origin\" value=\"invoice_detail\">");
            sb.append("<td>").append("" + o.getOrder_id()).append("</td>");
            sb.append("<td>").append("" + o.getReciveddate()).append("</td>");
//            sb.append("<td>\n <input type=\"hidden\" name=\" orderid\" value=\""+o.getOrder_id()+"\"><br>\n\n</td>"); //location.href='invoice_detail.jsp';\
            sb.append("<td>\n <input type=\"radio\" name=\"id\" value=\""+o.getOrder_id()+"\"><br>\n\n</td>"); //location.href='invoice_detail.jsp';\
            sb.append("</tr>\n");
        }
        sb.append("</table>\n"); 
        sb.append("<button type=\"submit\" value=\"action\" name=invoice_detail\">See order</button> " );
        sb.append("</form>\n");
        return sb.toString();

    }
    
    public static List<Order> setAllId (String userName) throws SQLException, MakingAnException{
          InfoToAdminMapper infoToAdmin = new InfoToAdminMapper();
                   int user_id = infoToAdmin.getUserIdByUserName(userName);                  
                   List<Order> allId = infoToAdmin.getOrdersByUserId(user_id);
        return allId;
    }
}
