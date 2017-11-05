package Controller;

import data.LineItemsMapper;
import data.UserMapper;
import domain.Odetail;
import domain.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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

/**
 *
 * @author Bo Henriksen
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

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

            //Henter brugens input
            String userName = request.getParameter("username");
            String password = request.getParameter("password");
           // System.out.println("LoginServlet");

//            User user = new User();
            //Laver user objekt
            User loginUser = new User();
            loginUser.setUserName(userName);
            loginUser.setPassword(password);

            UserMapper userMapper = new UserMapper();
            boolean userValidate = userMapper.godkendBruger(loginUser);
            if (userValidate) {

                try {
                    boolean userAdmin = userMapper.getUserData(userName).isAdminStatus();
                    HttpSession session = request.getSession();
                    session.setAttribute("user", loginUser); //Her sættes attributen user på session objektet

                    if (userAdmin == true) {
                        
                 
                        request.getRequestDispatcher("/admin_page.jsp").forward(request, response);
                    } else {
                        int userId = userMapper.getUserData(userName).getUser_id();
                        session.setAttribute("userId", userId);
                        request.getRequestDispatcher("/products.jsp").forward(request, response);
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                //Sætter et key value pair så det kan hentes senere med getAttribute("key")
                //request.setAttribute("userName", userName);//session i stedet for. Hvis setAttribute brug hidden field til at følge
            } else {
                
                request.setAttribute("wrongLogin","Wrong username or password!");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
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
