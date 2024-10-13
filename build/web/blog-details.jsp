<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : blog-details
    Created on : Jun 20, 2024, 10:22:34 AM
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
        <title>Male-Fashion | Template</title>

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
                                <li><a href="home">Shop</a></li>
                                <li><a href="#">Pages</a>
                                    <ul class="dropdown">
                                        <li><a href="DispatchServlet?btnAction=aboutus">About Us</a></li> 

                                        <li><a href="carts">Shopping Cart</a></li>


                                    </ul>
                                </li>
                                <li class="active"><a href="DispatchServlet?btnAction=Blog">Blog</a></li>
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

        <!-- Blog Details Hero Begin -->
        <section class="blog-hero spad">
            <div class="container">
                <div class="row d-flex justify-content-center">
                    <div class="col-lg-9 text-center">
                        <div class="blog__hero__text">
                            <h2>🌟🎉 DỰ ĐOÁN KẾT QUẢ - TRÚNG QUÀ CỰC ĐÃ!!! 🎉🌟</h2>
                            <ul>
                                <li>By Admin</li>
                                <li>June 17, 2024</li>
                                <li>8 Comments</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Blog Details Hero End -->

        <!-- Blog Details Section Begin -->
        <section class="blog-details spad">
            <div class="container">
                <div class="row d-flex justify-content-center">
                    <div class="col-lg-12">
                        <div class="blog__details__pic">
                            <img src="img/hero/detail_pic.jpg" alt=""/>
                        </div>
                    </div>
                    <div class="col-lg-8">
                        <div class="blog__details__content">
                            <div class="blog__details__share">
                                <span>share</span>
                                <ul>
                                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#" class="twitter"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#" class="youtube"><i class="fa fa-youtube-play"></i></a></li>
                                    <li><a href="#" class="linkedin"><i class="fa fa-linkedin"></i></a></li>
                                </ul>
                            </div>
                            <div class="blog__details__text">
                                <p>Mùa EURO đang đến gần, không khí bóng đá cuồng nhiệt đang tràn ngập khắp mọi nơi. Bạn có muốn vừa thỏa mãn niềm đam mê bóng đá vừa có cơ hội nhận được những phần quà giá trị không? Hãy tham gia ngay chương trình khuyến mãi siêu hấp dẫn của chúng tôi và biến ước mơ thành hiện thực!</p>
                                <p>Cách thức tham gia:</p>
                                   <p> 1.Mua sắm dễ dàng: Mua bất kỳ đơn hàng nào từ 200k trở lên tại cửa hàng của chúng tôi.</p>
                                   <p> 2.Nhận con số may mắn: Sau khi mua sắm, bạn sẽ nhận ngay 1 con số dự thưởng.</p>
                                   <p> 3.Dự đoán thông minh: Comment con số dự thưởng của bạn xuống dưới bài viết này kèm theo hashtag @choilatrung và tỉ số của 2 đội mà bạn nghĩ sẽ gặp nhau trong vòng chung kết.</p>
                                   <p >Ví dụ: @choilatrung 3-2 Đức vs Pháp</p>
                            </div>
                            <div class="blog__details__quote">
                                <i class="fa fa-quote-left"></i>
                                <p>“Ronaldo đang trong giai đoạn sung mãn nhất trong sự nghiệp, kể từ khi anh bắt đầu thi đấu chuyên nghiệp,
                                    1 lời thách thức với các đội tuyển khác”</p>
                                <h6>_ BLV- Trương Anh Ngọc _</h6>
                            </div>
                            <div class="blog__details__text">
                                <p>Giải thưởng cực kỳ hấp dẫn:</p>
                                <p>🏆 Giải nhất: Một chuyến du lịch tới Đức, nơi diễn ra trận chung kết EURO! Cơ hội để bạn hòa mình vào không khí bóng đá đỉnh cao tại sân vận động danh tiếng.</p>
                                <p>🎟 Giải nhì: Một phiếu mua hàng trị giá 10 triệu đồng, thoả sức mua sắm những gì bạn thích.</p>
                                <p>👕 Giải ba: Một áo đấu chính hãng của đội tuyển Đức, kèm chữ ký của các thành viên đội. Món quà độc đáo dành cho fan hâm mộ bóng đá chân chính.</p>





                                <p>Lưu ý: Người chơi nào bình chọn đúng nhất và sớm nhất sẽ được tính. Nhanh tay tham gia để không bỏ lỡ cơ hội quý giá này!</p>
                                <p>Hãy nhanh tay tham gia và chia sẻ ngay với bạn bè để cùng nhau đón nhận những phần quà tuyệt vời!</p>
                            </div>
                            <div class="blog__details__option">
                                <div class="row">
                                    <div class="col-lg-6 col-md-6 col-sm-6">
                                        <div class="blog__details__author">
                                            <div class="blog__details__author__pic">
                                                <img src="img/blog/details/toi.jpg" alt="">
                                            </div>
                                            <div class="blog__details__author__text">
                                                <h5>Thanh huynh</h5>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-6">
                                        <div class="blog__details__tags">
                                            <a href="#">#choilatrung</a>
                                            <a href="#"> #Euro2024</a>
                                            <a href="#">#MuaSamThongMinh</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="blog__details__btns">
                                <div class="row">
                                    <div class="col-lg-6 col-md-6 col-sm-6">
                                        <a href="" class="blog__details__btns__item">
                                            <p><span class="arrow_left"></span> Previous Pod</p>
                                            <h5>Siêu máy tính dự đoán tuyển Anh có tỉ lệ giành chức vô địch cao nhất</h5>
                                        </a>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-6">
                                        <a href="" class="blog__details__btns__item blog__details__btns__item--next">
                                            <p>Next Pod <span class="arrow_right"></span></p>
                                            <h5>Vì sao người ta gọi Euro là giải đấu hấp dẫn nhất hành tinh ?</h5>
                                        </a>
                                    </div>
                                </div>
                            </div>

                            <!--                             Toni Kross 
                                                        <div class="blog__details__option">
                                                            <div class="row">
                                                                <div class="col-lg-6 col-md-6 col-sm-6">
                                                                    <div class="blog__details__author">
                                                                        <div class="blog__details__author__pic">
                                                                            <img src="img/cauthu/tonikroos.jpg" alt="">
                                                                        </div>
                                                                        <div class="blog__details__author__text">
                                                                            <h5>Toni Kroos</h5>
                                                                            
                            
                                                                        </div>
                                                                        <div class="blog__details__author__text">
                                                                            
                                                                            <h6>Hẹn gặp ở chung kết nha mấy con gà</h6>
                            
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-lg-6 col-md-6 col-sm-6">
                                                                    <div class="blog__details__tags">
                                                                        <a href="#">#Germany</a>
                                                                        <a href="#">#3-0</a>
                                                                        <a href="#">#France</a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                         TK 
                            
                                                         Lukaku 
                                                        <div class="blog__details__option">
                                                            <div class="row">
                                                                <div class="col-lg-6 col-md-6 col-sm-6">
                                                                    <div class="blog__details__author">
                                                                        <div class="blog__details__author__pic">
                                                                            <img src="img/cauthu/lukaku.jpg" alt="">
                                                                        </div>
                                                                        <div class="blog__details__author__text">
                                                                            <h5>Romelo Lukaku</h5>
                                                                            
                                                                        </div>
                                                                        <div class="blog__details__author__text">
                                                                            
                                                                            <h6>Tôi đã đánh mất chính mình</h6>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-lg-6 col-md-6 col-sm-6">
                                                                    <div class="blog__details__tags">
                                                                        <a href="#">#Belgium</a>
                                                                        <a href="#">#2-0</a>
                                                                        <a href="#">#Germany</a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                         lukaku 
                            
                                                         Kane  
                                                        <div class="blog__details__option">
                                                            <div class="row">
                                                                <div class="col-lg-6 col-md-6 col-sm-6">
                                                                    <div class="blog__details__author">
                                                                        <div class="blog__details__author__pic">
                                                                            <img src="img/cauthu/kane.jpg" alt="">
                                                                        </div>
                                                                        <div class="blog__details__author__text">
                                                                            <h5>Harry Kane</h5>
                            
                                                                        </div>
                            
                                                                    </div>
                                                                    <div class="blog__details__author__text">
                            
                                                                        <h6>Xin 1 cái danh hiệu coi, sắp giải nghệ luôn rồi vẫn chưa có gì :((</h6>
                                                                    </div>
                                                                </div>
                                                                <div class="col-lg-6 col-md-6 col-sm-6">
                                                                    <div class="blog__details__tags">
                                                                        <a href="#">#England</a>
                                                                        <a href="#">#1-0</a>
                                                                        <a href="#">#Portugal</a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                         Kane 
                            
                                                         Cr7 
                                                        <div class="blog__details__option">
                                                            <div class="row">
                                                                <div class="col-lg-6 col-md-6 col-sm-6">
                                                                    <div class="blog__details__author">
                                                                        <div class="blog__details__author__pic">
                                                                            <img src="img/blog/details/blog-author.jpg" alt="">
                                                                        </div>
                                                                        <div class="blog__details__author__text">
                                                                            <h5>Cristiano Ronaldo</h5>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-lg-6 col-md-6 col-sm-6">
                                                                    <div class="blog__details__tags">
                                                                        <a href="#">#Fashion</a>
                                                                        <a href="#">#Trending</a>
                                                                        <a href="#">#2020</a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                         comment 
                            
                                                         Mpappe  
                                                        <div class="blog__details__option">
                                                            <div class="row">
                                                                <div class="col-lg-6 col-md-6 col-sm-6">
                                                                    <div class="blog__details__author">
                                                                        <div class="blog__details__author__pic">
                                                                            <img src="img/blog/details/blog-author.jpg" alt="">
                                                                        </div>
                                                                        <div class="blog__details__author__text">
                                                                            <h5> Kylian Mbappe</h5>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-lg-6 col-md-6 col-sm-6">
                                                                    <div class="blog__details__tags">
                                                                        <a href="#">#Fashion</a>
                                                                        <a href="#">#Trending</a>
                                                                        <a href="#">#2020</a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                         comment 
                            
                                                         Messi 
                                                        <div class="blog__details__option">
                                                            <div class="row">
                                                                <div class="col-lg-6 col-md-6 col-sm-6">
                                                                    <div class="blog__details__author">
                                                                        <div class="blog__details__author__pic">
                                                                            <img src="img/blog/details/blog-author.jpg" alt="">
                                                                        </div>
                                                                        <div class="blog__details__author__text">
                                                                            <h5>Lionel Messi</h5>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-lg-6 col-md-6 col-sm-6">
                                                                    <div class="blog__details__tags">
                                                                        <a href="#">#Fashion</a>
                                                                        <a href="#">#Trending</a>
                                                                        <a href="#">#2020</a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                         Messi 
                            
                                                         Muller 
                                                        <div class="blog__details__option">
                                                            <div class="row">
                                                                <div class="col-lg-6 col-md-6 col-sm-6">
                                                                    <div class="blog__details__author">
                                                                        <div class="blog__details__author__pic">
                                                                            <img src="img/blog/details/blog-author.jpg" alt="">
                                                                        </div>
                                                                        <div class="blog__details__author__text">
                                                                            <h5>Thomas Muller</h5>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-lg-6 col-md-6 col-sm-6">
                                                                    <div class="blog__details__tags">
                                                                        <a href="#">#Fashion</a>
                                                                        <a href="#">#Trending</a>
                                                                        <a href="#">#2020</a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                            
                                                         Rodrygo 
                                                        <div class="blog__details__option">
                                                            <div class="row">
                                                                <div class="col-lg-6 col-md-6 col-sm-6">
                                                                    <div class="blog__details__author">
                                                                        <div class="blog__details__author__pic">
                                                                            <img src="img/blog/details/blog-author.jpg" alt="">
                                                                        </div>
                                                                        <div class="blog__details__author__text">
                                                                            <h5>Rodrygo</h5>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-lg-6 col-md-6 col-sm-6">
                                                                    <div class="blog__details__tags">
                                                                        <a href="#">#Fashion</a>
                                                                        <a href="#">#Trending</a>
                                                                        <a href="#">#2020</a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                            
                                                         Vini 
                                                        <div class="blog__details__option">
                                                            <div class="row">
                                                                <div class="col-lg-6 col-md-6 col-sm-6">
                                                                    <div class="blog__details__author">
                                                                        <div class="blog__details__author__pic">
                                                                            <img src="img/blog/details/blog-author.jpg" alt="">
                                                                        </div>
                                                                        <div class="blog__details__author__text">
                                                                            <h5>Vini jr</h5>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-lg-6 col-md-6 col-sm-6">
                                                                    <div class="blog__details__tags">
                                                                        <a href="#">#Fashion</a>
                                                                        <a href="#">#Trending</a>
                                                                        <a href="#">#2020</a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="blog__details__comment">
                                                            <h4>Leave A Comment</h4>
                                                            <form action="#">
                                                                <div class="row">
                                                                    <div class="col-lg-4 col-md-4">
                                                                        <input type="text" placeholder="Name">
                                                                    </div>
                                                                    <div class="col-lg-4 col-md-4">
                                                                        <input type="text" placeholder="Email">
                                                                    </div>
                                                                    <div class="col-lg-4 col-md-4">
                                                                        <input type="text" placeholder="Phone">
                                                                    </div>
                                                                    <div class="col-lg-12 text-center">
                                                                        <textarea placeholder="Comment"></textarea>
                                                                        <button type="submit" class="site-btn">Post Comment</button>
                                                                    </div>
                                                                </div>
                                                            </form>
                                                        </div>-->
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Blog Details Section End -->


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
