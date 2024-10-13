<%-- 
    Document   : shop
    Created on : Jun 20, 2024, 10:26:14 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Meta tags and title -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="author" content="CodePel">
        <title>Login</title>

        <!-- External stylesheets -->
        <link rel="stylesheet" href="css/login.css">
        <link rel="stylesheet" href="css/style-login.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

        <!-- Font Awesome for icons -->
        <script src="https://use.fontawesome.com/f59bcd8580.js"></script>

        <!-- Google reCAPTCHA -->
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>

        <!-- Custom styles -->
        <style>
            .login-container {
                display: flex;
                justify-content: center;
                align-items: center;
                min-height: 100vh;
                background-color: #f8f9fa;
            }
            .login-card {
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                border-radius: 10px;
                overflow: hidden;
            }
            .login-card img {
                object-fit: cover;
                height: 100%;
            }
            .login-form {
                padding: 40px;
            }
            .form-control {
                border-radius: 5px;
            }
            .btn-google {
                background-color: #4285F4;
                color: white;
                width: 100%;
                padding: 10px;
                border: none;
                border-radius: 5px;
                text-align: center;
                font-weight: bold;
            }
            .btn-google:hover {
                background-color: #357ae8;
            }
            .footer-text {
                text-align: center;
                margin-top: 20px;
                color: #6c757d;
            }
            .btn-dark:hover {
                background-color: #343a40;
                transform: translateY(-2px);
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
                transition: all 0.3s ease;
            }

            .btn-google:hover {
                background-color: #357ae8;
                transform: translateY(-2px);
                box-shadow: 0 4px 8px rgba(66, 133, 244, 0.3);
                transition: all 0.3s ease;
            }

            a:hover {
                color: #007bff;
                text-decoration: none;
                transition: color 0.3s ease;
            }
            .form-control {
                border-radius: 5px;
                border: 1px solid #ced4da;
                transition: border-color 0.3s ease, box-shadow 0.3s ease;
            }

            .form-control:focus {
                border-color: #80bdff;
                box-shadow: 0 0 0 0.2rem rgba(0, 123, 255, 0.25);
            }
            .login-container {
                background-image: linear-gradient(45deg, #f3f3f3 25%, transparent 25%),
                    linear-gradient(-45deg, #f3f3f3 25%, transparent 25%),
                    linear-gradient(45deg, transparent 75%, #f3f3f3 75%),
                    linear-gradient(-45deg, transparent 75%, #f3f3f3 75%);
                background-size: 20px 20px;
                background-position: 0 0, 0 10px, 10px -10px, -10px 0px;
            }
            @keyframes fadeIn {
                from {
                    opacity: 0;
                    transform: translateY(-20px);
                }
                to {
                    opacity: 1;
                    transform: translateY(0);
                }
            }

            .login-card {
                animation: fadeIn 0.5s ease-out;
            }
            .sideline {
                display: flex;
                width: 100%;
                justify-content: center;
                align-items: center;
                text-align: center;
                color: #6c757d;
            }

            .sideline::before,
            .sideline::after {
                content: '';
                border-top: 1px solid #ced4da;
                margin: 0 20px 0 0;
                flex: 1 0 20px;
            }

            .sideline::after {
                margin: 0 0 0 20px;
            }
            .login-card img {
                object-fit: cover;
                height: 100%;
                box-shadow: inset 0 0 15px rgba(0, 0, 0, 0.1);
            }
            .footer-text {
                text-align: center;
                margin-top: 20px;
                color: #6c757d;
                font-style: italic;
                padding: 10px;
                background-color: #f8f9fa;
                border-top: 1px solid #dee2e6;
            }

        </style>
    </head>
    <body>

        <div class="login-container">
            <div class="login-card row no-gutters">

                <div class="col-md-6 d-none d-md-block">
                    <img src="img/login-register/login-img.jpg" class="img-fluid" />
                </div>

                <div class="col-md-6 bg-white login-form">
                    <h3 class="pb-3">Login to Your Account</h3>
                    <p>${requestScope.SUCCESS}</p>
                    <div class="form-style">
                        <!-- Login form -->
                        <form action="login" id="login-form" onsubmit="return validateForm()" method="post">
                            <p>${mess}</p>
                            <p>${passmess}</p>
                            <div class="form-group pb-3">
                                <input type="text" id="username" name="username" class="form-control" placeholder="Username" />
                            </div>
                            <div class="form-group pb-3">
                                <input type="password" id="password" name="password" class="form-control" placeholder="Password" />
                            </div>
                            <div class="g-recaptcha" data-sitekey="6LeKLH8pAAAAAFbXR7vi-Ms_Vp1V30SuomC7J5pv"></div>
                            <div style="color: red" id="error"></div>
                            <div class="form-check pb-3">
                                <input id="remember" name="remember" type="checkbox" class="form-check-input">
                                <label for="remember" class="form-check-label">Remember me</label>
                            </div>
                            <div class="pb-2">
                                <button type="submit" class="btn btn-dark w-100 font-weight-bold" id="submit-btn">
                                    <span class="spinner-border spinner-border-sm d-none" role="status" aria-hidden="true"></span>
                                    Submit
                                </button>
                            </div>
                        </form>
                        <!-- Alternative login button -->
                        <div class="sideline">OR</div>
                        <div>
                            <a class="btn-google" href="https://accounts.google.com/o/oauth2/auth?scope=email profile openid&redirect_uri=http://localhost:9898/prj_workshop_new/loginemail&response_type=code&client_id=224841862887-g96ibrin5q4cpae5onbd6jutj3v91hdr.apps.googleusercontent.com&approval_prompt=force">
                                <i class="fa fa-google" aria-hidden="true"></i> Login with Google
                            </a>
                        </div>
                        <div class="pt-3">
                            <a href="DispatchServlet?btnAction=forgotpass">Forgot password?</a>
                        </div>
                        <div class="pt-4 text-center">
                            Get Members Benefit. <a href="DispatchServlet?btnAction=register">Sign Up</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Footer -->
        <footer class="footer-text">The virus. Best clothes - best services</footer>

        <!-- JavaScript for form validation -->
        <script>
            var form = document.getElementById("login-form");
            var error = document.getElementById("error");
            form.addEventListener("submit", function (event) {
                event.preventDefault();
                const response = grecaptcha.getResponse();
                if (response) {
                    form.submit();
                } else {
                    error.textContent = "Vui lòng xác minh rằng bạn không phải robot.";
                }
            });
            document.getElementById('login-form').addEventListener('submit', function () {
                var btn = document.getElementById('submit-btn');
                var spinner = btn.querySelector('.spinner-border');
                btn.disabled = true;
                spinner.classList.remove('d-none');
                btn.textContent = 'Logging in...';
            });
            // Function to validate form inputs
            function validateForm() {
                var username = document.getElementById('username').value;
                var password = document.getElementById('password').value;
                // Check if username or password is empty
                if (username.trim() === '' || password.trim() === '') {
                    alert('Username and Password are required.');
                    return false; // Prevent form submission
                }
                return true; // Proceed with form submission
            }
        </script>
    </body>
</html>
