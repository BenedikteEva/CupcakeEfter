<%-- 
    Document   : admin_page
    Created on : 26-09-2017, 12:52:08
    Author     : Bo Henriksen 
--%>

<%@page import="domain.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administration</title>
    </head>
    <body>
        <h1>Admin Page</h1>
        
        <% String adminName = request.getParameter("username"); 
        
        out.println("Hello " + adminName + ". What are your plans for today?"); 
        
        %>
        
        
    </body>
</html>
