<%-- 
    Document   : invoice_detail
    Created on : 28-09-2017, 11:52:08
    Author     : Bo Henriksen 
--%>

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

        <% //String adminName = (String)request.getAttribute("user");

            // out.println("Hello " + adminName + ". What are your plans for today?");
            // int id =(Integer) session.getAttribute("totalPrice");
            // out.println(id);
            out.println("<a>" + (String) request.getAttribute("orderData") + "</a>");
            // Virker ikke!

            InfoToAdminMapper infoToAdmin = new InfoToAdminMapper();
            //InfoToAdminMapper invoice = new InfoToAdminMapper();
            //List<InfoToAdmin> invoiceList = invoice.getODetail("intId");
            //InvoiceDetailServlet inv = new InvoiceDetailServlet();
            //InfoToAdmin invo = new InfoToAdmin();

        %>
        <%--= RendUtilInvoice.invoiceTable(invoiceList)--%>

        <table border=2>
            <tr>
                <th>Orders</th>
                <th>Bruger</th>
                <th>Info 3</th>
                <th>Info 4</th>
            </tr>

            <tr>
                <td><%=infoToAdmin.getOrders()%></td>
                <td><%=session.getAttribute("user")%></td>
                <td><%=session.getAttribute("cupcakeName")%></td>
                <td><%=session.getAttribute("cart")%></td>
            </tr>
        </table>
            

    </body>
    
    <button type="button" style="background-color: gold" onclick="location.href = 'admin_page.jsp';" class="cancelbtn">Vælg en anden brugers ordre</button>
</html>
