package Controller;

import data.UserMapper;
import domain.Admin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bo Henriksen
 */
@WebServlet(name = "AdminPageServlet", urlPatterns = {"/AdminPageServlet"})
public class AdminPageServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            //Henter brugens input
            String adminUserName = request.getParameter("adminUsername");
            String adminPassword = request.getParameter("adminPassword");
            System.out.println("AdminLoginServlet");

            //Laver user objekt
            Admin adminLogin = new Admin();
            adminLogin.setAdminUserName(adminUserName);
            adminLogin.setAdminPassword(adminPassword);
            
            UserMapper userMapper = new UserMapper();
            boolean adminValidate = userMapper.godkendAdmin(adminLogin);
            if (adminValidate) {
                //Sætter et key value pair så det kan hentes senere med getAttribute("key")
                //request.setAttribute("adminUserName", adminUserName);//session i stedet for. Hvis setAttribute brug hidden field til at følge
                HttpSession session = request.getSession();
                session.setAttribute(adminUserName, out);
                session.setAttribute(adminPassword, out);
                                
                request.getRequestDispatcher("/admin_page.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/index.html").forward(request, response);
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
