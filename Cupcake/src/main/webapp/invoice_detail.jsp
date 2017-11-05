<%-- 
    Document   : invoice_detail
    Created on : 28-09-2017, 11:52:08
    Author     : Bo Henriksen 
--%>

<%@page import="Utilities.RendUtilAllIdForCustomer"%>
<%@page import="domain.LineItem"%>
<%@page import="domain.Odetail"%>
<%@page import="Controller.InvoiceDetailServlet"%>
<%@page import="Utilities.RendUtilInvoice"%>
<%@page import="java.util.List"%>
<%@page import="data.InfoToAdminMapper"%>
<%@page import="data.LineItemsMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invoice Detail</title>
    </head>
    <body>

        <h1>Invoice Detail</h1>

        <%--
            //out.println("<a>" + (LineItem) request.getAttribute("invoiceInfo") + "</a>");
            //   out.println("<a>" + (Integer) request.getAttribute("invId") + "</a>");
            int invId = (Integer) request.getAttribute("invId");
            List<LineItem> lili = (List<LineItem>) request.getAttribute("cupcakeName");
            InfoToAdminMapper infoToAdmin = new InfoToAdminMapper();
            LineItemsMapper lim = new LineItemsMapper();
            List<Odetail> details = (List<Odetail>)request.getAttribute("details");

        --%>
        <%--= RendUtilInvoice.invoiceTable(invoiceList)--%>

      
        <table border=2>

            <tr>
                <th>Orders</th>
                <th>Bruger</th>
                <th>Info 3</th>
                <th>Info 4</th>
                <th>Info 5</th>
            </tr>

            <tr>
                <td><%=request.getAttribute("allId")%></td>
                <td><%=request.getAttribute("user")%></td>
                <td><%=request.getAttribute("userId")%></td>
                <td><%=request.getAttribute("invInfo")%></td>
                <td><%=request.getAttribute("details")%></td>
            </tr>
        </table>


     
        <br>
     

    </body>

    <button type="button" style="background-color: gold" onclick="location.href = 'admin_page.jsp';" class="cancelbtn">Vælg en anden brugers ordre</button>
</html>
