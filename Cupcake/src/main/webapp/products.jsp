<%-- 
    Document   : products
    Created on : 21-09-2017, 10:57:03
    Author     : Ejer
--%>

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
        <link href="../resources/cupcakestylesheet1.css" rel="stylesheet" type="text/css"/>
        <link href="css/cupcakestylesheet1.css" rel="stylesheet" type="text/css"/>

        <title>JSP Page</title>

    </head>
    <body>
         <div id="somewhereelse">
            <img src="images/fasching-cupcakes-rezept-img-19761.jpg" alt="Cuppy" width="25%" height="25% "/>    
        </div>

        <h1>Order our cupcakes!</h1>

        <%CupcakeMapper cupcakeList = new CupcakeMapper();%>
        <%List<LineItem> shoppingCart = new ArrayList<>();%>
        <% RendUtilCupCake rucc = new RendUtilCupCake();%>
        <%
            List<Topping> toppingList = cupcakeList.getAllTopping();
            List<Bottom> bottomList = cupcakeList.getAllBottom();

        %>

        <%= RendUtilTopping.toppingTable(toppingList)%>

        <br>
        <br>
        <br>

        <%= RendUtilBottom.bottomTable(bottomList)%>

        <section>

        <button type="submit" >See your CupCake </button>
        
            
             <form>Quantity
            <input type="number" name="quantity" min="0.0" value="Quantity" default="1.0" >
        </form> 
       <form name="formProducts" action="ProductControlServlet" method="POST"> 


        <%

            UserMapper um = new UserMapper();
            String[] chosenName = request.getParameterValues("checkbox");
            String topname = request.getParameter("topname");
            String botname = request.getParameter("bottomname");
            String uname = request.getParameter("username");

            if (topname == null || botname == null) {

                out.println("<div class=column><h2>Welcome back  " + uname + "</h2></div><br>");
                out.println("<h3>Your account balance is: " + um.getUserData(uname).getBalance() + "</h3>");

            } if (topname != null && botname != null) {
                String cupcakename = rucc.createCakeName(botname, topname);
                double cupcakeprice = rucc.calculateCakePrice(cupcakeList.getBottomPricebyName(botname), cupcakeList.getToppingPricebyName(topname));
                request.setAttribute("cupcakeprice", cupcakeprice);
                request.setAttribute("cupcakename", cupcakename);
                out.println("<a>" + cupcakename + "</a><td><td>");
                out.println("<a>" + cupcakeprice + "</a>");

              

     %>
       
  <button type="submit" >add to shoppingcart   </button>    
<%            
          try {
                    int qty = Integer.parseInt(request.getParameter("quantity"));

                    if (qty != 0 ) {
                        cupcakeprice = Double.parseDouble(request.getParameter("cupcakeprice"));
                        cupcakename = request.getParameter("cupcakename");
                        double typeCupCakeprice = qty * cupcakeprice;
                        request.setAttribute("typeCupCakeprice", typeCupCakeprice);
                      double b= um.getUserData(uname).getBalance();
                        um.changeUserBalance(uname, b);

                        out.println("<a> Your new balance is: "+um.getUserData(uname).getBalance()+"</a>");

                    }
                    else{
                        if (qty!=0 && topname == null && botname == null){
                            out.println("<a> go play with the dog</a>");
                        }}
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
    
           
        %>
</form>
     





        <button type="button" style="background-color: red" onclick="location.href = 'index.jsp';" class="cancelbtn">Cancel</button>

</section>
    </body>
</html>
