package custom_tag;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Map;
import model.CartItem;

public class TotalMoneyTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        DecimalFormat df = new DecimalFormat("#0.00");
        
        try {
           // lay cart tu session
            HttpSession session = ((jakarta.servlet.jsp.PageContext)getJspContext()).getSession();
            
            Map<Integer, CartItem> carts = (Map<Integer, CartItem>) session.getAttribute("carts");
            // mac dinh neu chua them gi thi cart == 0
            if (carts == null || carts.isEmpty()) {
                out.print(df.format(0.00));
                return;
            }
            // lay tong tien tu cart
            double totalMoney = carts.values().stream()
                .mapToDouble(cart -> cart.getQuantity() * cart.getProduct().getPrice())
                .sum();
            
            out.print(df.format(totalMoney));
        } catch (Exception e) {
            // Log the exception (you can replace this with a proper logging mechanism)
            e.printStackTrace();
            // Output a default value or error message
            out.print("Error calculating total");
        }
    }
}