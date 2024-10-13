package filter;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(filterName = "ErrorFilter", urlPatterns = {"/*"})
public class ErrorFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        try {
            chain.doFilter(request, response);
        } catch (Exception e) {
            // Log the exception if needed
            e.printStackTrace();
            
            // Set the error status code
            int statusCode = httpResponse.getStatus();
            if (statusCode < 400) {
                statusCode = HttpServletResponse.SC_INTERNAL_SERVER_ERROR; // 500
            }
            
            // Set the error code as an attribute to be used in the JSP
            httpRequest.setAttribute("errorCode", statusCode);
            
            // Forward to the ErrorServlet
            httpRequest.getRequestDispatcher("ErrorServlet").forward(httpRequest, httpResponse);
        }
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed
    }
}