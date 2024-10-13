
package controller.web.checkout;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.Map;
import model.CartItem;


public class checkOutController extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Map<Integer,CartItem> carts = (Map<Integer,CartItem>) session.getAttribute("carts");
        if(carts==null){
            carts = new LinkedHashMap<>();
        }
        double totalMoney = 0;
        for (Map.Entry<Integer, CartItem> entry : carts.entrySet()) {
            Integer productId = entry.getKey();
            CartItem cart = entry.getValue();
            totalMoney += cart.getQuantity()* cart.getProduct().getPrice();
        }
        request.setAttribute("totalMoney", totalMoney);
        request.setAttribute("carts",carts);
        request.getRequestDispatcher("checkout.jsp").forward(request, response);
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
