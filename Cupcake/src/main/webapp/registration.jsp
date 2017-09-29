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

    <body>


    <center>
        <h1>Welcome to Cupcake Shop. Please register your self to use our services.</h1>
    </center>

    <div class="top_menu">



        <ul>
           <!-- <li>
            <a href="index.jsp">
                <span id="span-logo">
                    <img src="images/cupcake_logo.jpg" id="logo" alt="Logo_cupcake"/>
                </span>
            </a>
                </li> -->
            <li>
                <a href="index.jsp">Home</a>
            </li>
            <li>
                <a href="#">Products</a>
            </li>
            <li>
                <a href="login.jsp">Customer Login</a>
            </li>
            <li>
                <a href="login.jsp">Admin Login</a>
            </li>
            
        </ul>
    </div>

    <div class="flex-container">
        <div id="box">   
            <form name="Form1" action="UserServlet" method="POST">
                <div class="container">
                    <label><b>User name     </b></label>
                    <input type="text" placeholder="Enter user name" name="username" required>
                    <br>

                    <label><b>Email</b></label>
                    <input type="text" placeholder="Enter Email" name="email" required>
                    <br>
                    <label><b>Password</b></label>
                    <input type="password" placeholder="Enter Password" name="password" required>
                    <br>
                    <label><b>Repeat Password</b></label>
                    <input type="password" placeholder="Repeat Password" name="passwordrepeat" required>
                    <input type="checkbox" checked="checked"> Remember me
                    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>

                    <form name="Form1" action="UserServlet" method="POST">

                        <button type="submit" class="signupbtn">Sign Up</button> <%-- Brug denne kode stadigvæk for at linke til en classe i programmet. --%>

                        <button type="button" onclick="location.href = 'index.jsp';" class="cancelbtn">Cancel</button>



                </div>
            </form>
        </div> 

        <div id="somewhereelse box">
            <img src="images/fasching-cupcakes-rezept-img-19761.jpg" alt="Cuppy"/>    
        </div>                
    </div>



</body>
</html>



