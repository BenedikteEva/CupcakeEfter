<%-- 
    Document   : invoice_detail
    Created on : 28-09-2017, 11:52:08
    Author     : Bo Henriksen 
--%>

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

            InfoToAdminMapper infoToAdmin = new InfoToAdminMapper();
          
        %>
        <%--= RendUtilInvoice.invoiceTable(invoiceList)--%>
       
        <table border=2>
            
            <tr>
                <th>Orders</th>
                <th>Bruger</th>
                <th>User ID</th>
            </tr>

            <tr>
                <td><%=request.getAttribute("user")%></td>
                <td><%=request.getAttribute("userOrders")%></td>
                <td><%=request.getAttribute("userId")%></td>
            </tr>
        </table>
            

    </body>
    
    <button type="button" style="background-color: gold" onclick="location.href = 'admin_page.jsp';" class="cancelbtn">Vælg en anden brugers ordre</button>
</html>
