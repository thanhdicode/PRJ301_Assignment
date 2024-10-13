<%-- 
    Document   : shop-details
    Created on : Jun 20, 2024, 10:25:39 AM
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
                <a href="carts"><img src="img/icon/cart.png" alt=""> <span></span></a>
                <div class="price">$0.00</div>
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
                                <li><a href="./inex.jsp">Home</a></li>
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

        <!-- Shop Details Section Begin -->
        <section class="shop-details">
            <div class="product__details__pic">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="product__details__breadcrumb">
                                <a href="index">Home</a>
                                <a href="home">Shop</a>
                                <span>Product Details</span>
                            </div>
                        </div>
                    </div>
                    <c:set var="pro" value="${requestScope.product}"/>
                    <div class="row">
                        <div class="col-lg-3 col-md-3">
                            <ul class="nav nav-tabs" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab">
                                        <div class="product__thumb__pic set-bg" data-setbg="${pro.images[0]}">
                                        </div>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab">
                                        <div class="product__thumb__pic set-bg" data-setbg="${pro.images[1]}">
                                        </div>
                                    </a>
                                </li>

                            </ul>
                        </div>
                        <div class="col-lg-6 col-md-9">
                            <div class="tab-content">
                                <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                    <div class="product__details__pic__item">
                                        <img src="${pro.images[0]}" alt="">
                                    </div>
                                </div>
                                <div class="tab-pane" id="tabs-2" role="tabpanel">
                                    <div class="product__details__pic__item">
                                        <img src="${pro.images[1]}" alt="">
                                    </div>
                                </div>


                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="product__details__content">
                <div class="container">
                    <div class="row d-flex justify-content-center">
                        <div class="col-lg-8">
                            <div class="product__details__text">
                                <h4>${pro.name}</h4>
                                <div class="rating">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <span> - 5 Reviews</span>
                                </div>
                                <h3>$${pro.salePrice} <span>${pro.price}</span></h3>
                                <p>${pro.description}</p>
                                <div class="product__details__option">
                                    <div class="product__details__option__size">
                                        <span>Size:</span>
                                        <label for="xxl">xxl
                                            <input type="radio" id="xxl">
                                        </label>
                                        <label  for="xl">xl
                                            <input type="radio" id="xl">
                                        </label>
                                        <label for="l">l
                                            <input type="radio" id="l">
                                        </label>
                                        <label for="sm">s
                                            <input type="radio" id="sm">
                                        </label>
                                    </div>
                                    <div class="product__details__option__color">
                                        <span>Color:</span>
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
                                        <label class="c-9" for="sp-9">
                                            <input type="radio" id="sp-9">
                                        </label>
                                    </div>
                                </div>
                                <!--                            <div class="product__details__cart__option">
                                                                <div class="quantity">
                                                                    <div class="pro-qty">
                                                                        <input type="text" value="1">
                                                                    </div>
                                                                </div>
                                                                <a href="addToCart?productId=${pro.id}" class="primary-btn">add to cart</a>
                                                            </div>-->
                                <form action="addToCart" method="get">
                                    <div class="product__details__cart__option">
                                        <div class="quantity">
                                            <div class="pro-qty">
                                                <input type="text" name="quantity" value="1">
                                            </div>
                                        </div>
                                        <input type="hidden" name="productId" value="${pro.id}">
                                        <button type="submit" class="primary-btn">Add to Cart</button>
                                    </div>
                                </form>
                                <div class="product__details__btns__option">
                                    <a href="#"><i class="fa fa-heart"></i> add to wishlist</a>
                                    <a href="#"><i class="fa fa-exchange"></i> Add To Compare</a>
                                </div>
                                <div class="product__details__last__option">
                                    <h5><span>Guaranteed Safe Checkout</span></h5>
                                    <img src="img/shop-details/details-payment.png" alt="">
                                    <ul>
                                        <li><span>SKU:</span> 3812912</li>
                                        <li><span>Categories:</span> ${pro.category}</li>
                                        <li><span>Tag:</span> Clothes, Body</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="product__details__tab">
                                <ul class="nav nav-tabs" role="tablist">
                                    <li class="nav-item">
                                        <a class="nav-link active" data-toggle="tab" href="#tabs-5"
                                           role="tab">Description</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" data-toggle="tab" href="#tabs-6" role="tab">Customer
                                            Previews(5)</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" data-toggle="tab" href="#tabs-7" role="tab">Additional
                                            information</a>
                                    </li>
                                </ul>
                                <div class="tab-content">
                                    <div class="tab-pane active" id="tabs-5" role="tabpanel">
                                        <div class="product__details__tab__content">
                                            <p class="note">Nam tempus turpis at metus scelerisque placerat nulla deumantos
                                                solicitud felis. Pellentesque diam dolor, elementum etos lobortis des mollis
                                                ut risus. Sedcus faucibus an sullamcorper mattis drostique des commodo
                                                pharetras loremos.</p>
                                            <div class="product__details__tab__content__item">
                                                <h5>Products Infomation</h5>
                                                <p>A Pocket PC is a handheld computer, which features many of the same
                                                    capabilities as a modern PC. These handy little devices allow
                                                    individuals to retrieve and store e-mail messages, create a contact
                                                    file, coordinate appointments, surf the internet, exchange text messages
                                                    and more. Every product that is labeled as a Pocket PC must be
                                                    accompanied with specific software to operate the unit and must feature
                                                    a touchscreen and touchpad.</p>
                                                <p>As is the case with any new technology product, the cost of a Pocket PC
                                                    was substantial during it’s early release. For approximately $700.00,
                                                    consumers could purchase one of top-of-the-line Pocket PCs in 2003.
                                                    These days, customers are finding that prices have become much more
                                                    reasonable now that the newness is wearing off. For approximately
                                                    $350.00, a new Pocket PC can now be purchased.</p>
                                            </div>
                                            <div class="product__details__tab__content__item">
                                                <h5>Material used</h5>
                                                <p>Polyester is deemed lower quality due to its none natural quality’s. Made
                                                    from synthetic materials, not natural like wool. Polyester suits become
                                                    creased easily and are known for not being breathable. Polyester suits
                                                    tend to have a shine to them compared to wool and cotton suits, this can
                                                    make the suit look cheap. The texture of velvet is luxurious and
                                                    breathable. Velvet is a great choice for dinner party jacket and can be
                                                    worn all year round.</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="tab-pane" id="tabs-6" role="tabpanel">
                                        <div class="product__details__tab__content">
                                            <div class="product__details__tab__content__item">
                                                <h5>Products Infomation</h5>
                                                <p>A Pocket PC is a handheld computer, which features many of the same
                                                    capabilities as a modern PC. These handy little devices allow
                                                    individuals to retrieve and store e-mail messages, create a contact
                                                    file, coordinate appointments, surf the internet, exchange text messages
                                                    and more. Every product that is labeled as a Pocket PC must be
                                                    accompanied with specific software to operate the unit and must feature
                                                    a touchscreen and touchpad.</p>
                                                <p>As is the case with any new technology product, the cost of a Pocket PC
                                                    was substantial during it’s early release. For approximately $700.00,
                                                    consumers could purchase one of top-of-the-line Pocket PCs in 2003.
                                                    These days, customers are finding that prices have become much more
                                                    reasonable now that the newness is wearing off. For approximately
                                                    $350.00, a new Pocket PC can now be purchased.</p>
                                            </div>
                                            <div class="product__details__tab__content__item">
                                                <h5>Material used</h5>
                                                <p>Polyester is deemed lower quality due to its none natural quality’s. Made
                                                    from synthetic materials, not natural like wool. Polyester suits become
                                                    creased easily and are known for not being breathable. Polyester suits
                                                    tend to have a shine to them compared to wool and cotton suits, this can
                                                    make the suit look cheap. The texture of velvet is luxurious and
                                                    breathable. Velvet is a great choice for dinner party jacket and can be
                                                    worn all year round.</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="tab-pane" id="tabs-7" role="tabpanel">
                                        <div class="product__details__tab__content">
                                            <p class="note">Nam tempus turpis at metus scelerisque placerat nulla deumantos
                                                solicitud felis. Pellentesque diam dolor, elementum etos lobortis des mollis
                                                ut risus. Sedcus faucibus an sullamcorper mattis drostique des commodo
                                                pharetras loremos.</p>
                                            <div class="product__details__tab__content__item">
                                                <h5>Products Infomation</h5>
                                                <p>A Pocket PC is a handheld computer, which features many of the same
                                                    capabilities as a modern PC. These handy little devices allow
                                                    individuals to retrieve and store e-mail messages, create a contact
                                                    file, coordinate appointments, surf the internet, exchange text messages
                                                    and more. Every product that is labeled as a Pocket PC must be
                                                    accompanied with specific software to operate the unit and must feature
                                                    a touchscreen and touchpad.</p>
                                                <p>As is the case with any new technology product, the cost of a Pocket PC
                                                    was substantial during it’s early release. For approximately $700.00,
                                                    consumers could purchase one of top-of-the-line Pocket PCs in 2003.
                                                    These days, customers are finding that prices have become much more
                                                    reasonable now that the newness is wearing off. For approximately
                                                    $350.00, a new Pocket PC can now be purchased.</p>
                                            </div>
                                            <div class="product__details__tab__content__item">
                                                <h5>Material used</h5>
                                                <p>Polyester is deemed lower quality due to its none natural quality’s. Made
                                                    from synthetic materials, not natural like wool. Polyester suits become
                                                    creased easily and are known for not being breathable. Polyester suits
                                                    tend to have a shine to them compared to wool and cotton suits, this can
                                                    make the suit look cheap. The texture of velvet is luxurious and
                                                    breathable. Velvet is a great choice for dinner party jacket and can be
                                                    worn all year round.</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Shop Details Section End -->

        <!-- Related Section Begin -->
        <section class="related spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <h3 class="related-title">Related Product</h3>
                    </div>
                </div>
                <div class="row">
                    <!-- related product start -->
                    <c:forEach items="${requestScope.listProductsRelated}" var="pl">
                        <c:if test="${pro.id != pl.id}">


                            <div class="col-lg-3 col-md-6 col-sm-6 col-sm-6">
                                <div class="product__item">
                                    <div class="product__item__pic set-bg" data-setbg="${pl.images[0]}">
                                        <span class="label">New</span>
                                        <ul class="product__hover">
                                            <li><a href="#"><img src="img/icon/heart.png" alt=""><span>Add to favorite</span></a></li>
                                            <li><a href="#"><img src="img/icon/compare.png" alt=""> <span>Compare</span></a></li>
                                            <li><a href="detail?productId=${pl.id}"><img src="img/icon/search.png" alt=""><span>View detail</span></a></li>
                                        </ul>
                                    </div>
                                    <div class="product__item__text">
                                        <h6>${pl.name}</h6>
                                        <a href="addToCart?productId=${pl.id}&quantity=1" class="add-cart">+ Add To Cart</a>
                                        <div class="rating">
                                            <i class="fa fa-star-o"></i>
                                            <i class="fa fa-star-o"></i>
                                            <i class="fa fa-star-o"></i>
                                            <i class="fa fa-star-o"></i>
                                            <i class="fa fa-star-o"></i>
                                        </div>
                                        <h5>${pl.price}</h5>
                                        <div class="product__color__select">
                                            <label for="pc-1">
                                                <input type="radio" id="pc-1">
                                            </label>
                                            <label class="active black" for="pc-2">
                                                <input type="radio" id="pc-2">
                                            </label>
                                            <label class="grey" for="pc-3">
                                                <input type="radio" id="pc-3">
                                            </label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                    <!-- related product end -->

                </div>
            </div>
        </section>
        <!-- Related Section End -->

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