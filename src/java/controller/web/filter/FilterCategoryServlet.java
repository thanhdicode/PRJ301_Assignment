
package controller.web.filter;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import DAO.SupplierDAO;
import DAO.TypeDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.Product;
import model.Supplier;
import model.Type;


public class FilterCategoryServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        CategoryDAO cDao = new CategoryDAO();
        SupplierDAO sDao = new SupplierDAO();
        TypeDAO tDao = new TypeDAO();

        response.setContentType("text/html;charset=UTF-8");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        List<Product> ListProducts = new ProductDAO().getProductByCategoryId2(categoryId);
        List<Category> listCategories = cDao.getData();
        List<Supplier> listSuppliers = sDao.getData();
        List<Type> listTypes = tDao.getAllType();
        request.setAttribute("ListTypes", listTypes);
        request.setAttribute("ListCategories", listCategories);
        request.setAttribute("ListSuppliers", listSuppliers);
        request.setAttribute("ListProducts", ListProducts);
        request.getRequestDispatcher("shop.jsp").forward(request, response);
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(FilterCategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(FilterCategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
