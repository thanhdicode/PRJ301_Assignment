<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="no-js" lang="zxx">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Forgot Password</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="view/assets/home/img/favicon.png">
    <!-- all css here -->
    <%@include file="../../common/web/add_css.jsp"%>
</head>
<body>
    <!-- Add your site or application content here -->
    <!--pos page start-->
    <div class="pos_page">
        <div class="container">
            <!--pos page inner-->
            <div class="pos_page_inner">
                <!--header area -->
                
                <!--header end -->
                <!--breadcrumbs area start-->
                <div class="breadcrumbs_area">
                    <div class="row">
                        <div class="col-12">
                            <div class="breadcrumb_content">
                                <ul>
                                    <li><a href="DispatchServlet">home</a></li>
                                    <li><i class="fa fa-angle-right"></i></li>
                                    <li>Forgot Password</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <!--breadcrumbs area end-->
                <!-- customer login start -->
                <div class="customer_login">
                    <div class="row">
                        <!--login area start-->
                        <div class="col-lg-6 col-md-6">
                            <div class="account_form">
                                <h2>Reset your password</h2>
                                <form action="ForgotPasswordServlet" method="post">
                                   
                                        <p>
                                            <label>Enter the email address to receive the reset code:</label><br/>
                                            <input type="email" name="txtEmail" value="${sessionScope.email}" required/>
                                        </p>
                                    
                                    <c:if test="${requestScope.check == 'true'}">
                                        <p style="color: green">${requestScope.message}</p>
                                    </c:if>
                                    <c:if test="${requestScope.check == 'false'}">
                                        <p style="color: red">${requestScope.message}</p>
                                    </c:if>
                                    <c:if test="${requestScope.STATUS == 'confirm'}">
                                        <p>
                                            <label>Enter 6-digit code:</label><br/>
                                            <input type="number" name="txtCode" value="${requestScope.code}" required/>
                                        </p>
                                    </c:if>
                                    <c:if test="${requestScope.STATUS == 'enterpass'}">
                                        <p>
                                            <label>New Password:</label><br/>
                                            <input id="password" type="password" name="txtPassword" minlength="6" required/>
                                            <i id="iconsee" style="cursor: pointer; position: absolute; top: 40px; right: 10px" onclick="changeIcon(this)" class="fa-solid fa-eye-slash"></i>
                                        </p>
                                        <p>
                                            <label>Confirm Password:</label><br/>
                                            <input id="confirmPassword" type="password" name="txtConfirm" minlength="6" required/>
                                        </p>
                                    </c:if>
                                    <c:if test="${requestScope.STATUS != 'success'}">
                                        <div class="login_submit">
                                            <button name="status" value="forgot" type="submit">Submit</button>
                                        </div>
                                    </c:if>
                                    <c:if test="${requestScope.STATUS == 'success'}">
                                        <div class="user-actions mb-20">
                                            <h3>
                                                <a class="Returning" href="login.jsp">Click here to login</a>
                                            </h3>
                                        </div>
                                    </c:if>
                                </form>
                            </div>
                        </div>
                        <!--login area end-->
                    </div>
                </div>
                <!-- customer login end -->
            </div>
            <!--pos page inner end-->
        </div>
    </div>
    <!--pos page end-->
    <!--footer area start-->
    <%@include file="../../common/web/footer.jsp"%>
    <!--footer area end-->
    <!-- all js here -->
    <script src="view/assets/home/js/vendor/jquery-1.12.0.min.js"></script>
    <script src="view/assets/home/js/popper.js"></script>
    <script src="view/assets/home/js/bootstrap.min.js"></script>
    <script src="view/assets/home/js/plugins.js"></script>
    <script src="view/assets/home/js/main.js"></script>
    <script>
        function changeIcon(obj) {
            var input = obj.previousElementSibling;
            if (obj.classList.contains('fa-eye-slash')) {
                obj.classList.remove('fa-eye-slash');
                obj.classList.add('fa-eye');
                input.type = 'text';
            } else {
                obj.classList.remove('fa-eye');
                obj.classList.add('fa-eye-slash');
                input.type = 'password';
            }
        }
    </script>
</body>
</html>
