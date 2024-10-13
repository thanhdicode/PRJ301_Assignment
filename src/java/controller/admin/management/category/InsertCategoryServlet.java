
package controller.admin.management.category;

import DAO.CategoryDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "InsertCategoryServlet", urlPatterns = {"/InsertCategoryServlet"})
public class InsertCategoryServlet extends HttpServlet {


  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "ManageCategoryServlet";
        CategoryDAO cDao = new CategoryDAO();
        String cateName = request.getParameter("newcate");
        String typeId = request.getParameter("type_id");
        if (cateName != null) {
            cDao.insertCategory(cateName, typeId);
        }
        request.getRequestDispatcher(url).forward(request, response);
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
    }// </editor-fold>

}
