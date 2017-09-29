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
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

        <!-- Custom fonts for this template -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template -->
        <link href="css/business-casual.css" rel="stylesheet" type="text/css"/>

        <title>JSP Page</title>

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
                            <a class="nav-link text-uppercase text-expanded" href="#">About</a>
                        </li>
                        <li class="nav-item px-lg-4">
                            <a class="nav-link text-uppercase text-expanded" href="#">Blog</a>
                        </li>
                        <li class="nav-item px-lg-4">
                            <a class="nav-link text-uppercase text-expanded" href="#">Contact</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container">

            <div class="bg-faded p-4 my-4">
                <!-- Image Carousel -->
                <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner" role="listbox">
                        <div class="carousel-item active">
                            <img class="d-block img-fluid w-100" src="images/cupcake_rose.jpg" alt="">
                            <div class="carousel-caption d-none d-md-block">
                                <h3 class="text-shadow">Our Cupcake Rose</h3>
                                <p class="text-shadow">With A Taste Of Summer</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img class="d-block img-fluid w-100" src="images/art_cupcake.jpg" alt="">
                            <div class="carousel-caption d-none d-md-block">
                                <h3 class="text-shadow">Our Art Cupcakes</h3>
                                <p class="text-shadow">For Every Occation</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img class="d-block img-fluid w-100" src="images/pink_rose_cupcakes.jpg" alt="">
                            <div class="carousel-caption d-none d-md-block">
                                <h3 class="text-shadow">Our Rose Cupcake</h3>
                                <p class="text-shadow">Our Contribution To The Annual Cupcake Festival</p>
                            </div>
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>

                <!-- Welcome Message -->
                <div class="text-center mt-4">
                    <div class="text-heading text-muted text-lg">Welcome To</div>
                    <h1 class="my-2">Marys Wonderful Cupcakes</h1>
                    <div class="text-heading text-muted text-lg">By
                        <strong>The Data Builders</strong>
                    </div>
                </div>
            </div>

            <div class="bg-faded p-4 my-4">
                <hr class="divider">
                <h2 class="text-center text-lg text-uppercase my-0">Our Cupcakes is
                    <strong>worth sharing</strong>
                </h2>
                <hr class="divider">
                <img class="img-fluid float-left mr-4 d-none d-lg-block" src="images/cupcake_sharing.jpg" alt="" width="30%">
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Magnam soluta dolore voluptatem, deleniti dignissimos excepturi veritatis cum hic sunt perferendis ipsum perspiciatis nam officiis sequi atque enim ut! Velit, consectetur.</p>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laboriosam pariatur perspiciatis reprehenderit illo et vitae iste provident debitis quos corporis saepe deserunt ad, officia, minima natus molestias assumenda nisi velit?</p>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reprehenderit totam libero expedita magni est delectus pariatur aut, aperiam eveniet velit cum possimus, autem voluptas. Eum qui ut quasi voluptate blanditiis?</p>
            </div>    

            <%CupcakeMapper cupcakeList = new CupcakeMapper();%>
            <%List<LineItem> shoppingCart = new ArrayList<>();%>
            <% RendUtilCupCake rucc = new RendUtilCupCake();%>
            <%
                List<Topping> toppingList = cupcakeList.getAllTopping();
                List<Bottom> bottomList = cupcakeList.getAllBottom();

            %>

            <div class="bg-faded p-4 my-4">
                <hr class="divider">
                <h2 class="text-center text-lg text-uppercase my-0">Order Our Cupcakes
                    <strong>Here</strong>
                </h2>
                <hr class="divider">
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Magnam soluta dolore voluptatem, deleniti dignissimos excepturi veritatis cum hic sunt perferendis ipsum perspiciatis nam officiis sequi atque enim ut! Velit, consectetur.</p>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laboriosam pariatur perspiciatis reprehenderit illo et vitae iste provident debitis quos corporis saepe deserunt ad, officia, minima natus molestias assumenda nisi velit?</p>

                 <div class="flex-container">
                    <div id="box">
                        <%= RendUtilTopping.toppingTable(toppingList)%>
                    </div>
                    <div id="box">
                        <%= RendUtilBottom.bottomTable(bottomList)%>
                    </div>
                </div>

                <div class="flex-container">
                    <div id="box">    
                        <button type="submit" >See your CupCake </button>
                    </div>
                    <div id="box">
                        <form>Quantity
                            <input type="number" name="quantity" min="0.0" value="Quantity" default="1.0" >
                        </form> 
                        <form name="formProducts" action="ProductControlServlet" method="POST"> 
                    </div>
                </div>
                
                <%

                    UserMapper um = new UserMapper();
                    String[] chosenName = request.getParameterValues("checkbox");
                    String topname = request.getParameter("topname");
                    String botname = request.getParameter("bottomname");
                    String uname = request.getParameter("username");

                    if (topname == null || botname == null) {

                        out.println("<div class=column><h2>Hello  " + uname + "</h2></div><br>");
                        out.println("<h3>Your account balance is: " + um.getUserData(uname).getBalance() + "</h3>");

                    } 
                    
                    if (topname != null && botname != null) {
                        String cupcakename = rucc.createCakeName(botname, topname);
                        double cupcakeprice = rucc.calculateCakePrice(cupcakeList.getBottomPricebyName(botname), cupcakeList.getToppingPricebyName(topname));
                        request.setAttribute("cupcakeprice", cupcakeprice);
                        request.setAttribute("cupcakename", cupcakename);
                        out.println("<a>" + cupcakename + "</a><td><td>");
                        out.println("<a>" + cupcakeprice + "</a>");


                %>
                
                
               

                

                <button type="submit" >add to shoppingcart   </button>    
                <%        try {
                            int qty = Integer.parseInt(request.getParameter("quantity"));

                            if (qty != 0) {
                                cupcakeprice = Double.parseDouble(request.getParameter("cupcakeprice"));
                                cupcakename = request.getParameter("cupcakename");
                                double typeCupCakeprice = qty * cupcakeprice;
                                request.setAttribute("typeCupCakeprice", typeCupCakeprice);
                                double b = um.getUserData(uname).getBalance();
                                um.changeUserBalance(uname, b);

                                out.println("<a> Your new balance is: " + um.getUserData(uname).getBalance() + "</a>");

                            } else {
                                if (qty != 0 && topname == null && botname == null) {
                                    out.println("<a> go play with the dog</a>");
                                }
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                    }


                %>
                </form>

                <button type="button" style="background-color: red" onclick="location.href = 'index.jsp';" class="cancelbtn">Cancel</button>


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
