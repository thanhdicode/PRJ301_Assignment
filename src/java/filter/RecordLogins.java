package filter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.User;

public class RecordLogins implements Filter {

    private FilterConfig filterConfig = null;
    private static final Map<String, UserLoginInfo> loginRecords = new ConcurrentHashMap<>();
    private static final int LOGIN_THRESHOLD = 10; // Number of logins to trigger alert
    private static final int TIME_WINDOW_MINUTES = 60; // Time window for login count (in minutes)

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Check if this is a login request
        if (isLoginRequest(httpRequest)) {
            String username = httpRequest.getParameter("username");
            String ipAddress = httpRequest.getRemoteAddr();
            
            // Record the login attempt
            recordLogin(username, ipAddress);
            
            // Check for login surge
            checkLoginSurge(username);
        }

        // Continue the filter chain
        chain.doFilter(request, response);

        // Check if login was successful
        if (isLoginRequest(httpRequest) && isLoginSuccessful(httpRequest)) {
            User user = getUserFromSession(httpRequest);
            if (user != null) {
                log("Successful login for user: " + user.getUserName());
            }
        }
    }

    private boolean isLoginRequest(HttpServletRequest request) {
        return request.getRequestURI().endsWith("/LoginServlet");
    }

    private boolean isLoginSuccessful(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return session != null && session.getAttribute("acc") != null;
    }

    private User getUserFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            return (User) session.getAttribute("acc");
        }
        return null;
    }

    private void recordLogin(String username, String ipAddress) {
        UserLoginInfo loginInfo = loginRecords.computeIfAbsent(username, k -> new UserLoginInfo());
        loginInfo.addLogin(ipAddress);
    }

    private void checkLoginSurge(String username) {
        UserLoginInfo loginInfo = loginRecords.get(username);
        if (loginInfo != null && loginInfo.getRecentLoginCount() > LOGIN_THRESHOLD) {
            sendAlert(username, loginInfo);
        }
    }

    private void sendAlert(String username, UserLoginInfo loginInfo) {
        // Log a message
        
        String alertMessage = "ALERT: Login surge detected for user " + username + 
            ". Recent login count: " + loginInfo.getRecentLoginCount() + 
            ". Last IP: " + loginInfo.getLastIpAddress();
        log(alertMessage);

        // Write alert to a text file
        try (FileWriter fw = new FileWriter("/alert/dangnhap/alerts.txt", true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(LocalDateTime.now() + ": " + alertMessage);
        } catch (IOException e) {
            log("Failed to write alert to file: " + e.getMessage());
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    @Override
    public void destroy() {
    }

    private void log(String message) {
        if (filterConfig != null) {
            filterConfig.getServletContext().log(message);
        }
    }

    private static class UserLoginInfo {
        private int loginCount = 0;
        private LocalDateTime lastLoginTime;
        private String lastIpAddress;

        public void addLogin(String ipAddress) {
            loginCount++;
            lastLoginTime = LocalDateTime.now();
            lastIpAddress = ipAddress;
        }

        public int getRecentLoginCount() {
            LocalDateTime cutoffTime = LocalDateTime.now().minusMinutes(TIME_WINDOW_MINUTES);
            if (lastLoginTime.isAfter(cutoffTime)) {
                return loginCount;
            }
            loginCount = 1;
            return 1;
        }

        public String getLastIpAddress() {
            return lastIpAddress;
        }
    }
}
