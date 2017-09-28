<%-- 
    Document   : invoice_detail
    Created on : 28-09-2017, 11:52:08
    Author     : Bo Henriksen 
--%>

<%@page import="Controller.InvoiceDetailServlet"%>
<%@page import="Utilities.RendUtilInvoice"%>
<%@page import="domain.InfoToAdmin"%>
<%@page import="java.util.List"%>
<%@page import="data.InfoToAdminMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invoice Detail</title>
    </head>
    <body>
        
        <h1>Invoic Detail</h1>
        
        <% String adminName = request.getParameter("username");

            out.println("Hello " + adminName + ". What are your plans for today?");

            InfoToAdminMapper invoice = new InfoToAdminMapper();

            //List<InfoToAdmin> invoiceList = invoice.getODetail("intId");
            InvoiceDetailServlet inv = new InvoiceDetailServlet();
            
            InfoToAdmin invo = new InfoToAdmin();
            
            
        %>
        <%= //RendUtilInvoice.invoiceTable(invoiceList)%>
        
        
    </body>
</html>
