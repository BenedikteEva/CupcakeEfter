<%-- 
    Document   : login_admin
    Created on : 26-09-2017, 13:46:11
    Author     : Bo Henriksen 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Admin Login Page</h1>

        <form name="FormLogin" action="admin_page.jsp" method="POST">
            <div class="imgcontainer">

            </div>

            <div class="container">
                <label><b>Admin Username</b></label>
                <input type="text" placeholder="Enter Username" name="adminUsername" required>

                <label><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="adminPassword" required>

                <button type="submit">Login</button>
                <input type="checkbox" checked="checked"> Remember me
            </div>

            <div class="container" style="background-color:#f1f1f1">
            <button type="button" style="background-color: red" onclick="location.href = 'index.jsp';" class="cancelbtn">Cancel</button>
                <span class="psw">Forgot <a href="#">password?</a></span>
            </div>
        </form>

    </body>
</html>
