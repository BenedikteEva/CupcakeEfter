<%-- 
    Document   : registration
    Created on : 21-09-2017, 09:53:36
    Author     : Ticondrus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/registrationStylecupcake.css" rel="stylesheet" type="text/css"/>
        <link href="../resources/registrationStylecupcake.css" rel="stylesheet" type="text/css"/>
        
    </head>
    <div id="somewhereelse">
            <img src="images/fasching-cupcakes-rezept-img-19761.jpg" alt="Cuppy" width="25%" height="25% "/>    
        </div>
    
    <body>
        <h1>Welcome to Cupcake Shop. Please register your self to use our services.</h1>
    </body>


    <form name="Form1" action="UserServlet" method="POST">
        <div class="container">
            <label><b>User name</b></label>
            <input type="text" placeholder="Enter user name" name="username" required>


            <label><b>Email</b></label>
            <input type="text" placeholder="Enter Email" name="email" required>

            <label><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="password" required>

            <label><b>Repeat Password</b></label>
            <input type="password" placeholder="Repeat Password" name="passwordrepeat" required>
            <input type="checkbox" checked="checked"> Remember me
            <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>

            <div class="clearfix">

              

                <form name="Form1" action="UserServlet" method="POST">

                    <button type="button" onclick="location.href = 'index.html';" class="cancelbtn">Cancel</button>


                    <button type="submit" class="signupbtn">Sign Up</button> <%-- Brug denne kode stadigvæk for at linke til en classe i programmet. --%>

            </div>
        </div>

    </form>

</html>



