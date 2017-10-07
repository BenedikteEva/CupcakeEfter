package Utilities;

import domain.LineItem;
import java.util.List;

/**
 *
 * @author Bo Henriksen
 */
public class RendUtilInvoice {
    
    /**
     * This method is not not finished and not implemented. The method is going to make a table with all the invoice information.
     * The sql query to get the invoice details is wrong.
     * @see data.InfoToAdminMapper#getODetail(int invoiceID) The sql querry needs to be changed.
     * @param info info is the name of the list that holds all the line items.
     * @return Returns a table with all the invoice information
     */
    public static String invoiceTable(List<LineItem> info) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table>\n"
                + "<tr><th>Invoice number</th><th>Quantity</th><th>Name</th><th>Price pr. cake</th><th>Total Price</th></tr>\n");
        for (LineItem i : info) {
            sb.append("<tr><form action=\"products.jsp\">");
            sb.append("<td>").append(i.getInvoiceId()).append("</td>");
            sb.append("<td>").append(i.getQuantity()).append("</td>");
            sb.append("<td>").append(i.getCupcakeName()).append("</td>");
            sb.append("<td>").append(i.getPricePrCc()).append("</td>");
            sb.append("<td>").append(i.getTotalPrice()).append("</td>");
            //sb.append("<td> \n <input type=\"checkbox\" name=\"bottomname\" value=\"" + i.getBotName() + "\"><br>\n\n</td>");
          
        }
        sb.append("</table>\n");
        return sb.toString();

    }
    
}
