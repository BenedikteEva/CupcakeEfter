<%-- 
    Document   : customer_history
    Created on : 03-11-2017, 15:59:26
    Author     : Bo
--%>

<%@page import="domain.User"%>
<%@page import="data.UserMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

        <!-- Custom fonts for this template -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template -->
        <link href="css/business-casual.css" rel="stylesheet" type="text/css"/>
        
        <title>Customer History</title>
    </head>
    <body>
        
        <div class="tagline-upper text-center text-heading text-shadow text-white mt-5 d-none d-lg-block">Marys Cupcakes</div>
        <div class="tagline-lower text-center text-expanded text-shadow text-uppercase text-white mb-5 d-none d-lg-block">3481 Melrose Place | Beverly Hills, CA 90210 | 123.456.7890</div>

        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-light bg-faded py-lg-4">
            <div class="container">
                <a class="navbar-brand text-uppercase text-expanded font-weight-bold d-lg-none" href="#">Start Bootstrap</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav mx-auto">
                        <li class="nav-item active px-lg-4">
                            <a class="nav-link text-uppercase text-expanded" href="index.jsp">Home
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item px-lg-4">
                            <a class="nav-link text-uppercase text-expanded" href="customer_history.jsp">Order History</a>
                        </li>
                        <li class="nav-item px-lg-4">
                            <a class="nav-link text-uppercase text-expanded" href="#">Shopping Cart</a>
                        </li>
                        <li class="nav-item px-lg-4">
                            <a class="nav-link text-uppercase text-expanded" href="index.jsp">Logout</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container">

            <div class="bg-faded p-4 my-4">

                <!-- Welcome Message -->
                <div class="text-center mt-4">
                    <div class="text-heading text-muted text-lg">Welcome To</div>
                    <h1 class="my-2">Your Order History</h1>
                    <div class="text-heading text-muted text-lg">
                        <strong>Cupcakes Makes Sweet Connections</strong>
                    </div>
                </div>
            </div>

            <div class="bg-faded p-4 my-4">
                <hr class="divider">
                <h2 class="text-center text-lg text-uppercase my-0">This is Your 
                    <strong>Order History</strong>
                </h2>
                <hr class="divider">
                
                <%UserMapper um = new UserMapper();
                    User user = (User) session.getAttribute("user");

                    if (user != null) {
                        out.println("<div class=column><h2><br>Hello  " + user.getUserName() + "</h2></div><br>");
                        out.println("<h3>Your account balance is: " + um.getUserData(user.getUserName()).getBalance() + "</h3>");

                    }
                    
                    
                    
                    
                    
                    %>
                
                
                

            </div>    

            <div class="bg-faded p-4 my-4">
                <hr class="divider">
                <h2 class="text-center text-lg text-uppercase my-0">Giving Back to the
                    <strong>Local Community</strong>
                </h2>
                <hr class="divider">
                    <img class="img-fluid float-left mr-4 d-none d-lg-block" src="images/cupcake_sharing.jpg" alt="" width="30%">
                <p>If you have accidently found this page, you should know that this is just a student project and we do not sell real cup cakes.</p>
                <p>If you have accidently found this page, you should know that this is just a student project and we do not sell real cup cakes.</p>
                <p>If you have accidently found this page, you should know that this is just a student project and we do not sell real cup cakes.</p>
                <p>If you have accidently found this page, you should know that this is just a student project and we do not sell real cup cakes.</p>
                



                <div class="flex-container">
                    <div id="box">
                        


                    </div>
                    <div id="box">
                        

                    </div>

                </div>
            </div>
        </div>


        <!-- /.container -->

        <footer class="bg-faded text-center py-5">
            <div class="container">
                <p class="m-0">Copyright &copy; The Data Builders 2017</p>
            </div>
        </footer>

        <script src="script/jquery/jquery.min.js" type="text/javascript"></script>
        <script src="script/popper/popper.min.js" type="text/javascript"></script>
        <script src="css/js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
