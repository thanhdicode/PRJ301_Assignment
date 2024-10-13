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

public class CartController extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Map<Integer,CartItem> carts = (Map<Integer,CartItem>) session.getAttribute("carts");
        if(carts==null){
            carts = new LinkedHashMap<>();
        }
        
        double totalMoney = calculateTotalMoney(carts);
        
        request.setAttribute("totalMoney", totalMoney);
        request.setAttribute("carts", carts);
        request.getRequestDispatcher("shopping-cart.jsp").forward(request, response);
    }
   
    private double calculateTotalMoney(Map<Integer,CartItem> carts) {
        return carts.values().stream()
            .mapToDouble(cart -> cart.getQuantity() * cart.getProduct().getPrice())
            .sum();
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