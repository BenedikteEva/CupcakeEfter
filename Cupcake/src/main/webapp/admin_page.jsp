<%-- 
    Document   : admin_page
    Created on : 26-09-2017, 12:52:08
    Author     : Bo Henriksen 
--%>

<%@page import="Controller.Utilities.RendUtilAllId"%>
<%@page import="domain.InfoToAdmin"%>
<%@page import="data.InfoToAdminMapper"%>
<%@page import="java.util.List"%>
<%@page import="data.LineItemsMapper"%>
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
        
        InfoToAdminMapper infoAllId = new InfoToAdminMapper();
        
        List<InfoToAdmin> allInvoiceIdList = infoAllId.getAllOrderId();
        
        RendUtilAllId.allInvoiceId(allInvoiceIdList);
        


        %>
        
        
    </body>
</html>
