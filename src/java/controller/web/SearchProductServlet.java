package controller.web;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import DAO.SupplierDAO;
import DAO.TypeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Category;
import model.Product;
import model.Supplier;
import model.Type;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "SearchProductServlet", urlPatterns = {"/search"})
public class SearchProductServlet extends HttpServlet {

    private static final int ITEMS_PER_PAGE = 12;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        CategoryDAO cDao = new CategoryDAO();
            SupplierDAO sDao = new SupplierDAO();
            TypeDAO tDao = new TypeDAO();
        request.setCharacterEncoding("UTF-8");
        String searchQuery = request.getParameter("txtSearch");
       ProductDAO pDao = new ProductDAO();
        List<Product> listProducts = new ArrayList<>();
        if (request.getAttribute("ListProducts") == null) {
                listProducts = pDao.getProductBySearch(searchQuery);
            } else {
                listProducts = ( List<Product>) request.getAttribute("listProducts");
            }
            List<Category> listCategories = cDao.getData();
            List<Supplier> listSuppliers = sDao.getData();
            
            List<Type> listTypes = tDao.getAllType();
                       //Paging
           int page, numPerPage = 12;
           int size = listProducts.size();
           int numberpage = ((size % numPerPage == 0) ? (size / 12) : (size / 12) + 1);
           String xpage = request.getParameter("page");
           
           if (xpage == null) {
               page = 1;
           } else {
                page = Integer.parseInt(xpage);
           }
            int start, end;
           start = (page - 1) * 12;
           end = Math.min(page * numPerPage, size);
           int totalproduct = pDao.getTotalProducts();
            List<Product> listByPage = pDao.getListByPage(listProducts, start, end);
            request.setAttribute("productstart", start);
            request.setAttribute("productend", end);
            request.setAttribute("totalproduct", totalproduct);
            request.setAttribute("DATA_FROM", "search");
            request.setAttribute("NUMBERPAGE", numberpage);
            request.setAttribute("CURRENTPAGE", page);
            request.setAttribute("ListProducts", listByPage);
            request.setAttribute("ListTypes", listTypes);
            request.setAttribute("ListCategories", listCategories);
            request.setAttribute("ListSuppliers", listSuppliers);
            request.setAttribute("txtS", searchQuery);
            request.getSession().setAttribute("urlhistory", "home");
            request.getRequestDispatcher("shop.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SearchProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SearchProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet for searching products";
    }
}