package Controller;

import static Utilities.UserRendUtil.user;
import data.InfoToAdminMapper;
import data.LineItemsMapper;
import data.UserMapper;
import domain.MakingAnException;
import domain.Odetail;
import domain.Order;
import domain.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
 * @author Bo
 */
@WebServlet(name = "InvoiceHistoryCustomerServlet", urlPatterns = {"/InvoiceHistoryCustomerServlet"})
public class InvoiceHistoryCustomerServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException, MakingAnException {
        response.setContentType("text/html;charset=UTF-8");
        LineItemsMapper lim = new LineItemsMapper();
        InfoToAdminMapper itam = new InfoToAdminMapper();
        UserMapper um = new UserMapper();
        try (PrintWriter out = response.getWriter()) {

            String origin = request.getParameter("origin");
            switch (origin) {

                case "invoice_detail":
                    try {

                        int orderid = Integer.parseInt(request.getParameter("id"));
                        request.setAttribute("orderid", orderid);

                        List<Odetail> allId = lim.getInvoiceDetailByOrderId(orderid);
                        request.setAttribute("allId", allId);

                        request.getRequestDispatcher("/customer_history_detail.jsp").forward(request, response);
                    } catch (NumberFormatException | NullPointerException ex) {
                        ex.getMessage();
                    }

                    break;

                case "invoice_detailAdmin":
                    try {

                        int orderid = Integer.parseInt(request.getParameter("id"));
                        request.setAttribute("orderid", orderid);

                        List<Odetail> allId = lim.getInvoiceDetailByOrderId(orderid);
                        request.setAttribute("allId", allId);

                        request.getRequestDispatcher("/customer_history_detail_admin.jsp").forward(request, response);
                    } catch (NumberFormatException | NullPointerException ex) {
                        ex.getMessage();
                    }

                    break;
                
                case "invoice_detailUser":
                    try {

                        String customerName = request.getParameter("customerName");
                        request.setAttribute("customerName", customerName);
                        User u = um.getUserData(customerName);
                        int userId = u.getUser_id();
                        request.setAttribute("userId", userId);
                        String cName = u.getUserName();
                        request.setAttribute("cName", cName);
                        List<Order> allId = itam.getOrdersByUserId(userId);
                        request.setAttribute("allId", allId);

                        request.getRequestDispatcher("/customer_history_admin.jsp").forward(request, response);

                    } catch (NumberFormatException | NullPointerException ex) {
                        ex.getMessage();
                    }
                    break;

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
        try {
            processRequest(request, response);
        } catch (SQLException | MakingAnException ex) {
            Logger.getLogger(InvoiceHistoryCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException | MakingAnException ex) {
            Logger.getLogger(InvoiceHistoryCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
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
