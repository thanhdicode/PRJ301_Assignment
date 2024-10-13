
package controller.admin.management.user;

import DAO.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;


@WebServlet(name = "InsertUserServlet", urlPatterns = {"/InsertUserServlet"})
public class InsertUserServlet extends HttpServlet {

    private static final String MANAGE_USER_CONTROLLER = "ManageUserServlet";
    private static final String INSERT_USER_PAGE = "view/jsp/admin/admin_user_insert.jsp";

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "ManageUserServlet";
        try {
            UserDAO dao = new UserDAO();
            String avatar = request.getParameter("avatar");
            String fullName = request.getParameter("fullname");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            String role = request.getParameter("role");

            String image = "";
            String firstName = fullName;
            String lastName = "";
            int roleId = 2;
            if (dao.checkUserNameDuplicate(username)) {
                url = "view/jsp/admin/admin_user_insert.jsp";
                request.setAttribute("error", "Tên tài khoản đã tồn tại!");
            } else {
                if (!avatar.equals("")) {
                    avatar = "view/assets/home/img/users/" + avatar;
                }
                if (fullName.split(" ").length > 0) {
                    String[] nameParts = fullName.split(" ");
                    firstName = nameParts[0];
                    lastName = String.join(" ", Arrays.copyOfRange(nameParts, 1, nameParts.length));
                }
                if ("admin".equals(role)) {
                    roleId = 1;
                }
                User user = new User(0, firstName, lastName, email, avatar, username, password, address, phone, roleId, true);
                dao.registerUser(user);
                request.setAttribute("mess", "Insert successfully!");
            }
        } catch (Exception ex) {
            log("InserUserServlet error:" + ex.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
