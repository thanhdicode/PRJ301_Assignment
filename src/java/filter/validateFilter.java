package filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
// filter cho thang login 

public class validateFilter implements Filter {

    private static final boolean debug = true;

    private FilterConfig filterConfig = null;

    public validateFilter() {
    }

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("validateFilter:DoBeforeProcessing");
        }

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Check for null or empty values
        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        // Check for excessively long input (potential buffer overflow attack)
        if (username.length() > 50 || password.length() > 50) {
            request.getRequestDispatcher("ErrorServlet").forward(request, response);
            return;
        }

        // Check for SQL injection attempts
        if (containsSqlInjection(username) || containsSqlInjection(password)) {
            request.getRequestDispatcher("ErrorServlet").forward(request, response);
            return;
        }

        // Check for XSS attempts
        if (containsXss(username) || containsXss(password)) {
            request.getRequestDispatcher("ErrorServlet").forward(request, response);
            return;
        }
    }

    private boolean containsSqlInjection(String input) {
        String[] sqlKeywords = {"SELECT", "INSERT", "UPDATE", "DELETE", "DROP", "UNION", "--", ";"};
        for (String keyword : sqlKeywords) {
            if (input.toUpperCase().contains(keyword)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsXss(String input) {
        return input.contains("<script>") || input.contains("</script>") || input.contains("<") || input.contains(">");
    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("validateFilter:DoAfterProcessing");
        }

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        if (debug) {
            log("validateFilter:doFilter()");
        }

        doBeforeProcessing(request, response);

        Throwable problem = null;
        try {
            chain.doFilter(request, response);
        } catch (ServletException | IOException t) {

            problem = t;
        }

        doAfterProcessing(request, response);

        if (problem != null) {
            if (problem instanceof ServletException servletException) {
                throw servletException;
            }
            if (problem instanceof IOException iOException) {
                throw iOException;
            }
            sendProcessingError(problem, response);
        }
    }

    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public void destroy() {
    }

    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("validateFilter:Initializing filter");
            }
        }
    }

    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("validateFilter()");
        }
        StringBuffer sb = new StringBuffer("validateFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);

        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                pw.print(stackTrace);
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (IOException ex) {
            }
        } else {
            try {
                try (PrintStream ps = new PrintStream(response.getOutputStream())) {
                    t.printStackTrace(ps);
                }
                response.getOutputStream().close();
            } catch (IOException ex) {
            }
        }
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}
