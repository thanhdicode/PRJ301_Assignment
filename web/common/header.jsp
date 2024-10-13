<%-- 
    Document   : header
    Created on : Jun 20, 2024, 10:28:19 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <a href="carts"><img src="img/icon/cart.png" alt=""> <span>0</span></a>
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
                                <li class="active"><a href="index">Home</a></li>
                                <li><a href="home">Shop</a></li>
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
                            <div class="price">${sessionScope.carts.size()}</div>
                        </div>
                    </div>
                </div>
                <div class="canvas__open"><i class="fa fa-bars"></i></div>
            </div>
        </header>
        <!-- Header Section End -->