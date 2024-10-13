<%-- 
    Document   : sortproducts
    Created on : Jun 24, 2024, 2:42:06 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
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
                                        <a href="addToCart?productId=${p.id}" class="add-cart">+ Add To Cart</a>
                                        <div class="rating">
                                            <i class="fa fa-star-o"></i>
                                            <i class="fa fa-star-o"></i>
                                            <i class="fa fa-star-o"></i>
                                            <i class="fa fa-star-o"></i>
                                            <i class="fa fa-star-o"></i>
                                        </div>
                                        <h5>$${p.price}</h5>
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
    </body>
</html>
