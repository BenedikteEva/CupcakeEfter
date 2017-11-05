package Controller;

import data.InfoToAdminMapper;
import data.LineItemsMapper;
import domain.LineItem;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import domain.Order;
import data.UserMapper;
import domain.MakingAnException;
import domain.Odetail;
import java.util.List;

/**
 *
 * @author Bo Henriksen
 */
@WebServlet(name = "InvoiceDetailServlet", urlPatterns = {"/InvoiceDetailServlet"})
public class InvoiceDetailServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws domain.MakingAnException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, MakingAnException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        InfoToAdminMapper infoMapper = new InfoToAdminMapper();
        LineItemsMapper lim = new LineItemsMapper();
        UserMapper um = new UserMapper();
        try (PrintWriter out = response.getWriter()) {
            String origin = request.getParameter("origin");
            switch (origin) {

                case "invoice_detail":
                    try {
                        //Parser den som int da den kommer som String
                        int invId = Integer.parseInt(request.getParameter("oid"));
                        request.setAttribute("invId", invId);

//                        String orderData = lim.getLineItemDataByUserId(invId, infoMapper.getUserIdByOrderId(invId));
//                        request.setAttribute("orderData", orderData);
                        List<LineItem> cupcakeName = infoMapper.getODetail(invId);
                        request.setAttribute("cupcakeName", cupcakeName);

                        request.getRequestDispatcher("invoice_detail.jsp").forward(request, response);
                    } catch (MakingAnException | NumberFormatException | NullPointerException ex) {
                        ex.getMessage();
                    }

                    break;

                case "invoice_user":
                    try {
                        int userId = Integer.parseInt(request.getParameter("uid"));
                        List<Order> userOrders = infoMapper.getOrdersByUserId(userId);
                        request.setAttribute("user", um.getUsers().get(userId - 1));
                        request.setAttribute("userOrders", userOrders);
                        request.setAttribute("userId", userId);
                        request.getRequestDispatcher("invoice_detail.jsp").forward(request, response);

                        List<Odetail> allId = lim.getInvoiceDetailForUser(userId);
                        request.setAttribute("allId", allId);

                    } catch (MakingAnException ex) {
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
            Logger.getLogger(InvoiceDetailServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(InvoiceDetailServlet.class.getName()).log(Level.SEVERE, null, ex);
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
