package controller.web.cart_wishlist;

import DAO.ProductDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.Map;
import model.CartItem;
import model.Product;


public class AddToCartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int productId = Integer.parseInt(request.getParameter("productId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        HttpSession session = request.getSession();
        Map<Integer, CartItem> carts = (Map<Integer, CartItem>) session.getAttribute("carts");
        if (carts == null) {
            carts = new LinkedHashMap<>();
        }
           
        if (carts.containsKey(productId)) {//san pham da ton tai tren gio hang roi
            int oldQuantity = carts.get(productId).getQuantity();
            carts.get(productId).setQuantity(oldQuantity + 1);
        } else { // san pham chua ton tai tren gio hang
            Product product = new ProductDAO().getProductByID(productId);
            carts.put(productId, CartItem.builder().product(product).quantity(quantity).build());
        }
        // luu cart len session
        session.setAttribute("carts", carts);
        String urlHistory =(String) session.getAttribute("urlhistory");
        String page = (String) request.getAttribute("page");
        if(urlHistory==null){
            urlHistory = "home";
        }
        request.setAttribute("page", page);
        request.getRequestDispatcher(urlHistory).forward(request, response);

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
