package Controller;

import data.InfoToAdminMapper;
import data.UserMapper;
import domain.User;
import java.io.IOException;
import java.io.PrintWriter;
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
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        try (PrintWriter out = response.getWriter()) {
           
            String origin = request.getParameter("origin");
            User user = (User) session.getAttribute("user");
            UserMapper um = new UserMapper();
            InfoToAdminMapper itam = new InfoToAdminMapper();
            
           String invoicetext = ("Dear  " + user.getUserName() + "  " + session.getAttribute("cart") + " Total Price : "
                                + session.getAttribute("totalPriceInvoice") + "\n\n Thank you for buying our CupCakes");
            
            switch (origin) {

                case "buyMoreProducts":

                    try {
                        um.changeUserBalance(user.getUserName(), (double) session.getAttribute("tempBalance"));

                        

//                        itam.addConfirmation(user.getUser_id(), invoicetext);

                        request.setAttribute("invoicetext", invoicetext);

                    } catch (Exception ex) {
                        Logger.getLogger(ShoppingCartServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    request.getRequestDispatcher("confirmation.jsp").forward(request, response);
                    break;

//                case "shoppingcart":
//                    request.getRequestDispatcher("confirmation.jsp").forward(request, response);
//                    break;
                default:
                    throw new AssertionError();
            }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
