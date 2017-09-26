<%-- 
    Document   : products
    Created on : 21-09-2017, 10:57:03
    Author     : Ejer
--%>

<%@page import="data.UserMapper"%>
<%@page import="Controller.RendUtilCupCake"%>
<%@page import="Controller.RendUtilBottom"%>
<%@page import="domain.Bottom"%>
<%@page import="domain.Topping"%>
<%@page import="java.util.List"%>
<%@page import="Controller.RendUtilTopping"%>
<%@page import="Controller.RendUtilBottom"%>
<%@page import="data.CupcakeMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="BenedikteEvaCSS2.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>

    </head>
    <body>  
    <container class="column">
        <h2>   <% UserMapper um = new UserMapper();%>
            
            <%
            String uname = request.getParameter("username");
            Double balance = um.getUserData(uname).getBalance();
            out.println("Welcome back  " + uname);
            out.println("Your account balance is: " + balance);
            %>
        </h2>
            <br>
        <h1>Order our cupcakes!</h1>

  
        <%CupcakeMapper cupcakeList = new CupcakeMapper();%>

        <%
            List<Topping> toppingList = cupcakeList.getAllTopping();
            List<Bottom> bottomList = cupcakeList.getAllBottom();

        %>

        <%= RendUtilTopping.toppingTable(toppingList)%>
        <br>
        <br>
        <br>
        <%= RendUtilBottom.bottomTable(bottomList)%>


        <button type="submit" >See your CupCake </button>

        <container class="middlecolumn">


            <%
                Topping t = new Topping();
                Bottom b = new Bottom();
                CupcakeMapper ccm = new CupcakeMapper();
                RendUtilCupCake rucc = new RendUtilCupCake();
                String[] chosenName = request.getParameterValues("checkbox");
                String topname = request.getParameter("topname");
                String botname = request.getParameter("bottomname");

                if (topname != null && botname != null) {
                    out.println("<a>" + rucc.createCakeName(botname, topname) + "</a><td><td>");
                    out.println("<a>" + rucc.calculateCakePrice(ccm.getBottomPricebyName(botname), ccm.getToppingPricebyName(topname)) + "</a>");

                } else {

                    out.println("<a></a>");

                }
            %></container>

        <div class="column">
            <img src="images/fasching-cupcakes-rezept-img-19761.jpg" alt="Cuppy" width="25%" height="25%"/>    
        </div>

        <form>Quantity
            <input type="number" name="quantity" min="0" width="5px" value="Quantity" default="1" >
        </form> 

        <%-- måske bør man kalde knappen add to shopping cart istedet --%>
        <button type="button" style="background-color: red" onclick="location.href = 'index.jsp';" class="cancelbtn">Cancel</button>
        <button type="submit" class="signupbtn">Add to Shoppingcart</button>
    </container>

</body>
</html>
