package Controller;

import data.LineItemsMapper;
import data.UserMapper;
import domain.LineItem;
import domain.Order;
import domain.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bo Henriksen /BenedikteEva
 */
@WebServlet(name = "ShoppingCartServlet", urlPatterns = {"/ShoppingCartServlet"})
public class ShoppingCartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/html;charset=UTF-8");
            
            User user = (User) session.getAttribute("user");
            UserMapper um = new UserMapper();
            LineItemsMapper lim = new LineItemsMapper();
            List<LineItem> cart = (List<LineItem>) session.getAttribute("cart");
            LineItem li = null;

            try {
                Order or = new Order();
                //Hent userid
                int userId = um.getUserData(user.getUserName()).getUser_id();
                
                //Sætter user id på ordre objektet
                or.setUser_id(userId);
                session.setAttribute("userId", userId);

                //Laver timestamp af d.d.
                LocalDate today = LocalDate.now();
                //Kalder dateTimeFormatter
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                //Sætter Stringen til d.d.
                String formatDateTime = today.format(formatter);

                //Sætter datoen på ordren
                or.setReciveddate(formatDateTime);

                //Skriver ordren til orderlist. 
                lim.addOrderToOrderList(or);

                //Henter ordren fra session, og lægger ordren over i li
                li = (LineItem) session.getAttribute("li");
                
                //Lægger hver enkelt kage ned, hvis der er flere
                for (int i = 0; i < cart.size(); i++) {
                    try {
                        lim.addLineItemToDb(cart.get(i)); //Skriver ordren til databasen
                    } catch (Exception ex) {
                        Logger.getLogger(ShoppingCartServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                um.changeUserBalance(user.getUserName(), (Double) session.getAttribute("tempBalance"));

            } catch (SQLException ex) {
                um.changeUserBalance(user.getUserName(), (Double) session.getAttribute("tempBalance"));
            }
            request.getRequestDispatcher("confirmation.jsp").forward(request, response);

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ShoppingCartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ShoppingCartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
