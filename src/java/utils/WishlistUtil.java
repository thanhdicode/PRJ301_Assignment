package utils;

import DAO.ProductDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

/**
 * Utility class for managing a wishlist.
 */
public class WishlistUtil {

    private HashMap<Integer, Product> listItemsInWishlist;

    /**
     * Constructor to initialize the wishlist.
     */
    public WishlistUtil() {
        listItemsInWishlist = new HashMap<>();
    }

    
    public HashMap<Integer, Product> createWishlist(Product item) {
        listItemsInWishlist = new HashMap<>();
        listItemsInWishlist.put(item.getId(), item);
        return listItemsInWishlist;
    }

   
    public HashMap<Integer, Product> addItemToWishlist(Product item) {
        if (!checkItemExist(item)) {
            listItemsInWishlist.put(item.getId(), item);
        }
        return listItemsInWishlist;
    }

    
    public boolean checkItemExist(Product product) {
        return listItemsInWishlist.containsKey(product.getId());
    }

  
    public HashMap<Integer, Product> removeItem(Product product) {
        listItemsInWishlist.remove(product.getId());
        return listItemsInWishlist;
    }

    // Cookie handling

    
    public Cookie getCookieByName(HttpServletRequest request, String cookieName) {
        Cookie[] arrCookies = request.getCookies();
        if (arrCookies != null) {
            for (Cookie cookie : arrCookies) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie;
                }
            }
        }
        return null;
    }

   
    public void saveWishlistToCookie(HttpServletRequest request,
            HttpServletResponse response, String strItemsInWishList) {
        String cookieName = "Wishlist";
        Cookie cookieWishlist = getCookieByName(request, cookieName);

        if (cookieWishlist != null) {
            cookieWishlist.setValue(strItemsInWishList);
        } else {
            cookieWishlist = new Cookie(cookieName, strItemsInWishList);
        }

        cookieWishlist.setMaxAge(60 * 60 * 24 * 30 * 3); // Cookie expiration: 3 months
        response.addCookie(cookieWishlist);
    }

   
    public String convertToString() {
        StringBuilder result = new StringBuilder();
        for (Product product : listItemsInWishlist.values()) {
            result.append(product.getId()).append(",");
        }
        if (result.length() > 0) {
            result.setLength(result.length() - 1); // Remove trailing comma
        }
        return result.toString();
    }

    public List<Product> getWishlistFromCookie(Cookie cookieWishlist) {
        ProductDAO pDao = new ProductDAO();
        List<Product> listItemsCart = new ArrayList<>();
        String inputString = cookieWishlist.getValue();

        if (inputString.endsWith(",")) {
            inputString = inputString.substring(0, inputString.length() - 1);
        }

        if (!inputString.isEmpty()) {
            String[] elements = inputString.split(",");
            for (String element : elements) {
                Product product = pDao.getProductByID(Integer.parseInt(element.trim()));
                listItemsCart.add(product);
            }
        }

        for (Product product : listItemsCart) {
            addItemToWishlist(product);
        }

        return listItemsCart;
    }

    // Main function to test the class
    public static void main(String[] args) {
        WishlistUtil wishlistUtil = new WishlistUtil();

        // Create some mock products
        
//          private int id;
//    private String name, description;
//    private int stock, unitSold;
//    private String[] images, colors, size;
//    private Date releasedate;
//    private double discount, price, salePrice;
//    private boolean status;
//    private Category category;
//    private Supplier supplier;
//    private Type type;
ProductDAO dao = new ProductDAO();
        Product product1 = dao.getProductByID(1);
        Product product2 = dao.getProductByID(2);
        Product product3 = dao.getProductByID(3);

        // Add products to wishlist
        wishlistUtil.addItemToWishlist(product1);
        wishlistUtil.addItemToWishlist(product2);

        // Check if a product exists in the wishlist
        System.out.println("Product 1 exists: " + wishlistUtil.checkItemExist(product1)); // true
        System.out.println("Product 3 exists: " + wishlistUtil.checkItemExist(product3)); // false

        // Remove a product from the wishlist
        wishlistUtil.removeItem(product1);
        System.out.println("Product 1 exists after removal: " + wishlistUtil.checkItemExist(product1)); // false

        // Convert wishlist to string and print
        System.out.println("Wishlist as string: " + wishlistUtil.convertToString()); // "2"
    }
}
