/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Utilities.RendUtilCupCake;
import data.CupcakeMapper;
import data.UserMapper;
import domain.Bottom;
import domain.Topping;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author Ejer
 */
@WebServlet(name = "CupCakeServlet", urlPatterns = {"/CupCakeServlet"})
public class CupCakeServlet extends HttpServlet {

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

        Topping t = new Topping();
        Bottom b = new Bottom();
        CupcakeMapper ccm = new CupcakeMapper();
        RendUtilCupCake rucc = new RendUtilCupCake();
        UserMapper um = new UserMapper();
        String[] chosenName = request.getParameterValues("checkbox");
        String topname = request.getParameter("topname");
        String botname = request.getParameter("bottomname");

        String uname = request.getParameter("username");

        if (topname != null && botname != null) {
            try {
                out.println("<a>" + rucc.createCakeName(botname, topname) + "</a><td><td>");
                out.println("<a>" + rucc.calculateCakePrice(ccm.getBottomPricebyName(botname), ccm.getToppingPricebyName(topname)) + "</a>");
               
            } catch (SQLException ex) {
                Logger.getLogger(CupCakeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                out.println("<div class=column><h2>Welcome back  " + uname + "</h2></div><br>");
                double balance = um.getUserData(uname).getBalance();
                out.println("<h3>Your account balance is: " + balance + "</h3>");
            } catch (SQLException ex) {
                Logger.getLogger(CupCakeServlet.class.getName()).log(Level.SEVERE, null, ex);
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
