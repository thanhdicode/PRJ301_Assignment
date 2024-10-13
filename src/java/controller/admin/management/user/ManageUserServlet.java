
package controller.admin.management.user;

import DAO.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;


@WebServlet(name = "ManageUserServlet", urlPatterns = {"/ManageUserServlet"})
public class ManageUserServlet extends HttpServlet {

    private final String MANAGE_USER_PAGE = "view/jsp/admin/admin_users.jsp";
    private final String INSERT_USER_PAGE = "view/jsp/admin/admin_user_insert.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "view/jsp/admin/admin_users.jsp";
        try {
            String action = request.getParameter("action");
            UserDAO dao = new UserDAO();
            if (action == null) {
                List<User> list = dao.getData();
                request.setAttribute("LISTUSERS", list);
                request.setAttribute("CURRENTSERVLET", "User");
                url = "view/jsp/admin/admin_users.jsp";
            } else if (action.equals("Insert")) {
                url = "view/jsp/admin/admin_user_insert.jsp";
            } else if (action.equals("Update")) {
                List<User> list = dao.getData();
                request.setAttribute("CURRENTSERVLET", "User");
                request.setAttribute("LISTUSERS", list);
                url = "view/jsp/admin/admin_users.jsp";
            }
        } catch (Exception ex) {
            log("ManageUserServlet error:" + ex.getMessage());
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
