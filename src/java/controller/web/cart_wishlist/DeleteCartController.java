
package controller.web.cart_wishlist;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.Map;
import model.CartItem;


public class DeleteCartController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       int productId = Integer.parseInt(request.getParameter("productId"));
       HttpSession session = request.getSession();
       Map<Integer, CartItem> carts = (Map<Integer, CartItem>) session.getAttribute("carts");
        if (carts == null) {
            carts = new LinkedHashMap<>();
        }
        if(carts.containsKey(productId)){
            carts.remove(productId);
        }
        session.setAttribute("carts", carts);
        response.sendRedirect("carts");
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
