

package controller.web.cart_wishlist;

import DAO.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
import utils.WishlistUtil;


@WebServlet(name="WishlistServlet", urlPatterns={"/wishlist"})
public class WishlistServlet extends HttpServlet {
   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        int productId = Integer.parseInt(request.getParameter("productId"));
        
        WishlistUtil wishlistUtil = new WishlistUtil();
        ProductDAO productDAO = new ProductDAO();
        
        // Get the existing wishlist from cookie
        Cookie wishlistCookie = wishlistUtil.getCookieByName(request, "Wishlist");
        if (wishlistCookie != null) {
            wishlistUtil.getWishlistFromCookie(wishlistCookie);
        }
        
        Product product = productDAO.getProductByID(productId);
        
        if (action.equals("add")) {
            wishlistUtil.addItemToWishlist(product);
        } else if (action.equals("remove")) {
            wishlistUtil.removeItem(product);
        }
        
        // Save updated wishlist to cookie
        String wishlistString = wishlistUtil.convertToString();
        wishlistUtil.saveWishlistToCookie(request, response, wishlistString);
        
        // Redirect back to the previous page or to a wishlist page
        String referer = request.getHeader("Referer");
        response.sendRedirect(referer != null ? referer : "wishlist.jsp");
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
