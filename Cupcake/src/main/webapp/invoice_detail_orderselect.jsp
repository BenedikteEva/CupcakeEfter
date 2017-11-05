<%-- 
    Document   : invoice_detail_orderselect
    Created on : 05-11-2017, 14:09:18
    Author     : Ticondrus
--%>

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
       
        <table border=2>
            
            <tr>
                <th>Bruger</th>
                <th>Order Detaljer</th>
                <th>User ID</th>
            </tr>

            <tr>
                <td><%=request.getAttribute("userbelonger")%></td>
                <td><%=request.getAttribute("orderData")%></td>
                <td><%=request.getAttribute("userId")%></td>
            </tr>
        </table>
            

    </body>
    
    <button type="button" style="background-color: gold" onclick="location.href = 'admin_page.jsp';" class="cancelbtn">Vælg en anden brugers ordre</button>
</html>