package filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

public class RegisterFilter implements Filter {

    private FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String method = req.getMethod();

        if (method.equalsIgnoreCase("POST")) {
            handlePostRequest(req, res, chain);
        } else if (method.equalsIgnoreCase("GET")) {
            handleGetRequest(req, res, chain);
        } else {
            // co tinh gui du lieu thong qua nhung method HTTP khac
            res.sendRedirect(req.getContextPath() + "/ErrorServlet");
        }
    }

    private void handlePostRequest(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        // kiem tra du lieu gui vao hop le khongg 
        if (isInvalidInput(firstName) || isInvalidInput(lastName) || isInvalidInput(username) ||
            isInvalidInput(password) || isInvalidEmail(email) || isInvalidInput(address) ||
            isInvalidPhone(phone)) {
            res.sendRedirect(req.getContextPath() + "/ErrorServlet");
            return;
        }

        chain.doFilter(req, res);
    }

    private void handleGetRequest(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        // Check if the user is already logged in or has appropriate permissions
        // This is just a placeholder - implement your actual authentication check
        if (!isUserAuthenticated(req)) {
            res.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        // If authenticated, allow the request to proceed
        chain.doFilter(req, res);
    }

    private boolean isUserAuthenticated(HttpServletRequest req) {
        // Implement your authentication check here
        // For example, check if there's a valid session or if the user has the right role
        // This is just a placeholder implementation
        return req.getSession().getAttribute("acc") != null;
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
// SQL injection
    private boolean isInvalidInput(String input) {
        if (input == null || input.trim().isEmpty() || input.length() > 100) {
            return true;
        }

        String[] dangerousPatterns = {"<script>", "</script>", "SELECT", "INSERT", "UPDATE", "DELETE", "DROP", "--"};
        for (String pattern : dangerousPatterns) {
            if (input.toLowerCase().contains(pattern.toLowerCase())) {
                return true;
            }
        }

        return false;
    }

    private boolean isInvalidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email == null || !Pattern.compile(emailRegex).matcher(email).matches();
    }

    private boolean isInvalidPhone(String phone) {
        String phoneRegex = "^\\d{10}$";
        return phone == null || !Pattern.compile(phoneRegex).matcher(phone).matches();
    }
}