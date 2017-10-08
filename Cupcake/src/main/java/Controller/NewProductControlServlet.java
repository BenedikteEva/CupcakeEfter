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
import java.sql.Date;
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
 * @author BenedikteEva
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
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException ServletException if a servlet-specific error
     * occurs
     * @throws IOException IOException if an I/O error occurs
     * @throws SQLException SQLException if an SQL error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
//Sessionen kaldes
        HttpSession session = request.getSession();
// her får vi fat i de mapper og utility classer der skal bruges        
        UserMapper um = new UserMapper();
        RendUtilCupCake rucc = new RendUtilCupCake();
        CupcakeMapper cupcakeList = new CupcakeMapper();
        LineItemsMapper lim = new LineItemsMapper();
        InfoToAdminMapper itam = new InfoToAdminMapper();
// herunder er der koden til hvad der sker når user vælger kager, vælger antal, 
// adder to shopping cart og trykker på checkout
        try (PrintWriter out = response.getWriter()) {
// får fat i hidden             
            String origin = request.getParameter("origin");
// den user der er gemt i sessions ved login kaldes
            User user = (User) session.getAttribute("user");
// vi har ikke sat et cart i sessionen endnu så dette cart er null det bliver initieret 
// længere nede når kunden får brug for det
            List<LineItem> cart = (List<LineItem>) session.getAttribute("cart");
            int invoiceId = itam.getLastInvoiceId(0) + 1;
            session.setAttribute("invoiceId", invoiceId);
            int userid = user.getUser_id();
            LineItem li = null;
            switch (origin) {

                case "addProduct":

                    // de parametre vi får brug for undervejs i koden til at putte i indkøbskurven
                    double cupcakeprice;
                    double totalprice;
                    int qty;
                    double totalPriceInvoice = 0;
                    double tempBalance = 0;
                    String cupcakename;

                    String checkout = request.getParameter("checkout");

                    if (checkout == null) {

                        qty = Integer.parseInt(request.getParameter("quantity"));
                        String top = (String) request.getParameter("topname");
                        String bot = (String) request.getParameter("bottomname");
                        cupcakename = rucc.createCakeName(bot, top);
                        cupcakeprice = rucc.calculateCakePrice(cupcakeList.getBottomPricebyName(bot), cupcakeList.getToppingPricebyName(top));
                        totalprice = (qty * cupcakeprice);

                        if (cart == null) {

                            cart = new ArrayList<>();
                            session.setAttribute("cart", cart);

                        }

                        li = new LineItem(invoiceId, qty, cupcakename, cupcakeprice, totalprice);
                        request.setAttribute("li", li);
                        cart.add(li);
                        try {
                            int addLineItemToDb = lim.addLineItemToDb(li);
                        } catch (Exception ex) {
                            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        totalPriceInvoice = computeTotal(cart, totalPriceInvoice);
                        tempBalance = computeTempBalance(um, user, totalPriceInvoice);

                        session.setAttribute("tempBalance", tempBalance);
                        session.setAttribute("totalPriceInvoice", totalPriceInvoice);

                        request.getRequestDispatcher("products.jsp").forward(request, response);

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

    //hjælpemetoder til ar udregne nogle doubles
    private double computeTempBalance(UserMapper um, User user, double totalPriceInvoice) throws SQLException {
        double tempBalance;
        tempBalance = um.getUserData(user.getUserName()).getBalance() - totalPriceInvoice;
        return tempBalance;
    }

    private double computeTotal(List<LineItem> cart, double totalPriceInvoice) {

        for (int i = 0; i < cart.size(); i++) {
            totalPriceInvoice += cart.get(i).getTotalPrice();
        }
        return totalPriceInvoice;
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
            response.sendRedirect("/products.jsp");

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
