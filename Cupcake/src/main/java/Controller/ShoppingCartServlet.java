package Controller;

import Utilities.RendUtilCupCake;
import data.CupcakeMapper;
import data.InfoToAdminMapper;
import data.LineItemsMapper;
import data.UserMapper;
import domain.LineItem;
import domain.Order;
import domain.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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

            String origin = request.getParameter("origin");
            User user = (User) session.getAttribute("user");
            UserMapper um = new UserMapper();
            InfoToAdminMapper itam = new InfoToAdminMapper();

            response.setContentType("text/html;charset=UTF-8");
            
            RendUtilCupCake rucc = new RendUtilCupCake();
            CupcakeMapper cupcakeList = new CupcakeMapper();
            LineItemsMapper lim = new LineItemsMapper();

            List<LineItem> cart = (List<LineItem>) session.getAttribute("cart");

            int userid = user.getUser_id();
            LineItem li = null;
            
            String invoicetext = ("Dear  " + user.getUserName() + "  " + session.getAttribute("cart") + " Total Price : "
                    + session.getAttribute("totalPriceInvoice") + "\n\n Thank you for buying our CupCakes");

            try {
                //Hent userid
                int userId = um.getUserData(user.getUserName()).getUser_id();

                Order or = new Order();
                //Sætter user id på ordre objektet
                or.setUser_id(userId);
                session.setAttribute("userId", userId);

                //Skriver ordren til orderlist. Mangler timestamp
                lim.addOrderToOrderList(or);
                
                //Lægger ordren over i li
                li = (LineItem) session.getAttribute("li");

                try {
                    lim.addLineItemToDb(li); //Skriver ordren til databasen
                } catch (Exception ex) {
                    Logger.getLogger(ShoppingCartServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                //Det som stod før
                um.changeUserBalance(user.getUserName(), (Double) session.getAttribute("tempBalance"));

                double ubchangerd = um.getUserData(user.getUserName()).getBalance();
//                        itam.addConfirmation(user.getUser_id(), invoicetext);
                request.setAttribute("invoicetext", invoicetext);
                request.setAttribute("ubchangerd", ubchangerd);

            } catch (SQLException ex) {
                um.changeUserBalance(user.getUserName(), (Double) session.getAttribute("tempBalance"));
            }
            request.getRequestDispatcher("confirmation.jsp").forward(request, response);

        }

    }

    private void SetTempBalanceAndTotalinvoice(double totalPriceInvoice, List<LineItem> cart, UserMapper um, User user, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException {
        double tempBalance;
        for (int i = 0; i < cart.size(); i++) {
            totalPriceInvoice += cart.get(i).getTotalPrice();
        }
        tempBalance = um.getUserData(user.getUserName()).getBalance() - totalPriceInvoice;
        request.setAttribute("tempBalance", tempBalance);
        session.setAttribute("tempBalance", tempBalance);
        session.setAttribute("totalPriceInvoice", totalPriceInvoice);
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
