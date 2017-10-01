/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Utilities.RendUtilCupCake;
import static Utilities.UserRendUtil.user;
import data.CupcakeMapper;
import data.UserMapper;
import domain.LineItem;
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
import static sun.swing.SwingUtilities2.submit;
import static sun.swing.SwingUtilities2.submit;

/**
 *
 * @author Ejer
 */
@WebServlet(name = "NewProductControlServlet", urlPatterns = {"/NewProductControlServlet"})
public class NewProductControlServlet extends HttpServlet {

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

            String origin = request.getParameter("origin");
            //Sessionen kaldes
            HttpSession session = request.getSession();

            User user = (User) session.getAttribute("user");
            UserMapper um = new UserMapper();
            RendUtilCupCake rucc = new RendUtilCupCake();
            CupcakeMapper cupcakeList = new CupcakeMapper();
            switch ("origin") {

                case "checkout":
                    request.getRequestDispatcher("confirmation.jsp").forward(request, response);
                    break;

                case "shoppingcart":
                    try {

                        List<LineItem> shoppingCart = new ArrayList<>();

                        int qty = Integer.parseInt((String) request.getAttribute("quantity"));

                        if (qty > 0) {

                            double typeCupCakeprice = qty * (int) session.getAttribute("cupcakeprice");
                            session.setAttribute("typeCupCakeprice", typeCupCakeprice);
                            LineItem li = new LineItem((String) session.getAttribute("cupcakename"), (double) session.getAttribute("cupcakeprice"), (int) session.getAttribute("qty"), typeCupCakeprice);
                            shoppingCart.add(li);
                            session.setAttribute("li", li);
                            session.setAttribute("shoppingCart", shoppingCart);

                            request.getRequestDispatcher("products.jsp").forward(request, response);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    break;

                case "cupcakeshow":
                    String[] chosenName = request.getParameterValues("checkbox");
                    String topname = request.getParameter("topname");
                    String botname = request.getParameter("bottomname");
                    if (topname != null && botname != null) {
                        String cupcakename = rucc.createCakeName(botname, topname);

                        double cupcakeprice = rucc.calculateCakePrice(cupcakeList.getBottomPricebyName(botname), cupcakeList.getToppingPricebyName(topname));
                        session.setAttribute("cupcakeprice", cupcakeprice);
                         request.setAttribute("cupcakeprice",cupcakeprice );
                        session.setAttribute("cupcakename", cupcakename);
                        request.setAttribute("cupcakename", cupcakename);

                        request.getRequestDispatcher("products.jsp").forward(request, response);
                    }

                    break;

                default:
                    throw new AssertionError();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
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
            Logger.getLogger(NewProductControlServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(NewProductControlServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
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
