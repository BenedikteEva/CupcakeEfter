package Controller;

import Utilities.RendUtilCupCake;
import data.CupcakeMapper;
import data.UserMapper;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domain.LineItem;
import domain.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ejer
 */
@WebServlet(name = "ProductControlServlet", urlPatterns = {"/ProductControlServlet"})
public class ProductControlServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
          
            //Sessionen kaldes
            HttpSession session = request.getSession();
            //Vi caster "user" da vi bruger det som et objekt
            User user = (User) session.getAttribute("user");
            
               

           
            List<LineItem> shoppingCart = new ArrayList<>();
            
            int qty = Integer.parseInt(request.getParameter("quantity"));
            session.setAttribute("qty", qty);
            
            
            double cupcakeprice = (double) session.getAttribute("cupcakeprice");
            String cupcakename = (String) session.getAttribute("cupcakename");
            double typeCupCakeprice = qty * cupcakeprice;
            session.setAttribute("typeCupCakeprice", typeCupCakeprice);
            double b = user.getBalance();
            // denne skal egentlig først bruges når der betales
//             um.changeUserBalance(uname, b);

            LineItem li = new LineItem(cupcakename, cupcakeprice, qty, typeCupCakeprice);
            
            shoppingCart.add(li);
            session.setAttribute("shoppingCart", shoppingCart);
//            out.println("<a> Your new balance is: " +shoppingCart.toString() + "</a>");
            

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        request.getRequestDispatcher("products.jsp").forward(request, response);

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
            Logger.getLogger(ProductControlServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProductControlServlet.class.getName()).log(Level.SEVERE, null, ex);
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
