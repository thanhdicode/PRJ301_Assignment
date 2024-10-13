<%@ taglib prefix="ct" uri="/WEB-INF/tlds/cart-tag-library" %>
<!DOCTYPE html>
<html class="no-js" lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>My Account</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="view/assets/home/img/favicon.png">

        <!-- all css here -->
        <%@include file="view/common/web/add_css.jsp"%>
        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap" rel="stylesheet">

        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/magnific-popup.css" type="text/css">
        <link rel="stylesheet" href="css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <style type="text/css">
            body {
                font-family: 'Nunito Sans', sans-serif;
                background-color: #f4f7f6;
            }

            .account_dashboard {
                padding: 40px;
                background-color: #ffffff;
                border-radius: 15px;
                box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
                transition: all 0.3s ease;
            }

            .account_dashboard:hover {
                box-shadow: 0 0 30px rgba(0, 0, 0, 0.15);
            }

            .dashboard_tab_button {
                border: none;
                border-radius: 10px;
                padding: 20px;
                background-color: #f8f9fa;
            }

            .dashboard_list li a {
                color: #333;
                font-size: 16px;
                padding: 12px 15px;
                border-bottom: 1px solid #eee;
                display: block;
                transition: all 0.3s ease;
                border-radius: 5px;
            }

            .dashboard_list li a:hover,
            .dashboard_list li a.active {
                background-color: #00BBA6;
                color: #fff;
                transform: translateX(5px);
            }

            .dashboard_content {
                padding: 30px;
                border: 1px solid #e0e0e0;
                border-radius: 10px;
                margin-top: 20px;
                background-color: #fff;
            }

            .account_login_form {
                padding: 30px;
                background-color: #fff;
                border-radius: 10px;
                box-shadow: 0 0 15px rgba(0, 0, 0, 0.05);
            }

            .account_login_form label {
                font-weight: 600;
                margin-bottom: 8px;
                color: #333;
            }

            .input_type {
                width: 100%;
                padding: 12px;
                border: 2px solid #e0e0e0;
                border-radius: 6px;
                margin-bottom: 20px;
                transition: all 0.3s ease;
            }

            .input_type:focus {
                border-color: #00BBA6;
                box-shadow: 0 0 0 2px rgba(0, 187, 166, 0.2);
            }

            .input_type.default_input {
                border-color: #00BBA6;
            }

            .input_type.input_read {
                background-color: #f8f9fa;
            }

            .save_button {
                text-align: center;
                margin-top: 30px;
            }

            .primary_btn, .default_button {
                padding: 12px 25px;
                border: none;
                border-radius: 6px;
                cursor: pointer;
                font-weight: 600;
                transition: all 0.3s ease;
            }

            .primary_btn {
                background-color: #00BBA6;
                color: #fff;
            }

            .primary_btn:hover {
                background-color: #009688;
                transform: translateY(-2px);
                box-shadow: 0 4px 10px rgba(0, 187, 166, 0.3);
            }

            .default_button {
                background-color: #f0f0f0;
                color: #333;
            }

            .default_button:hover {
                background-color: #e0e0e0;
                transform: translateY(-2px);
            }

            /* Table styles */
            .coron_table {
                margin-top: 20px;
            }

            .coron_table table {
                width: 100%;
                border-collapse: separate;
                border-spacing: 0 10px;
            }

            .coron_table th, .coron_table td {
                padding: 15px;
                text-align: left;
                border: none;
            }

            .coron_table thead tr {
                background-color: #f8f9fa;
                border-radius: 8px;
            }

            .coron_table tbody tr {
                background-color: #fff;
                box-shadow: 0 2px 10px rgba(0, 0, 0, 0.05);
                transition: all 0.3s ease;
            }

            .coron_table tbody tr:hover {
                transform: translateY(-3px);
                box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
            }

            .coron_table .success {
                color: #28a745;
                font-weight: 600;
            }

            .coron_table .view {
                color: #007bff;
                text-decoration: none;
                font-weight: 600;
                transition: color 0.3s ease;
            }

            .coron_table .view:hover {
                color: #0056b3;
            }

            /* Profile image styles */
            .profile-image {
                border: 5px solid #00BBA6;
                border-radius: 50%;
                overflow: hidden;
                margin-bottom: 20px;
                transition: all 0.3s ease;
            }

            .profile-image:hover {
                transform: scale(1.05);
                box-shadow: 0 0 20px rgba(0, 187, 166, 0.4);
            }

            /* Responsive adjustments */
            @media (max-width: 768px) {
                .account_dashboard {
                    padding: 20px;
                }

                .dashboard_tab_button, .dashboard_content {
                    padding: 15px;
                }
            }
        </style>
    </head>
    <body>
        
        <!--pos page start-->
        <div class="pos_page">
            <div class="container">  
                <!--pos page inner-->
                <div class="pos_page_inner">  
                    <!--header area -->
                    <%@include file="common/header.jsp" %>
                    <!--header end -->

                    <!--breadcrumbs area start-->
                    <div class="breadcrumbs_area">
                        <div class="row">
                            <div class="col-12">
                                <div class="breadcrumb_content">
                                    <ul>
                                        <li><a href="DispatchServlet">home</a></li>
                                        <li><i class="fa fa-angle-right"></i></li>
                                        <li>my account</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--breadcrumbs area end-->
                    <!-- Start Maincontent -->
                    <section class="main_content_area">
                        <div class="container">
                            <div class="account_dashboard">
                                <div class="row">
                                    <div class="col-sm-12 col-md-3 col-lg-3">
                                        <!-- Nav tabs -->
                                        <div class="dashboard_tab_button">
                                            <div class="profile-image">
                                                <img src="${sessionScope.account.avatar}" width="100%" alt="Profile Image">
                                            </div>
                                            <ul role="tablist" class="nav flex-column dashboard-list">
                                                <li><a href="#account-details" data-toggle="tab" class="nav-link active">Account details</a></li>
                                                    <c:if test="${sessionScope.acc != null && sessionScope.acc.roleID == 2}">
                                                    <li><a href="#orders" data-toggle="tab" class="nav-link">Orders</a></li>
                                                    </c:if>
                                            </ul>
                                        </div>    
                                    </div>
                                    <div class="col-sm-12 col-md-9 col-lg-9">
                                        <!-- Tab panes -->
                                        <div class="tab-content dashboard_content">
                                            <div class="tab-pane fade" id="orders">
                                                <h3>Orders</h3>
                                                <div class="coron_table table-responsive">
                                                    <table class="table">
                                                        <thead>
                                                            <tr>
                                                                <th>Order ID</th>
                                                                <th>Date</th>
                                                                <th>Status</th>
                                                                <th>Total</th>
                                                                <th>Actions</th>     
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:forEach items="${requestScope.LISTORDERS}" var="o">
                                                                <tr>
                                                                    <td>${o.orderID}</td>
                                                                    <td>${o.orderDate}</td>
                                                                    <td><span class="success">${o.status == true ? "Delivered" : "Pending"}</span></td>
                                                                    <td>${o.totalPrice}</td>
                                                                    <td><a href="cart.html" class="view">view</a></td>
                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                            <div class="tab-pane fade show active" id="account-details">
                                                <h3>Account details</h3>
                                                <c:if test="${requestScope.STATUS !=null }">
                                                    <div class="alert alert-success">${requestScope.STATUS}</div>
                                                </c:if>
                                                <div class="login">
                                                    <div class="login_form_container">
                                                        <div class="account_login_form">
                                                            <form id="form-1" action="EditProfileServlet" method="get">
                                                                <label>Username</label>
                                                                <input class="input_type" type="text" name="username" value="${sessionScope.acc.userName}" readonly>
                                                                <label>Role</label>
                                                                <input class="input_type" type="text" name="role" value="${sessionScope.acc.roleID == 1 ? "Admin" : "Customer"}" readonly>
                                                                <label>First Name</label>
                                                                <input class="input_type" type="text" name="first-name" value="${sessionScope.acc.firstName}" readonly>
                                                                <label>Last Name</label>
                                                                <input class="input_type" type="text" name="last-name" value="${sessionScope.acc.lastName}" readonly>
                                                                <label>Email</label>
                                                                <input class="input_type" type="text" name="email" value="${sessionScope.acc.email}" readonly>
                                                                <input class="input_type" type="hidden" name="avatar" src="${sessionScope.acc.avatar}" value="${sessionScope.acc.avatar}" readonly/>
                                                                <label>Address</label>
                                                                <input class="input_type" type="text" name="address" value="${sessionScope.acc.address}" readonly>
                                                                <label>Phone</label>
                                                                <input class="input_type input_read" type="text" value="${sessionScope.acc.phone}" name="phone" readonly>
                                                                <div class="save_button">
                                                                    <button id="edit" type="button" class="default_button" onclick="changeType(this)">Edit</button>
                                                                    <button id="save" type="submit" class="primary_btn" style="display: none;">Save</button>
                                                                </div>
                                                            </form>
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
                    <!-- End Maincontent --> 

                    <!-- Footer remains the same -->
                    <!--footer area start-->
                    <%@include file="common/footer.jsp"%>
                    <!-- all js here -->
                    <%@include file="view/common/web/add_js.jsp"%>
                    <!-- All js remains the same -->
                    <script type="text/javascript">
                        function changeType(button) {
                            var inputElements = document.querySelectorAll(".input_type");
                            var saveButton = document.getElementById("save");
                            var editButton = document.getElementById("edit");
                            if (button.id === "edit") {
                                editButton.style.display = "none";
                                saveButton.style.display = "inline-block";
                                inputElements.forEach(x => {
                                    if (x.name !== "username" && x.name !== "role" && x.name !== "email" && x.name !== "avatar") {
                                        x.readOnly = false;
                                        x.classList.add("default_input");
                                    }
                                });
                            } else {
                                if (validateForm()) {
                                    document.getElementById("form-1").submit();
                                } else {
                                    editButton.style.display = "inline-block";
                                    saveButton.style.display = "none";
                                }
                                inputElements.forEach(x => {
                                    x.readOnly = true;
                                    x.classList.remove("default_input");
                                });
                            }
                        }

                        function validateForm() {
                            var firstName = document.forms["form-1"]["first-name"].value;
                            var lastName = document.forms["form-1"]["last-name"].value;
                            var phone = document.forms["form-1"]["phone"].value;

                            // Validate first name
                            if (firstName === "") {
                                showError("First name is required.");
                                return false;
                            }
                            if (!/^[a-zA-Z]+$/.test(firstName)) {
                                showError("First name must be all characters.");
                                return false;
                            }

                            // Validate last name
                            if (lastName === "") {
                                showError("Last name is required.");
                                return false;
                            }
                            if (!/^[a-zA-Z]+$/.test(lastName)) {
                                showError("Last name must be all characters.");
                                return false;
                            }

                            // Validate phone number
                            if (phone === "") {
                                showError("Phone number is required.");
                                return false;
                            }
                            if (!/^\d{10}$/.test(phone)) {
                                showError("Please enter a valid 10-digit phone number.");
                                return false;
                            }

                            return true;
                        }

                        function showError(message) {
                            var errorDiv = document.createElement('div');
                            errorDiv.className = 'alert alert-danger';
                            errorDiv.textContent = message;
                            document.querySelector('.account_login_form').insertBefore(errorDiv, document.querySelector('.save_button'));
                            setTimeout(() => errorDiv.remove(), 3000);
                        }
                        // Add smooth scrolling
                        document.querySelectorAll('a[href^="#"]').forEach(anchor => {
                            anchor.addEventListener('click', function (e) {
                                e.preventDefault();

                                document.querySelector(this.getAttribute('href')).scrollIntoView({
                                    behavior: 'smooth'
                                });
                            });
                        });

                        // Add animation to form inputs
                        document.querySelectorAll('.input_type').forEach(input => {
                            input.addEventListener('focus', function () {
                                this.parentElement.classList.add('input-focused');
                            });
                            input.addEventListener('blur', function () {
                                if (this.value === '') {
                                    this.parentElement.classList.remove('input-focused');
                                }
                            });
                        });

                        // Add confirmation before form submission
                        document.getElementById('form-1').addEventListener('submit', function (e) {
                            if (!confirm('Are you sure you want to save these changes?')) {
                                e.preventDefault();
                            }
                        });

                        // Add tooltip to readonly fields
                        document.querySelectorAll('input[readonly]').forEach(input => {
                            input.title = 'This field cannot be edited';
                        });

                        // Add animation to success message
                        if (document.querySelector('.alert-success')) {
                            setTimeout(() => {
                                document.querySelector('.alert-success').classList.add('fade-out');
                            }, 3000);
                        }
                    </script>
                    </body>
                    </html>
