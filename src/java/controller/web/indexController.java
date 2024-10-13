
package controller.web;

import DAO.ProductDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

public class indexController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
           ProductDAO pDAO = new ProductDAO();
           List<Product> listProductsBestSeller = pDAO.getProductsBestSeller();
           List<Product> listProductsNew = pDAO.getProductNew();
           List<Product> listHotSale = pDAO.getProductByCategoryId2(13);
           request.setAttribute("listProductsBestSeller", listProductsBestSeller.subList(0, 5));
           request.setAttribute("listProductsNew", listProductsNew);
           request.setAttribute("listHotSale", listHotSale);
           request.getRequestDispatcher("index.jsp").forward(request, response);
           
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(indexController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(indexController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
