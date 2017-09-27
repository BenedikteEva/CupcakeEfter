<%-- 
    Document   : products
    Created on : 21-09-2017, 10:57:03
    Author     : Ejer
--%>

<%@page import="java.sql.SQLException"%>
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

        <img src="images/fasching-cupcakes-rezept-img-19761.jpg" alt="Cuppy" width="10%" height="10% "/>    
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
         <container class="column">
        <%= RendUtilBottom.bottomTable(bottomList)%>
</container>
   


     <section>
        <button type="submit" >See your CupCake </button>

        <%
            Topping t = new Topping();
            Bottom b = new Bottom();
            CupcakeMapper ccm = new CupcakeMapper();
            RendUtilCupCake rucc = new RendUtilCupCake();
            UserMapper um = new UserMapper();
            String[] chosenName = request.getParameterValues("checkbox");
            String topname = request.getParameter("topname");
            String botname = request.getParameter("bottomname");

            String uname = request.getParameter("username");
      

            if (topname != null && botname != null) {
                out.println("<a>" + rucc.createCakeName(botname, topname) + "</a><td><td>");
                out.println("<a>" + rucc.calculateCakePrice(ccm.getBottomPricebyName(botname), ccm.getToppingPricebyName(topname)) + "</a>");
            
            } else {
  
                out.println("<div class=column><h2>Welcome back  " + uname+"</h2></div><br>");
                out.println("<h3>Your account balance is: " + um.getUserData(uname).getBalance()+"</h3>");

            }
        %>

        <form>Quantity
            <input type="number" name="quantity" min="0" width="5px" value="Quantity" default="1" >
        </form> 

        <%-- måske bør man kalde knappen add to shopping cart istedet --%>
        <button type="button" style="background-color: red" onclick="location.href = 'index.jsp';" class="cancelbtn">Cancel</button>
        <button type="submit" class="signupbtn">Add to Shoppingcart</button>
  </section>

</body>
</html>
