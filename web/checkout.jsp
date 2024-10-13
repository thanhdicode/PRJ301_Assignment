

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <style>
            .checkout__order {
                background: #fff;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 4px 8px rgba(0,0,0,0.1);
                transition: transform 0.3s, box-shadow 0.3s;
            }

            .checkout__order:hover {
                transform: scale(1.02);
                box-shadow: 0 8px 16px rgba(0,0,0,0.2);
            }

            .order__title {
                font-size: 24px;
                font-weight: 700;
                margin-bottom: 20px;
                text-align: center;
            }

            .checkout__order__products {
                font-weight: 700;
                margin-bottom: 15px;
                display: flex;
                justify-content: space-between;
            }

            .checkout__total__products {
                list-style: none;
                padding: 0;
                margin: 0;
            }

            .checkout__total__products li {
                display: flex;
                justify-content: space-between;
                margin-bottom: 10px;
            }

            .checkout__total__all {
                list-style: none;
                padding: 0;
                margin: 20px 0;
            }

            .checkout__total__all li {
                display: flex;
                justify-content: space-between;
                margin-bottom: 10px;
                font-weight: 700;
            }

            .checkout__input__checkbox {
                margin-bottom: 20px;
            }

            .checkout__input__checkbox label {
                display: flex;
                align-items: center;
                cursor: pointer;
            }

            .checkout__input__checkbox input[type="checkbox"] {
                margin-right: 10px;
            }

            .site-btn {
                display: block;
                width: 100%;
                background: #e84c3d;
                color: #fff;
                padding: 15px;
                border: none;
                border-radius: 5px;
                font-size: 16px;
                font-weight: 700;
                cursor: pointer;
                transition: background 0.3s;
            }

            .site-btn:hover {
                background: #d43f33;
            }

            .site-btn:active {
                transform: scale(0.98);
            }

            .checkout__order {
                background-color: #f9f9f9;
                border-radius: 10px;
                padding: 30px;
                box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
                transition: all 0.3s ease;
            }

            .checkout__order:hover {
                transform: translateY(-5px);
                box-shadow: 0 6px 12px rgba(0, 0, 0, 0.15);
            }

            .order__title {
                font-size: 24px;
                margin-bottom: 20px;
                color: #333;
                border-bottom: 2px solid #e0e0e0;
                padding-bottom: 10px;
            }

            .checkout__order__products {
                display: flex;
                justify-content: space-between;
                font-weight: bold;
                margin-bottom: 10px;
                color: #555;
            }

            .checkout__total__products {
                list-style: none;
                padding: 0;
            }

            .product-item {
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: 10px 0;
                border-bottom: 1px solid #e0e0e0;
                transition: background-color 0.3s ease;
            }

            .product-item:hover {
                background-color: #f0f0f0;
            }

            .product-name {
                flex: 2;
                font-size: 14px;
            }

            .product-total, .product-quantity {
                flex: 1;
                text-align: right;
                font-size: 14px;
            }

            .checkout__total__all {
                list-style: none;
                padding: 0;
                margin-top: 20px;
            }

            .checkout__total__all li {
                display: flex;
                justify-content: space-between;
                margin-bottom: 10px;
                font-size: 16px;
            }

            .total {
                font-weight: bold;
                font-size: 18px;
                color: #e53637;
            }

            .confirmation-message {
                margin: 20px 0;
                font-style: italic;
                color: #777;
            }

            .payment-options {
                margin-bottom: 20px;
            }

            .payment-option {
                display: block;
                position: relative;
                padding-left: 35px;
                margin-bottom: 12px;
                cursor: pointer;
                font-size: 16px;
                user-select: none;
            }

            .payment-option input {
                position: absolute;
                opacity: 0;
                cursor: pointer;
                height: 0;
                width: 0;
            }

            .checkmark {
                position: absolute;
                top: 0;
                left: 0;
                height: 25px;
                width: 25px;
                background-color: #eee;
                border-radius: 4px;
                transition: all 0.3s ease;
            }

            .payment-option:hover input ~ .checkmark {
                background-color: #ccc;
            }

            .payment-option input:checked ~ .checkmark {
                background-color: #e53637;
            }

            .checkmark:after {
                content: "";
                position: absolute;
                display: none;
            }

            .payment-option input:checked ~ .checkmark:after {
                display: block;
            }

            .payment-option .checkmark:after {
                left: 9px;
                top: 5px;
                width: 5px;
                height: 10px;
                border: solid white;
                border-width: 0 3px 3px 0;
                transform: rotate(45deg);
            }

            .site-btn {
                background-color: #e53637;
                color: white;
                border: none;
                padding: 12px 30px;
                font-size: 16px;
                border-radius: 5px;
                cursor: pointer;
                transition: all 0.3s ease;
                width: 100%;
            }

            .site-btn:hover {
                background-color: #d32f2f;
                transform: translateY(-2px);
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
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
                            <h4>Check Out</h4>
                            <div class="breadcrumb__links">
                                <a href="index">Home</a>
                                <a href="home">Shop</a>
                                <span>Check Out</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Breadcrumb Section End -->

        <!-- Checkout Section Begin -->
        <section class="checkout spad">
            <div class="container">
                <div class="checkout__form">
                    <form action="#">
                        <div class="row">
                            <form action="checkout" method="post">
                                <div class="col-lg-6 col-md-6">
                                    <c:set value="${sessionScope.acc}" var="ac"/>

                                    <h6 class="checkout__title">Billing Details</h6>

                                    <div class="row">
                                        <div class="col-lg-6">
                                            <div class="checkout__input">
                                                <p>Fist Name<span>*</span></p>
                                                <input name="firstName" id="firstName" readonly="" placeholder="${ac.firstName}" type="text" >
                                            </div>
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="checkout__input">
                                                <p>Last Name<span>*</span></p>
                                                <input readonly="" placeholder="${ac.lastName}" type="text" name="lastName" id="lastName">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="checkout__input">
                                        <p>Country<span>*</span></p>
                                        <input name="country" id="country" placeholder="Viet Nam" readonly="" type="text">
                                    </div>
                                    <div class="checkout__input">
                                        <p>Address<span>*</span></p>
                                        <input name="address" id="address" readonly="" type="text" placeholder="${ac.address}" class="checkout__input__add">
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <div class="checkout__input">
                                                <p>Phone<span>*</span></p>
                                                <input  name="phone" id="phone" readonly="" placeholder="${ac.phone}" type="text">
                                            </div>
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="checkout__input">
                                                <p>Email<span>*</span></p>
                                                <input name="email" id="email" readonly="" placeholder="${ac.email}" type="text">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="checkout__input">
                                        <p>Order notes<span>*</span></p>
                                        <input type="text"
                                               placeholder="Notes about your order, e.g. special notes for delivery.">
                                    </div>


                                    <div class="continue__btn">
                                        <a href="ProfileServlet"> edit you profile </a>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6">
                                    <div class="checkout__order">
                                        <h4 class="order__title">Your order</h4>
                                        <div class="checkout__order__products">
                                            <span>Product</span>
                                            <span>Total</span>
                                            <span>Quantity</span>
                                        </div>
                                        <ul class="checkout__total__products">
                                            <c:forEach items="${requestScope.carts}" var="CA">
                                                <li class="product-item">
                                                    <span class="product-name">${CA.value.product.name}</span>
                                                    <span class="product-total">$${CA.value.product.price * CA.value.quantity}</span>
                                                    <span class="product-quantity">${CA.value.quantity}</span>
                                                </li>
                                            </c:forEach>
                                        </ul>
                                        <ul class="checkout__total__all">
                                            <li>Subtotal <span>$ ${requestScope.totalMoney}</span></li>
                                            <li>Shipping cost <span>$ 10.00</span></li>
                                            <li class="total">Total <span>$ ${requestScope.totalMoney + 10}</span></li>
                                        </ul>
                                        <p class="confirmation-message">We will send you an email to confirm the bill</p>
                                        <div class="payment-options">
                                            <label class="payment-option" for="payment">
                                                <input type="checkbox" id="payment">
                                                <span class="checkmark"></span>
                                                <span class="option-text">Check Payment</span>
                                            </label>
                                            <label class="payment-option" for="paypal">
                                                <input type="checkbox" id="paypal">
                                                <span class="checkmark"></span>
                                                <span class="option-text">Paypal</span>
                                            </label>
                                        </div>
                                        <button type="submit" class="site-btn">PLACE ORDER</button>
                                    </div>                           
                                </div>
                            </form>
                        </div>
                </div>
            </div>
        </section>
        <!-- Checkout Section End -->

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
        <script>
            document.addEventListener('DOMContentLoaded', function () {
                const checkboxes = document.querySelectorAll('.payment-option input[type="checkbox"]');
                checkboxes.forEach(checkbox => {
                    checkbox.addEventListener('change', function () {
                        checkboxes.forEach(cb => {
                            if (cb !== this)
                                cb.checked = false;
                        });
                    });
                });

                const productItems = document.querySelectorAll('.product-item');
                productItems.forEach(item => {
                    item.addEventListener('mouseenter', function () {
                        this.style.transform = 'scale(1.02)';
                    });
                    item.addEventListener('mouseleave', function () {
                        this.style.transform = 'scale(1)';
                    });
                });

                const placeOrderBtn = document.querySelector('.site-btn');
                placeOrderBtn.addEventListener('click', function (e) {
                    e.preventDefault();
                    this.classList.add('order-processing');
                    this.textContent = 'Processing...';
                    setTimeout(() => {
                        this.classList.remove('order-processing');
                        this.textContent = 'Order Placed!';
                        this.style.backgroundColor = '#4CAF50';
                    }, 2000);
                });
            });
        </script>
    </body>

</html>
