package controller.web.login;

import DAO.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import model.User;

public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            String fName = request.getParameter("firstName");
            String lName = request.getParameter("lastName");
            String uName = request.getParameter("username");
            String uPass = request.getParameter("password");
            String email = request.getParameter("email");
            String avatar = request.getParameter("avatar");
            String action = request.getParameter("action");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");

            UserDAO ud = new UserDAO();

            if (action != null && action.equals("CheckDuplicate")) {
                try (PrintWriter out = response.getWriter()) {
                    boolean isDuplicate = ud.checkUserNameDuplicate(uName);
                    if (isDuplicate) {
                        out.println("<h6 style='color: red'>Username already exists!</h6>");
                    } else {
                        out.println("<h6 style='color: green'>Username is available.</h6>");
                    }
                    out.flush();
                }
                return;
            }

            boolean isDup = ud.checkUserNameDuplicate(uName);
            if (isDup) {
                request.setAttribute("ERROR", "Username already exists!");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } else {
                User user = new User(0, fName, lName, email, (avatar == null ? "img/users/user.jpg" : avatar), uName, uPass, address, phone, 2, true);
                ud.registerUser(user);
                request.setAttribute("SUCCESS", "Register successfully. Please Login!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            log("RegisterServlet SQL error: " + ex.getMessage(), ex);
            throw new ServletException(ex);
        } catch (Exception ex) {
            log("RegisterServlet error: " + ex.getMessage(), ex);
            throw new ServletException(ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
