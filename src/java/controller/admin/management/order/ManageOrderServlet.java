
package controller.admin.management.order;

import DAO.OrderDAO;
import DAO.OrderItemDAO;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Order;
import model.OrderItem;

@WebServlet(name = "ManageOrderServlet", urlPatterns = {"/ManageOrderServlet"})
public class ManageOrderServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "view/jsp/admin/admin_order.jsp";
        try {
            OrderDAO oDao = new OrderDAO();
            OrderItemDAO oIDao = new OrderItemDAO();
            List<Order> listOrders = oDao.getAllOrders();
            String action = request.getParameter("action");

            if ("showdetail".equals(action)) {
                url = "view/jsp/admin/admin_order_detail.jsp";
                String bill_id = request.getParameter("bill_id");
                Order order = oDao.getOrdersByID(bill_id);
                int id = order.getOrderID();
                List<OrderItem> list = oIDao.getOrderItemByOrderId(id);
                request.setAttribute("LIST_PRODUCTS_IN_ORDER", list);

            } else if ("changeStatus".equals(action)) {
                oDao.UpdateStatus(request.getParameter("id"));
            }

            request.setAttribute("CURRENTSERVLET", "Order");
            request.setAttribute("LIST_ORDERS", listOrders);
        } catch (Exception ex) {
            log("ManageOrderServlet error:" + ex.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
        return "Short description";
    }

}
