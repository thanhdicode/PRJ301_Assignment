package controller.web;

import DAO.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

@WebServlet(name = "SearchbyAjax", urlPatterns = {"/searchAjax"})
public class SearchbyAjax extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String searchQuery = request.getParameter("txtSearch");
        if (searchQuery == null || searchQuery.trim().isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        ProductDAO pDao = new ProductDAO();
        
        try {
            List<Product> listProducts = pDao.getProductBySearch(searchQuery);
            
            try (PrintWriter out = response.getWriter()) {
                if (listProducts.isEmpty()) {
                    out.println("<p>No products found.</p>");
                } else {
                    for (Product p : listProducts) {
                        out.println("<div class=\"col-lg-4 col-md-6 col-sm-6\">"
                                + "<div class=\"product__item\">"
                                + "<div class=\"product__item__pic set-bg\" data-setbg=\"" + p.getImages() + "\">"
                                + "<img src=\"" + p.getImages() + "\" alt=\"" + p.getName() + "\" style=\"width: 100%; height: auto;\">"
                                + "<ul class=\"product__hover\">"
                                + "<li><a href=\"#\"><img src=\"img/icon/heart.png\" alt=\"\"><span>Add to favorite</span></a></li>"
                                + "<li><a href=\"#\"><img src=\"img/icon/compare.png\" alt=\"\"><span>Add to wish list</span></a></li>"
                                + "<li><a href=\"detail?productId=" + p.getId() + "\"><img src=\"img/icon/search.png\" alt=\"\"><span>View details</span></a></li>"
                                + "</ul>"
                                + "</div>"
                                + "<div class=\"product__item__text\">"
                                + "<h6>" + p.getName() + "</h6>"
                                + "<a href=\"addToCart?productId=" + p.getId() + "\" class=\"add-cart\">+ Add To Cart</a>"
                                + "<div class=\"rating\">"
                                + "<i class=\"fa fa-star\"></i>"
                                + "<i class=\"fa fa-star\"></i>"
                                + "<i class=\"fa fa-star\"></i>"
                                + "<i class=\"fa fa-star\"></i>"
                                + "<i class=\"fa fa-star\"></i>"
                                + "</div>"
                                + "<div style=\"display: flex; justify-content: space-between;\">"
                                + "<h5>$" + String.format("%.2f", p.getPrice()) + "</h5>"
                                + "<h6 style=\"color: #F27474;\">" + p.getUnitSold() + " Sold</h6>"
                                + "</div>"
                                + "</div>"
                                + "</div>"
                                + "</div>");
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchbyAjax.class.getName()).log(Level.SEVERE, "Error searching products", ex);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println("An error occurred while searching for products.");
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
        return "Servlet for searching products using AJAX";
    }
}