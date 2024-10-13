<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Registration Form</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- External stylesheets -->
    <link rel="stylesheet" href="fonts/register/material-design-iconic-font/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="css/register.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    
    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- Google reCAPTCHA -->
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>

    <!-- Custom styles -->
    <style>
        body {
            font-family: 'Nunito', sans-serif;
            background-color: #f4f7f6;
            margin: 0;
            padding: 0;
        }
        .wrapper {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            background-image: url('img/login-register/background.jpg');
            background-size: cover;
            background-attachment: fixed;
            transition: all 0.3s ease;
        }
        .inner {
            display: flex;
            max-width: 1000px;
            width: 90%;
            background: rgba(255, 255, 255, 0.9);
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
            border-radius: 20px;
            overflow: hidden;
            transition: all 0.3s ease;
        }
        .inner:hover {
            transform: translateY(-5px);
            box-shadow: 0 15px 40px rgba(0, 0, 0, 0.2);
        }
        .image-holder {
            flex: 1;
            background: url('img/login-register/registration-form-1.png') no-repeat center center;
            background-size: cover;
            position: relative;
            overflow: hidden;
        }
        .image-holder::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background: linear-gradient(45deg, rgba(66, 133, 244, 0.7), rgba(219, 68, 55, 0.7));
            opacity: 0;
            transition: opacity 0.3s ease;
        }
        .inner:hover .image-holder::before {
            opacity: 1;
        }
        form {
            flex: 1;
            padding: 50px;
            box-sizing: border-box;
        }
        h3 {
            color: #333;
            font-weight: 700;
            margin-bottom: 30px;
            text-align: center;
        }
        .form-control {
            border-radius: 10px;
            margin-bottom: 20px;
            padding: 15px;
            border: 2px solid #e0e0e0;
            transition: all 0.3s ease;
        }
        .form-control:focus {
            border-color: #4285F4;
            box-shadow: 0 0 0 3px rgba(66, 133, 244, 0.3);
        }
        .form-wrapper {
            position: relative;
            margin-bottom: 20px;
        }
        .form-wrapper i {
            position: absolute;
            top: 50%;
            right: 15px;
            transform: translateY(-50%);
            color: #999;
            transition: all 0.3s ease;
        }
        .form-wrapper:focus-within i {
            color: #4285F4;
        }
        .btn {
            background-color: #4285F4;
            color: white;
            border: none;
            border-radius: 10px;
            padding: 15px;
            font-size: 18px;
            font-weight: bold;
            width: 100%;
            cursor: pointer;
            transition: all 0.3s ease;
        }
        .btn:hover {
            background-color: #357ae8;
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(66, 133, 244, 0.4);
        }
        .text-danger {
            color: #db4437;
            font-size: 0.9em;
            margin-top: 5px;
        }
        .text-success {
            color: #0f9d58;
            font-size: 0.9em;
            margin-top: 5px;
        }
        .g-recaptcha {
            margin-bottom: 20px;
        }
        @keyframes shake {
            0%, 100% { transform: translateX(0); }
            10%, 30%, 50%, 70%, 90% { transform: translateX(-5px); }
            20%, 40%, 60%, 80% { transform: translateX(5px); }
        }
        .shake {
            animation: shake 0.82s cubic-bezier(.36,.07,.19,.97) both;
        }
    </style>
</head>

<body>
    <div class="wrapper">
        <div class="inner">
            <div class="image-holder"></div>
            <form id="register-form" action="register" method="post" onsubmit="return validateForm()">
                <h3>Registration Form</h3>
                <h3 class="btn-danger">${requestScope.errorLoginGGmess}</h3>
                <h6 class="text-danger">${requestScope.ERROR}</h6>
                <h6 class="text-success">${requestScope.SUCCESS}</h6>
                <div class="form-group">
                    <input type="text" ${requestScope.firstNameGoogleAccount != null ? readonly : ""} value="${requestScope.firstNameGoogleAccount != null ? requestScope.firstNameGoogleAccount : ""}" placeholder="First Name" class="form-control" id="firstName" name="firstName">
                    <input type="text" ${requestScope.firstNameGoogleAccount != null ? readonly : ""} value="${requestScope.lastNameGoogleAccount != null ? requestScope.lastNameGoogleAccount : ""}" placeholder="Last Name" class="form-control" id="lastName" name="lastName">
                </div>
                <div class="form-wrapper">
                    <input oninput="checkDuplicate(this)"  name="username" type="text" placeholder="Username" class="form-control" id="username">
                    <i class="zmdi zmdi-account"></i> 
                    <h5 class="text-danger" id="errorduplicate"></h5>
                </div>
                <div class="form-wrapper">
                    <input name="email" type="text" ${requestScope.emailGG != null ? "readonly" : ""}
                                                   style="${requestScope.emailGG != null ? "background-color: #e9ecef;" : ""}"
                                                   value="${requestScope.emailGG != null ? requestScope.emailGG : ""}" required placeholder="Email Address" class="form-control" id="email">
                    <i class="zmdi zmdi-email"></i> 
                </div>
                <div class="form-wrapper">
                    <input type="hidden" name="avatar" value="${requestScope.avatar}"/>
                </div>
                <div class="form-wrapper">
                    <input name="phone" type="tel" placeholder="Phone Number" class="form-control" id="phone">
                    <i class="zmdi zmdi-phone"></i>
                </div>
                <div class="form-wrapper">
                    <input name="address" type="text" placeholder="Address" class="form-control" id="address">
                    <i class="zmdi zmdi-pin"></i>
                </div>
                <div class="form-wrapper">
                    <input name="password" type="password" placeholder="Password" class="form-control" id="password">
                    <i class="zmdi zmdi-lock"></i>
                    <h5 class="text-danger" id="text2"></h5>
                </div>
                <div class="form-wrapper">
                    <input type="password" placeholder="Confirm Password" class="form-control" id="confirmPassword">
                    <i class="zmdi zmdi-lock"></i>
                </div>
                <div class="g-recaptcha" data-sitekey="6LeKLH8pAAAAAFbXR7vi-Ms_Vp1V30SuomC7J5pv"></div>
                <button name="btnAction" type="submit" class="btn">Register <i class="zmdi zmdi-arrow-right"></i></button>
            </form>
        </div>
    </div>

    <script>
        function validateForm() {
            var firstName = document.getElementById('firstName').value;
            var lastName = document.getElementById('lastName').value;
            var username = document.getElementById('username').value;
            var email = document.getElementById('email').value;
            var phone = document.getElementById('phone').value;
            var address = document.getElementById('address').value;
            var password = document.getElementById('password').value;
            var confirmPassword = document.getElementById('confirmPassword').value;

            var isValid = true;

            if (firstName.trim() === '' || lastName.trim() === '' || username.trim() === '' || email.trim() === '' || phone.trim() === '' || address.trim() === '' || password.trim() === '' || confirmPassword.trim() === '') {
                showError('All fields are required.');
                isValid = false;
            }

            if (password !== confirmPassword) {
                showError('Passwords do not match.');
                isValid = false;
            }

            if (password.length < 6) {
                showError('Password must be at least 6 characters long.');
                isValid = false;
            }

            if (!isValid) {
                document.querySelector('.inner').classList.add('shake');
                setTimeout(() => {
                    document.querySelector('.inner').classList.remove('shake');
                }, 820);
            }

            return isValid;
        }

        function showError(message) {
            var errorElement = document.createElement('div');
            errorElement.className = 'text-danger';
            errorElement.textContent = message;
            document.querySelector('form').insertBefore(errorElement, document.querySelector('.g-recaptcha'));
            setTimeout(() => {
                errorElement.remove();
            }, 5000);
        }

        function checkDuplicate(input) {
            var username = input.value;
            $.ajax({
                url: "/PRJ_WORKSHOP1/register",
                type: "post",
                data: {
                    username: username,
                    action: "CheckDuplicate"
                },
                success: function (data) {
                    var row = document.getElementById("errorduplicate");
                    row.innerHTML = data;
                },
                error: function (xhr) {
                    console.error(xhr);
                }
            });
        }

        // Add input animations
        document.querySelectorAll('.form-control').forEach(input => {
            input.addEventListener('focus', () => {
                input.parentElement.classList.add('focused');
            });
            input.addEventListener('blur', () => {
                if (input.value === '') {
                    input.parentElement.classList.remove('focused');
                }
            });
        });

        // Password strength indicator
        document.getElementById('password').addEventListener('input', function() {
            var strength = 0;
            if (this.value.length > 6) strength++;
            if (this.value.match(/[a-z]+/)) strength++;
            if (this.value.match(/[A-Z]+/)) strength++;
            if (this.value.match(/[0-9]+/)) strength++;
            if (this.value.match(/[$@#&!]+/)) strength++;

            var strengthBar = document.createElement('div');
            strengthBar.style.height = '5px';
            strengthBar.style.marginTop = '5px';
            strengthBar.style.transition = 'all 0.3s ease';
            
            switch (strength) {
                case 0:
                case 1:
                    strengthBar.style.width = '20%';
                    strengthBar.style.backgroundColor = '#db4437';
                    break;
                case 2:
                    strengthBar.style.width = '40%';
                    strengthBar.style.backgroundColor = '#f4b400';
                    break;
                case 3:
                    strengthBar.style.width = '60%';
                    strengthBar.style.backgroundColor = '#4285F4';
                    break;
                case 4:
                    strengthBar.style.width = '80%';
                    strengthBar.style.backgroundColor = '#0f9d58';
                    break;
                case 5:
                    strengthBar.style.width = '100%';
                    strengthBar.style.backgroundColor = '#0f9d58';
                    break;
            }

            var existingBar = this.parentElement.querySelector('.strength-bar');
            if (existingBar) {
                existingBar.remove();
            }
            this.parentElement.appendChild(strengthBar);
            strengthBar.classList.add('strength-bar');
        });
    </script>
</body>
</html>