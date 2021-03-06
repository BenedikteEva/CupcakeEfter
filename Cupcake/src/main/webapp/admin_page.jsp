<%-- 
    Document   : admin_page
    Created on : 26-09-2017, 12:52:08
    Author     : Bo Henriksen 
--%>

<%@page import="Utilities.UserRendUtil"%>
<%@page import="data.UserMapper"%>
<%@page import="Utilities.RendUtilAllId"%>
<%@page import="domain.LineItem"%>
<%@page import="domain.Order"%>
<%@page import="data.InfoToAdminMapper"%>
<%@page import="java.util.List"%>
<%@page import="data.LineItemsMapper"%>
<%@page import="domain.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

        <!-- Custom fonts for this template -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template -->
        <link href="css/business-casual.css" rel="stylesheet" type="text/css"/>

        <title>Administration</title>
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
                            <a class="nav-link text-uppercase text-expanded" href="customer_history_admin.jsp">Customers Order</a>
                        </li>
                        <!--<li class="nav-item px-lg-4">
                            <a class="nav-link text-uppercase text-expanded" href="#">Shopping Cart</a>
                        </li> -->
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
                    <h1 class="my-2">The Administration Page</h1>
                    <div class="text-heading text-muted text-lg">By
                        <strong>The Data Builders</strong>
                    </div>
                </div>
            </div>

            <div class="bg-faded p-4 my-4">
                <hr class="divider">
                <h2 class="text-center text-lg text-uppercase my-0">
                    <strong>Order Details</strong>
                </h2>
                <hr class="divider">

                <% 

                    out.println("Hello " + (String)session.getAttribute("userAdminName")+ ". What are your plans for today?");

                 //   InfoToAdminMapper infoToAdmin = new InfoToAdminMapper(); 
                  //  List<Order> allId = infoToAdmin.getOrders();
                    UserMapper um = new UserMapper();
                   
                    List<User> allUsers = um.getUsers();

                %>
               
                
                <div class="flex-container">
                    <div id="box">
                        <%= RendUtilAllId.allInvoiceIdSearch()%>

                    </div>

                    <div id="box">
                        <%= UserRendUtil.userList(allUsers)%>

                    </div>
                        
                         <div id="box">
                        <%= UserRendUtil.allUserNameSearch()%>

                    </div>

                </div>



                <!-- If the customer want a field to enter an invoice number insted of a button. TODO is not finish. -->
                <!--<form name="FormInvoice" action="#" method="POST"> <!--action="/InvoiceDetailServlet"-->

                <!-- <div class="container">
                     <label><b>Enter the invoice number you want to inspect</b></label>
                     <input type="text" placeholder="Enter Invoicenumber" name="id" required>

               


                <!-- </div>

             </form>-->



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
