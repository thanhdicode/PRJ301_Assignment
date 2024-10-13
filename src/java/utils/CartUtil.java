
package utils;

import DAO.ProductDAO;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CartItem;
import model.Product;

/**
 *
 * @author thanhhuynh
 */
public class CartUtil {

    private static HashMap<Integer, CartItem> listItemsInCart = new HashMap<>();

    public HashMap<Integer, CartItem> createCart(CartItem item) {
        listItemsInCart = new HashMap<>();
        listItemsInCart.put(item.getProduct().getId(), item);
        return listItemsInCart;
    }

    public HashMap<Integer, CartItem> addItemToCart(CartItem item) {
        if (checkItemExist(item.getProduct())) {
            CartItem itemExist = listItemsInCart.get(item.getProduct().getId());
            itemExist.setQuantity(itemExist.getQuantity() + item.getQuantity());
            listItemsInCart.put(itemExist.getProduct().getId(), itemExist);
        } else {
            listItemsInCart.put(item.getProduct().getId(), item);
        }
        return listItemsInCart;
    }
    
     public HashMap<Integer, CartItem> updateItemToCart(CartItem item) {
        if (checkItemExist(item.getProduct())) {
            CartItem itemExist = listItemsInCart.get(item.getProduct().getId());
            itemExist.setQuantity(item.getQuantity());
            listItemsInCart.put(itemExist.getProduct().getId(), itemExist);
        } else {
            listItemsInCart.put(item.getProduct().getId(), item);
        }
        return listItemsInCart;
    }

    public boolean checkItemExist(Product product) {
        for (Integer id : listItemsInCart.keySet()) {
            if (product.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public HashMap<Integer, CartItem> removeItem(Product product) {
        listItemsInCart.remove(product.getId());
        return listItemsInCart;
    }

    // Xu li voi cookie
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

    public void saveCartToCookie(HttpServletRequest request,
            HttpServletResponse response, String strItemsInCart) {
        String cookieName = "Cart";

        Cookie cookieCart = getCookieByName(request, cookieName);

        if (cookieCart != null) {

            cookieCart.setValue(strItemsInCart);

        } else {

            cookieCart = new Cookie(cookieName, strItemsInCart);

        }

        cookieCart.setMaxAge(60 * 60 * 24 * 30 * 3);

        response.addCookie(cookieCart);

    }

    public String convertToString() {
        List<CartItem> list = new ArrayList<>(listItemsInCart.values());
        return list.toString();

    }

    public List<CartItem> getCartFromCookie(Cookie cookieCart) {
        ProductDAO pDao = new ProductDAO();
        List<CartItem> listItemsCart = new ArrayList<>();
        String inputString = cookieCart.getValue();
        if (inputString.startsWith("[") && inputString.endsWith("]")) {
            inputString = inputString.substring(1, inputString.length() - 1);
        }

        // Chia chuỗi thành các phần tử
        String[] elements = inputString.split(",");

        List<Product> products = new ArrayList<>();
        for (int i = 0; i < elements.length; i += 2) {
            Product product = pDao.getProductByID(Integer.parseInt(elements[i].trim()));
            products.add(product);
        }
        List<Integer> quantitys = new ArrayList<>();
        for (int i = 1; i < elements.length; i += 2) {
            quantitys.add(Integer.parseInt(elements[i].trim()));
        }
        // Lấy ra ListCartItem 
        for (int i = 0; i < products.size(); i++) {
            CartItem item = new CartItem(products.get(i), quantitys.get(i));
            listItemsCart.add(item);
        }
        
        // add listItems to util
        for (CartItem cartItem : listItemsCart) {
            addItemToCart(cartItem);
        }
        return listItemsCart;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        CartUtil cartUtil = new CartUtil();
        ProductDAO pDao = new ProductDAO();
        Product product1 = pDao.getProductByID(1);
        Product product2 = pDao.getProductByID(2);
        CartItem item1 = new CartItem(product1, 2);
        CartItem item2 = new CartItem(product2, 2);

        HashMap<Integer, CartItem> carts = cartUtil.createCart(item1);
        carts = cartUtil.addItemToCart(item2);
        List<CartItem> list = new ArrayList<>(carts.values());
//        String string = cartUtil.convertToString();
//        System.out.println(string);
        System.out.println(list.toString());
    }
}
