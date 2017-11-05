package Utilities;

import data.InfoToAdminMapper;
import data.UserMapper;
import domain.MakingAnException;
import domain.User;
import java.util.List;

/**
 *
 * @author BenedikteEva
 */
public class UserRendUtil {

    /**
     * Her oprettes en velkomst tekst til en kunde bruger.
     *
     * @param userWelcome The method takes a string and create a message for the
     * user.
     * @return Returns the created string.
     */
    public static String user(String userWelcome) {
        StringBuilder sb = new StringBuilder();
        User u = new User();

        sb.append("<table>\n"
                + "<tr><th>CupCake</th><th>Pris</th><th></th><th></th></tr>\n");
        sb.append("<tr><form action=\"ProductControlServlet\">");
        sb.append("<td>").append(u.getUserName()).append("</td>");
        sb.append("<td> \n <input type=\"checkbox\" name=\"cupcakename\" value=\"Welcome " + u.getUserName() + "\"><br>\n\n</td>");

        sb.append("</table>\n");
        return sb.toString();

    }

    public static String userList(List<User> userlist) throws MakingAnException {
        StringBuilder sb = new StringBuilder();

        sb.append("<table>\n"
                + "<tr><th>All Users</th><th></th></tr>\n"
                + "<tr><th>UserId  </th><th>Name  </th><th>Email  </th><th></th></tr>\n");
        for (User u : userlist) {
            sb.append("<tr><form name=\"invoice_user\" action=\"InvoiceDetailServlet\" method=\"POST\">");
            sb.append("<tr> <input type=\"hidden\" name=\"origin\" value=\"invoice_user\">");
            sb.append("<td>").append(u.getUser_id()).append("</td>");
            sb.append("<td>").append(u.getUserName()).append("</td>");
            sb.append("<td>").append(u.getEmail()).append("</td>");
            sb.append("<td> \n <input type=\"radio\" name=\"uid\" value=\"" + u.getUser_id() + "\"><br>\n\n</td>");
        }
        sb.append("</table>\n");
        sb.append("<button type=\"submit\" value=\"action\" name=\"invoice_user\">Submit</button> ");
        
        sb.append("</form>\n");
        return sb.toString();

    }
     public static String allUserNameSearch() {
        StringBuilder sb = new StringBuilder();
        sb.append("<tr><th>enter username to see users orders</th></tr>\n");

        sb.append("<tr><form name=\"invoice_detailUser\" action=\"InvoiceHistoryCustomerServlet\" method=\"POST\">"); //Method kan være skrevet forkert! action=\"InvoiceDetailServlet\" method=POST>
        sb.append("<tr> <input type=\"hidden\" name=\"origin\" value=\"invoice_detailUser\">");
        sb.append("<td>\n <input type=\"text\" name=\"username\" value=\"?\"><br>\n\n</td>"); //location.href='invoice_detail.jsp';\
        sb.append("<button type=\"submit\" value=\"action\" name=\"invoice_detailUser\">See order</button> ");
        sb.append("</form>\n");
     
        return sb.toString();

    }

                    

    public double calculateBalance(double a, double b) {
        double c = a - b;
        return c;
    }

}
