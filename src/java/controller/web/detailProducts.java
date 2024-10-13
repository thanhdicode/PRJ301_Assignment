/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.web;

import DAO.ProductDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Product;

/**
 *
 * @author ADMIN
 */
public class detailProducts extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int productId = Integer.parseInt(request.getParameter("productId"));
        Product product = new ProductDAO().getProductByID(productId);
        List<Product> listProductsRelated = new ProductDAO().getProductByTypeId(product.getType().getId());
        
        request.setAttribute("product", product);
        request.setAttribute("listProductsRelated", listProductsRelated.subList(0, 4));
        request.getSession().setAttribute("urlhistory", "detail?productId="+productId);
        request.getRequestDispatcher("shop-details.jsp").forward(request, response);
        
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
