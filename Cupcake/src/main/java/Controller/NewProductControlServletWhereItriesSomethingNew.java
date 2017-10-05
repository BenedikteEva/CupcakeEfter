/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Utilities.RendUtilCupCake;
import Utilities.ShoppingCart;
import static Utilities.UserRendUtil.user;
import data.CupcakeMapper;
import data.LineItemsMapper;
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
import javax.servlet.RequestDispatcher;
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
public class NewProductControlServletWhereItriesSomethingNew extends HttpServlet {

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

        HttpSession session = request.getSession();

        try (PrintWriter out = response.getWriter()) {

            String origin = request.getParameter("origin");

            User user = (User) session.getAttribute("user");
            UserMapper um = new UserMapper();

            switch (origin) {

                case "addProduct":

                    ShoppingCart cart = null;
                    String checkout = request.getParameter("checkout");
                    RendUtilCupCake rucc = new RendUtilCupCake();
                    CupcakeMapper cupcakeList = new CupcakeMapper();
                    double cupcakeprice;
                    double totalprice;
                    int qty;
                    String cupcakename;

                    if (checkout == null) {

                        qty = Integer.parseInt(request.getParameter("quantity"));
                        String top = (String) request.getParameter("topname");
                        String bot = (String) request.getParameter("bottomname");
                        cupcakename = rucc.createCakeName(bot, top);
                        cupcakeprice = rucc.calculateCakePrice(cupcakeList.getBottomPricebyName(bot), cupcakeList.getToppingPricebyName(top));
                        totalprice = (qty * cupcakeprice);

                        LineItem li = new LineItem(qty, cupcakename, cupcakeprice, totalprice);
                        request.setAttribute("li", li);

                        if (cart == null) {
                            cart = new ShoppingCart(user);
                            session.setAttribute("cart", cart);
                            cart.addProduct(li);
                            request.getRequestDispatcher("products.jsp").forward(request, response);

                        } else {

                            cart.addProduct(li);
                            request.getRequestDispatcher("products.jsp").forward(request, response);
                        }
                    } else {

                        request.getRequestDispatcher("shoppingCart.jsp").forward(request, response);

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
            Logger.getLogger(NewProductControlServletWhereItriesSomethingNew.class
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
            response.sendRedirect("/products.jsp");

        } catch (SQLException ex) {
            Logger.getLogger(NewProductControlServletWhereItriesSomethingNew.class
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
