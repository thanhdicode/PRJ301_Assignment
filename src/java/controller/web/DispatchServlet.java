
package controller.web;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DispatchServlet extends HttpServlet {
    // Constants for page paths
    private static final String WELCOME_PAGE = "index"; 
    private static final String SHOP_PAGE = "home"; 
    private static final String BLOG_PAGE = "blog.jsp";
    private static final String LOGIN_PAGE = "login.jsp";
    private static final String BLOG_PAGE_DETAIL = "blog-details.jsp";
    private static final String CONTACT_PAGE = "contact.jsp";
    private static final String ABOUT_US_PAGE ="about.jsp";
    private static final String REGISTER_PAGE ="register.jsp";
    private static final String FORGOTPASS_PAGE = "view/jsp/home/forgot_password.jsp";
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set the content type of the response
        response.setContentType("text/html;charset=UTF-8");

        // Get the action parameter from the request
        String action = request.getParameter("btnAction");
        // Default URL is the welcome page
        String url = WELCOME_PAGE;

        if (action == null) {
            // If no action is specified, forward to the welcome page
            request.getRequestDispatcher(WELCOME_PAGE).forward(request, response);
        } else {
            // Determine the appropriate page based on the action
            switch (action) {
                case "forgotpass":
                    url = FORGOTPASS_PAGE;
                    break;
                case "register":
                    url=REGISTER_PAGE;
                    break;
                case "Login":
                    url = LOGIN_PAGE;
                    break;
                case "Blog":
                    url = BLOG_PAGE;
                    break;
                case "Shop":
                    url = SHOP_PAGE;
                    break;
                case "BlogDetail":
                    url = BLOG_PAGE_DETAIL;
                    break;
                case "Contact":
                    url = CONTACT_PAGE;
                    break;
                    case "aboutus" :
                    url=ABOUT_US_PAGE;
                    break;
                    
                default:
                    // If action is unrecognized, throw an error
                    throw new AssertionError("Unknown action: " + action);
            }
            // Forward the request to the determined URL
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle GET requests
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle POST requests
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        // Return a short description of the servlet
        return "DispatchServlet handles dispatching of requests to different pages based on user actions.";
    }
}
