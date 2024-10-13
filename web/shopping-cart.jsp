<%-- 
    Document   : shopping-cart
    Created on : Jun 20, 2024, 10:26:38 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="/WEB-INF/tlds/cart-tag-library" %>
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
                <a href="#"><img src="img/icon/cart.png" alt=""> </a>
                <div class="price">${sessionScope.carts.size()}</div>
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
                            <h4>Shopping Cart</h4>
                            <div class="breadcrumb__links">
                                <a href="index">Home</a>
                                <a href="home">Shop</a>
                                <span>Shopping Cart</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Breadcrumb Section End -->

        <!-- Shopping Cart Section Begin -->
        <section class="shopping-cart spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8">
                        <div class="shopping__cart__table">

                            <c:choose>
                                <c:when test="${sessionScope.carts.size()==0 || sessionScope.carts==null }">
                                    <h1>List carts is empty</h1>
                                </c:when>
                                <c:otherwise>





                                    <table>
                                        <thead>
                                            <tr>
                                                <th>Product</th>
                                                <th>Quantity</th>
                                                <th>Total</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <!-- items in the cart start -->
                                            <c:forEach items="${requestScope.carts}" var="ca">
                                            <form action="updateQuantity" >
                                                <tr>
                                                <input type="hidden" name="productId" value="${ca.value.product.id}"  />
                                                    <td class="product__cart__item">
                                                        <div class="product__cart__item__pic">
                                                            <img src="${ca.value.product.images[0]}" width="50" alt="">
                                                        </div>
                                                        <div class="product__cart__item__text">
                                                            <h6>${ca.value.product.name}</h6>
                                                            <h5>${ca.value.product.price}</h5>
                                                        </div>
                                                    </td>
                                                    <td class="quantity__item">
                                                        <div class="quantity">
                                                            <div class="pro-qty-2">
                                                                <input onchange="this.form.submit()" name="quantity" type="number" value="${ca.value.quantity}">
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td class="cart__price">${ca.value.product.price*ca.value.quantity}</td>
                                                    <td class="cart__close"><a href="deleteCart?productId=${ca.value.product.id}"><i class="fa fa-close"></i></a></td>
                                                </tr>
                                            </form>
                                                <!-- items in the cart end -->
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </c:otherwise>
                            </c:choose>

                        </div>
                        <div class="row">
                            <div class="col-lg-6 col-md-6 col-sm-6">
                                <div class="continue__btn">
                                    <a href="home">Continue Shopping</a>
                                </div>
                            </div>
                            <!--                        <div class="col-lg-6 col-md-6 col-sm-6">
                                                        <div class="continue__btn update__btn">
                                                            <a href=""><i class="fa fa-spinner"></i> Update cart</a>
                                                        </div>
                                                    </div>-->
                        </div>
                    </div>
                    <c:choose>
                        <c:when test="${sessionScope.carts.size()==0 || sessionScope.carts==null }">

                        </c:when>
                        <c:otherwise>
                            <div class="col-lg-4">
                                <div class="cart__discount">
                                    <h6>Discount codes</h6>
                                    <form action="#">
                                        <input type="text" placeholder="Coupon code">
                                        <button type="submit">Apply</button>
                                    </form>
                                </div>
                                <div class="cart__total">
                                    <h6>Cart total</h6>
                                    <ul>
                                        <li>Subtotal <span>$ ${requestScope.totalMoney} </span></li>
                                        <li>Shipping cost <span>$ 10.00</span></li>
                                        <li>Total <span>$ ${requestScope.totalMoney + 10} </span></li>
                                    </ul>
                                        <c:choose>
                                            <c:when test="${sessionScope.acc==null}">
                                                <p>
                                                    You have to login to checkout
                                                </p>
                                                <a href="DispatchServlet?btnAction=Login">
                                                    Click here to login
                                                </a>
                                            </c:when>
                                            <c:otherwise>
                                                <a href="checkout" class="primary-btn">Proceed to checkout</a>
                                            </c:otherwise>
                                        </c:choose>
                                             
                                </div>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </section>
        <!-- Shopping Cart Section End -->

        <!-- footer -->
        <%@include file="common/footer.jsp" %>
        <!-- footer -->


        <!-- Search Begin -->
        <div class="search-model">
            <div class="h-100 d-flex align-items-center justify-content-center">
                <div class="search-close-switch">+</div>
                <form class="search-model-form">
                    <input type="text" id="search-input" placeholder="Search here.....">
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
    </body>

</html>