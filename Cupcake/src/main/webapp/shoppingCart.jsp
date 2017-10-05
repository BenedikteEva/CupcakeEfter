<%-- 
    Document   : shoppingCart
    Created on : 03-10-2017, 08:42:22
    Author     : Bo Henriksen 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ShoppingCart</h1>
        
        <%
                                out.println("<br> </br>");
                                out.println("<a> you have : " + session.getAttribute("cart") + "  in your shoppingcart</a> ");
        %>
    </body>
</html>
