<%-- 
    Document   : shop
    Created on : Jun 20, 2024, 10:26:14 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="/WEB-INF/tlds/cart-tag-library" %>
<%--<%@taglib uri="/WEB-INF/tlds/cart-tags.tld" prefix="carts" %>--%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Male_Fashion Template">
        <meta name="keywords" content="Male_Fashion, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Male-Fashion</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
              rel="stylesheet">

        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/magnific-popup.css" type="text/css">
        <link rel="stylesheet" href="css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <style>
            .pagination-list {
                display: flex;
                list-style: none;
                padding: 0;
            }
            .pagination-list li {
                margin: 0 5px;
            }
            .pagination-list a {
                text-decoration: none;
                color: #000;
            }
        </style>
    </head>

    <body>
        <!-- Page Preloder -->
        <div id="preloder">
            <div class="loader"></div>
        </div>

        <!-- Offcanvas Menu Begin -->
        <div class="offcanvas-menu-overlay"></div>
        <div class="offcanvas-menu-wrapper">
            <div class="offcanvas__option">
                <div class="offcanvas__links">
                    <c:if test="${sessionScope.acc==null}" >
                        <a href="DispatchServlet?btnAction=Login">Sign in</a>
                    </c:if>

                    <c:if test="${sessionScope.acc!=null}" >
                        <a href="logout">Log out</a>

                    </c:if>
                    <c:if test="${sessionScope.acc.roleID == 1}" >
                        <a href="AdminServlet">Admin Page</a>

                    </c:if>
                    <a href="https://www.facebook.com/dieuthanh.huynh.505/">FAQs</a>
                </div>
                <div class="offcanvas__top__hover">
                    <span>Usd <i class="arrow_carrot-down"></i></span>
                    <ul>
                        <li>USD</li>
                        <li>EUR</li>
                        <li>USD</li>
                    </ul>
                </div>
            </div>
            <div class="offcanvas__nav__option">
                <a href="#" class="search-switch"><img src="img/icon/search.png" alt=""></a>
                <a href="#"><img src="img/icon/heart.png" alt=""></a>
                <a href="carts"><img src="img/icon/cart.png" alt=""></a>
                <div class="price">${sessionScope.carts.size()}</div>
                
                <div class="price">$<ct:TotalMoneyTag /></div>
            </div>
            <div id="mobile-menu-wrap"></div>
            <div class="offcanvas__text">
                <p>Free shipping, 30-day return or refund guarantee.</p>
            </div>
        </div>
        <!-- Offcanvas Menu End -->

        <!-- Header Section Begin -->
        <header class="header">
            <div class="header__top">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-6 col-md-7">
                            <div class="header__top__left">
                                <p>Free shipping, 30-day return or refund guarantee.</p>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-5">
                            <div class="header__top__right">
                                <div class="header__top__links">
                                    <c:if test="${sessionScope.acc==null}" >
                                        <a href="DispatchServlet?btnAction=Login">Sign in</a>
                                    </c:if>

                                    <c:if test="${sessionScope.acc!=null}" >
                                        <a href="logout">Log out</a>

                                    </c:if>
                                    <c:if test="${sessionScope.acc.roleID == 1}" >
                                        <a href="AdminServlet">Admin Page</a>

                                    </c:if>
                                    <a href="https://www.facebook.com/dieuthanh.huynh.505/">FAQs</a>
                                </div>
                                <div class="header__top__hover">
                                    <span>Usd <i class="arrow_carrot-down"></i></span>
                                    <ul>
                                        <li>USD</li>
                                        <li>EUR</li>
                                        <li>USD</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-3 col-md-3">
                        <div class="header__logo">
                            <a href="index"><img src="img/logo.png" alt=""></a>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <nav class="header__menu mobile-menu">
                            <ul>
                                <li><a href="index">Home</a></li>
                                <li class="active"><a href="home">Shop</a></li>
                                <li><a href="#">Pages</a>
                                    <ul class="dropdown">
                                        <li><a href="DispatchServlet?btnAction=aboutus">About Us</a></li> 

                                        <li><a href="carts">Shopping Cart</a></li>


                                    </ul>
                                </li>
                                <li><a href="DispatchServlet?btnAction=Blog">Blog</a></li>
                                <li><a href="DispatchServlet?btnAction=Contact">Contacts</a></li>
                            </ul>
                        </nav>
                    </div>
                    
                       <div class="col-lg-3 col-md-3">
                        <div class="header__nav__option">
                            <a href="#" class="search-switch"><img src="img/icon/search.png" alt=""></a>
                            <a href="#"><img src="img/icon/heart.png" alt=""></a>
                            <a href="carts"><img src="img/icon/cart.png" alt=""> <span></span></a>
                            <div class="price-info" style="display: inline-block;
                                 white-space: nowrap;">
                                <span>${sessionScope.carts.size()} </span>  
                                <span>$<ct:TotalMoneyTag /></span>
                            </div>
                        </div>
                    </div>
                    
                </div>
                <div class="canvas__open"><i class="fa fa-bars"></i></div>
            </div>
        </header>
        <!-- Header Section End -->

        <!-- Breadcrumb Section Begin -->
        <section class="breadcrumb-option">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="breadcrumb__text">
                            <h4>Shop</h4>
                            <div class="breadcrumb__links">
                                <a href="index">Home</a>
                                <span>Shop</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Breadcrumb Section End -->

        <!-- Shop Section Begin -->
        <section class="shop spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="shop__sidebar">
                            <div class="shop__sidebar__search">
                                <form action="search">
                                    <input oninput="searchByName(this)" name="txtSearch" value="${txtS}"   type="text" placeholder="Search...">
                                    <button type="submit"><span class="icon_search"></span></button>
                                </form>
                            </div>
                            <div class="shop__sidebar__accordion">
                                <div class="accordion" id="accordionExample">
                                    <div class="card">
                                        <div class="card-heading">
                                            <a data-toggle="collapse" data-target="#collapseOne">Categories</a>
                                        </div>
                                        <div id="collapseOne" class="collapse show" data-parent="#accordionExample">
                                            <div class="card-body">
                                                <div class="shop__sidebar__categories">                                                                                                                                       
                                                    <ul class="nice-scroll">
                                                        <c:forEach items="${requestScope.ListCategories}" var="c">
                                                            <li><a href="filterCategory?categoryId=${c.id}">${c.name}</a></li>     
                                                            </c:forEach>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card">
                                        <div class="card-heading">
                                            <a data-toggle="collapse" data-target="#collapseTwo">Branding</a>
                                        </div>
                                        <div id="collapseTwo" class="collapse show" data-parent="#accordionExample">
                                            <div class="card-body">
                                                <div class="shop__sidebar__brand">
                                                    <ul>
                                                        <c:forEach items="${requestScope.ListSuppliers}"  var="s">
                                                            <li><a href="#">${s.name}</a></li>                                                
                                                            </c:forEach>

                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card">
                                        <div class="card-heading">
                                            <a data-toggle="collapse" data-target="#collapseThree">Filter Price</a>
                                        </div>
                                        <div id="collapseThree" class="collapse show" data-parent="#accordionExample">
                                            <div class="card-body">
                                                <div class="shop__sidebar__price">
                                                    <ul>
                                                        <li><a href="#">$0.00 - $50.00</a></li>
                                                        <li><a href="#">$50.00 - $100.00</a></li>
                                                        <li><a href="#">$100.00 - $150.00</a></li>
                                                        <li><a href="#">$150.00 - $200.00</a></li>
                                                        <li><a href="#">$200.00 - $250.00</a></li>
                                                        <li><a href="#">250.00+</a></li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card">
                                        <div class="card-heading">
                                            <a data-toggle="collapse" data-target="#collapseFour">Size</a>
                                        </div>
                                        <div id="collapseFour" class="collapse show" data-parent="#accordionExample">
                                            <div class="card-body">
                                                <div class="shop__sidebar__size">
                                                    <label for="xs">xs
                                                        <input type="radio" id="xs">
                                                    </label>
                                                    <label for="sm">s
                                                        <input type="radio" id="sm">
                                                    </label>
                                                    <label for="md">m
                                                        <input type="radio" id="md">
                                                    </label>
                                                    <label for="xl">xl
                                                        <input type="radio" id="xl">
                                                    </label>
                                                    <label for="2xl">2xl
                                                        <input type="radio" id="2xl">
                                                    </label>
                                                    <label for="xxl">xxl
                                                        <input type="radio" id="xxl">
                                                    </label>
                                                    <label for="3xl">3xl
                                                        <input type="radio" id="3xl">
                                                    </label>
                                                    <label for="4xl">4xl
                                                        <input type="radio" id="4xl">
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card">
                                        <div class="card-heading">
                                            <a data-toggle="collapse" data-target="#collapseFive">Colors</a>
                                        </div>
                                        <div id="collapseFive" class="collapse show" data-parent="#accordionExample">
                                            <div class="card-body">
                                                <div class="shop__sidebar__color">
                                                    <label class="c-1" for="sp-1">
                                                        <input type="radio" id="sp-1">
                                                    </label>
                                                    <label class="c-2" for="sp-2">
                                                        <input type="radio" id="sp-2">
                                                    </label>
                                                    <label class="c-3" for="sp-3">
                                                        <input type="radio" id="sp-3">
                                                    </label>
                                                    <label class="c-4" for="sp-4">
                                                        <input type="radio" id="sp-4">
                                                    </label>
                                                    <label class="c-5" for="sp-5">
                                                        <input type="radio" id="sp-5">
                                                    </label>
                                                    <label class="c-6" for="sp-6">
                                                        <input type="radio" id="sp-6">
                                                    </label>
                                                    <label class="c-7" for="sp-7">
                                                        <input type="radio" id="sp-7">
                                                    </label>
                                                    <label class="c-8" for="sp-8">
                                                        <input type="radio" id="sp-8">
                                                    </label>
                                                    <label class="c-9" for="sp-9">
                                                        <input type="radio" id="sp-9">
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card">
                                        <div class="card-heading">
                                            <a data-toggle="collapse" data-target="#collapseSix">Tags</a>
                                        </div>
                                        <div id="collapseSix" class="collapse show" data-parent="#accordionExample">
                                            <div class="card-body">
                                                <div class="shop__sidebar__tags">
                                                    <c:forEach items="${requestScope.ListTypes}" var="t">
                                                        <a href="#">${t.name}</a>
                                                    </c:forEach>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-9">
                        <div class="shop__product__option">
                            <div class="row">
                                <div class="col-lg-6 col-md-6 col-sm-6">
                                    <div class="shop__product__option__left">
                                        <p>Showing ${requestScope.productstart}–${requestScope.productend} of ${requestScope.totalproduct} results</p>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-6">
                                    <div class="shop__product__option__right">
                                        <p>Sort by Price:</p>
                                        <select>
                                            <option value="">Low To High</option>
                                            <option value="">$0 - $55</option>
                                            <option value="">$55 - $100</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row" id="listproduct">
                            <!-- star product  -->
                            <c:forEach items="${requestScope.ListProducts}" var="p">
                                <div class="col-lg-4 col-md-6 col-sm-6">
                                    <div class="product__item">
                                        <div class="product__item__pic set-bg" data-setbg="${p.images[0]}">
                                            <ul class="product__hover">
                                                <li><a href="#"><img src="img/icon/heart.png" alt=""><span>Add to favorite</span></a></li>
                                                <li><a href="#"><img src="img/icon/compare.png" alt=""><span>Add to wish list</span></a>
                                                </li>
                                                <li><a href="detail?productId=${p.id}"><img src="img/icon/search.png" alt=""><span>View details</span></a></li>
                                            </ul>
                                        </div>
                                        <div class="product__item__text">
                                            <h6>${p.name}</h6>
                                            <a href="addToCart?productId=${p.id}&quantity=1" class="add-cart">+ Add To Cart</a>
                                            <div class="rating">
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                            </div>
                                            <div style="display: flex;">
                                                <h5 style="margin-right: 138px">
                                                    $${p.price}
                                                </h5>
                                                <h6 style="color: #F27474;">  ${p.unitSold} Sold</h6>                                              

                                            </div>

                                            <div class="product__color__select">
                                                <label for="pc-4">
                                                    <input type="radio" id="pc-4">
                                                </label>
                                                <label class="active black" for="pc-5">
                                                    <input type="radio" id="pc-5">
                                                </label>
                                                <label class="grey" for="pc-6">
                                                    <input type="radio" id="pc-6">
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>

                            <!-- end product -->

                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="product__pagination">



                                    <!-- pagging in shopServlet -->
                                    <c:if test="${requestScope.DATA_FROM == 'home'}">
                                        <c:set var="page" value="${requestScope.CURRENTPAGE}"/>
                                        <ul class="pagination-list">
                                            <c:if test="${page != 1}">
                                                <li>
                                                    <a href="home?page=${page - 1}">«</a>
                                                </li>
                                            </c:if>
                                            <c:forEach var="i" begin="1" end="${requestScope.NUMBERPAGE}">
                                                <li>
                                                    <a style="${page == i ? "color: #e84c3d" :""}" href="home?page=${i}">${i}</a>
                                                </li>
                                            </c:forEach>
                                            <c:if test="${page != NUMBERPAGE}">
                                                <li>
                                                    <a href="home?page=${page + 1}">»</a>
                                                </li>
                                            </c:if>
                                        </ul>
                                    </c:if>
                                    <!-- pagging in shopServlet -->


                                    <!-- pagging in shopServlet where home  -->
                                    <c:if test="${requestScope.DATA_FROM == 'search'}">
                                        <c:set var="page" value="${requestScope.CURRENTPAGE}"/>
                                        <ul class="pagination-list">
                                            <c:if test="${page != 1}">
                                                <li>
                                                    <a href="search?page=${page - 1}">«</a>
                                                </li>
                                            </c:if>
                                            <c:forEach var="i" begin="1" end="${requestScope.NUMBERPAGE}">
                                                <li>
                                                    <a style="${page == i ? "color: #e84c3d" :""}" href="search?page=${i}">${i}</a>
                                                </li>
                                            </c:forEach>
                                            <c:if test="${page != NUMBERPAGE}">
                                                <li>
                                                    <a href="search?page=${page + 1}">»</a>
                                                </li>
                                            </c:if>
                                        </ul>
                                    </c:if>
                                    <!-- pagging in shopServlet -->




                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Shop Section End -->

        <!-- footer -->
        <%@include file="common/footer.jsp" %>
        <!-- footer -->


        <!-- Search Begin -->
        <div class="search-model">
            <div class="h-100 d-flex align-items-center justify-content-center">
                <div class="search-close-switch">+</div>
                <form class="search-model-form">
                    <input type="text" name="txtSearch" id="search-input" placeholder="Search here.....">
                </form>
            </div>
        </div>
        <!-- Search End -->

        <!-- Js Plugins -->
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.nice-select.min.js"></script>
        <script src="js/jquery.nicescroll.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/jquery.countdown.min.js"></script>
        <script src="js/jquery.slicknav.js"></script>
        <script src="js/mixitup.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/main.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script>

            fuction searchByName(param){
                var txtsearch = param.value;
                $.ajax({
                    url: "/prj_workshop_new/SearchbyAjax",
                    type: "get",
                    data: {
                        txtSearch: txtsearch,

                    },
                    success: function (data) {
                        var row = document.getElementById("listproduct");
                        row.innerHTML = data;
                    },
                    error: function (xhr) {
                    }
                });
            }
        </script>
    </body>

</html>