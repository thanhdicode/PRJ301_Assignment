<%@page contentType="text/html" pageEncoding="UTF-8"%>   


<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
<header style="background: white;" class="app-header">
   <a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
                                    aria-label="Hide Sidebar"></a>
    
    <ul class="app-nav">
        
        <li><a style="background: black;" class="app-nav__item" href="DispatchServlet"><i class='bx bx-log-out bx-rotate-180'></i> </a>

        </li>
    </ul>
</header>





<div class="app-sidebar__overlay" data-toggle="sidebar"></div>
<aside style="background: black;" class="app-sidebar">
    <div class="app-sidebar__user"><img class="app-sidebar__user-avatar"  src="view/assets/admin/images/user.png"
                                        alt="User Image">
        <div>
            <p class="app-sidebar__user-name"><b></b></p>
            <p class="app-sidebar__user-designation">Welcome back</p>
        </div>
    </div>
    <hr>
    <ul class="app-menu">
        <li><a class="app-menu__item ${requestScope.CURRENTSERVLET == "Home" ? "active" : ""}" href="DispatchServlet"><i class='app-menu__icon bx bx-home'></i><span
                    class="app-menu__label">Shop</span></a></li>
        <li><a class="app-menu__item ${requestScope.CURRENTSERVLET == "Dashboard" ? "active" : ""}" href="AdminServlet"><i class='app-menu__icon bx bx-tachometer'></i><span
                    class="app-menu__label">Statistic</span></a></li>
        <li><a class="app-menu__item ${requestScope.CURRENTSERVLET == "Chart" ? "active" : ""}" href="ChartServlet"><i class='app-menu__icon fa fa-chart-bar'></i><span
                    class="app-menu__label">Charts</span></a></li>
        <li><a class="app-menu__item ${requestScope.CURRENTSERVLET == "User" ? "active" : ""}" href="ManageUserServlet"><i class='app-menu__icon bx bx-user-voice'></i><span
                    class="app-menu__label">Manage Customer</span></a></li>
        <li><a class="app-menu__item ${requestScope.CURRENTSERVLET == "Product" ? "active" : ""}" href="ManageProductServlet"><i class='app-menu__icon bx bx-purchase-tag-alt'></i><span 
                    class="app-menu__label">Manage product</span></a></li>
        <li><a class="app-menu__item ${requestScope.CURRENTSERVLET == "Category" ? "active" : ""}" href="ManageCategoryServlet"><i class='app-menu__icon fa fa-layer-group'></i><span
                    class="app-menu__label">Manage Category</span></a></li>
        <li><a class="app-menu__item ${requestScope.CURRENTSERVLET == "Order" ? "active" : ""}" href="ManageOrderServlet"><i class='app-menu__icon bx bx-task'></i><span
                    class="app-menu__label">Manage Order</span></a></li>

    </ul>
</aside>