<%-- 
    Document   : invoice_detail
    Created on : 28-09-2017, 11:52:08
    Author     : Bo Henriksen 
--%>

<%@page import="domain.Odetail"%>
<%@page import="Utilities.RendUtilInvoiceDetailsCustomer"%>
<%@page import="domain.LineItem"%>
<%@page import="Controller.InvoiceDetailServlet"%>
<%@page import="Utilities.RendUtilInvoice"%>


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

        <h1>Invoice Detail</h1>

        <%
            //out.println("<a>" + (LineItem) request.getAttribute("invoiceInfo") + "</a>");
        //   out.println("<a>" + (Integer) request.getAttribute("invId") + "</a>");
          
        %>
        <%--= RendUtilInvoice.invoiceTable(invoiceList)--%>
         <strong>Order Details Løsning 1</strong>
        <table border=2>
            
            <tr>
                <th>Bruger</th>
                <th>Order</th>
                <th>User ID</th>
                <th>Order DetaljerD</th>
            </tr>

            <tr>
                <td><%=request.getAttribute("user")%></td>
                <td><%=request.getAttribute("userOrders")%></td>
                <td><%=request.getAttribute("userId")%></td>
                <td><%=request.getAttribute("userOrdered Details")%></td>
            </tr>
        </table>
            
            
            
            
    </body>
    
    <button type="button" style="background-color: gold" onclick="location.href = 'admin_page.jsp';" class="cancelbtn">Vælg en anden brugers ordre</button>
</html>
