
package controller.web.profile;

import DAO.UserDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;


public class EditProfileServlet extends HttpServlet {

    private final String PROFILE = "my-account.jsp";

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String firstName = request.getParameter("first-name");
            String lastName = request.getParameter("last-name");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            String avatar = request.getParameter("avatar");
            String role_raw = request.getParameter("role");
            UserDAO uDao = new UserDAO();

            int roleId = (role_raw.equals("Admin") ? 1 : 2);
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("acc");

            uDao.updateUser(firstName, lastName, email, address, phone, user.getUserName(), avatar, roleId);
            
            // refresh lại session user vì mới update
            user = uDao.checkLogin(user.getUserName(), user.getPassword());
            session.setAttribute("acc", user);
            
            request.setAttribute("STATUS", "Update successfully!!!");
        } catch (Exception ex) {
            log("EditProfileServlet error:" + ex.getMessage());
        } finally {
            request.getRequestDispatcher(PROFILE).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
