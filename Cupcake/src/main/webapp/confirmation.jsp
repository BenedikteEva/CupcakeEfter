<%-- 
    Document   : confirmation
    Created on : 21-09-2017, 10:58:10
    Author     : Ejer
--%>

<%@page import="domain.Cart"%>
<%@page import="domain.User"%>
<%@page import="domain.LineItem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="data.LineItemsMapper"%>
<%@page import="java.sql.SQLException"%>
<%@page import="data.UserMapper"%>
<%@page import="Utilities.RendUtilCupCake"%>
<%@page import="domain.Bottom"%>
<%@page import="domain.Topping"%>
<%@page import="java.util.List"%>
<%@page import="Utilities.RendUtilTopping"%>
<%@page import="Utilities.RendUtilBottom"%>
<%@page import="data.CupcakeMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmation</title>
    </head>
    <body>
        
        <p>Confirmation Page</p>
        <%  
            
            UserMapper um = new UserMapper();
                    User user = (User) session.getAttribute("user");
            out.println("<div class=column><h2><br>Dear  " + user.getUserName() + "</h2></div><br>");
             out.println("<a> you have bought : " + session.getAttribute("cart") + "  please enjoy:-)</a> ");
                        out.println("<h3>Your account balance is: " + um.getUserData(user.getUserName()).getBalance() + "</h3>");
       %>
    </body>
</html>
