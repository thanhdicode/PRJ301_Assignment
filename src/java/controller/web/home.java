
package controller.web;

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
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Product;
import model.Supplier;
import model.Type;


public class home extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try {
           
            ProductDAO pDao = new ProductDAO();
            CategoryDAO cDao = new CategoryDAO();
            SupplierDAO sDao = new SupplierDAO();
            TypeDAO tDao = new TypeDAO();
            List<Product> listProducts = new ArrayList<>();
            if (request.getAttribute("ListProducts") == null) {
                listProducts = pDao.getData();
            } else {
                listProducts = ( List<Product>) request.getAttribute("LISTPRODUCTS");
            }
            List<Category> listCategories = cDao.getData();
            List<Supplier> listSuppliers = sDao.getData();
            List<Product> listProductsNew = pDao.getProductNew();
            List<Product> listProductsBestSeller = pDao.getProductsBestSeller();
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
            request.setAttribute("DATA_FROM", "home");
            request.setAttribute("NUMBERPAGE", numberpage);
            request.setAttribute("CURRENTPAGE", page);
            request.setAttribute("ListProducts", listByPage);
            request.setAttribute("ListTypes", listTypes);
            request.setAttribute("ListCategories", listCategories);
            request.setAttribute("ListSuppliers", listSuppliers);
            request.setAttribute("ListProductsNew", listProductsNew);
            request.setAttribute("ListProductsBestSeller", listProductsBestSeller);
            request.getSession().setAttribute("urlhistory", "home");
            request.getRequestDispatcher("shop.jsp").forward(request, response);

        } catch (SQLException ex) {
            log("DispatchServlet error:" + ex.getMessage());
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
        return "Home servlet that retrieves product data";
    }

}
