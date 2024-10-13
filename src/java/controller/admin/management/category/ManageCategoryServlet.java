
package controller.admin.management.category;

import DAO.CategoryDAO;
import DAO.TypeDAO;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Category;
import model.Type;

@WebServlet(name = "ManageCategoryServlet", urlPatterns = {"/ManageCategoryServlet"})
public class ManageCategoryServlet extends HttpServlet {

    private static final String INSERT = "Insert";

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "view/jsp/admin/admin_categories.jsp";
        try {
            CategoryDAO cDao = new CategoryDAO();
            TypeDAO tDao = new TypeDAO();

            List<Type> listTypes = tDao.getAllType();

            String action = request.getParameter("action");
            if (INSERT.equals(action)) {
                url = "view/jsp/admin/admin_categories_insert.jsp";
            }
            List<Category> list = cDao.getData();
            request.setAttribute("LIST_CATEGORIES", list);
            request.setAttribute("LIST_TYPES", listTypes);
            request.setAttribute("CURRENTSERVLET", "Category");
        } catch (Exception ex) {
            log("ManageCategoryServlet error:" + ex.getMessage());
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
