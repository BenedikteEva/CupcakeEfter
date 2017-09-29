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

            CupcakeMapper cupcakeList = new CupcakeMapper();
            List<LineItem> shoppingCart = new ArrayList<>();
            RendUtilCupCake rucc = new RendUtilCupCake();

            UserMapper um = new UserMapper();
            String[] chosenName = request.getParameterValues("checkbox");
            String topname = request.getParameter("topname");
            String botname = request.getParameter("bottomname");

            //Sessionen kaldes
            HttpSession session = request.getSession();

            //Vi caster "user" da vi bruger det som et objekt
            User uname = (User) session.getAttribute("user");
            
            out.println("<div class=column><h2>Welcome back  " + uname.getUserName() + "</h2></div><br>");
            out.println("<h3>Your account balance is: " + uname.getBalance() + "</h3>");

            if (topname != null && botname != null) {
                String cupcakename = rucc.createCakeName(botname, topname);
                double cupcakeprice = rucc.calculateCakePrice(cupcakeList.getBottomPricebyName(botname), cupcakeList.getToppingPricebyName(topname));
                request.setAttribute("cupcakeprice", cupcakeprice);
                request.setAttribute("cupcakename", cupcakename);
                out.println("<a>" + cupcakename + "</a><td><td>");
                out.println("<a>" + cupcakeprice + "</a>");

                String[] s = request.getParameterValues("Quantity");
                try {
                    double qty = Double.parseDouble(request.getParameter("quantity"));

                    if (qty > 0) {
                        cupcakeprice = Double.parseDouble(request.getParameter("cupcakeprice"));
                        cupcakename = rucc.createCakeName(botname, topname);
                        double typeCupCakeprice = qty * cupcakeprice;
                        request.setAttribute("typeCupCakeprice", typeCupCakeprice);

                        out.println("<a>test</a>");

                    } else {
                        if (qty != 0 && topname == null && botname == null) {
                            out.println("<a> go play with the dog</a>");
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
//  request.getRequestDispatcher("products.jsp").forward(request, response);
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
