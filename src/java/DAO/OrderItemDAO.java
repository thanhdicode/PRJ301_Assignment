
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.CartItem;
import model.Order;
import model.OrderItem;
import model.Product;

import java.util.List;

import java.util.ArrayList;


import utils.DBContext;

public class OrderItemDAO extends DBContext {

    private ProductDAO pDao = new ProductDAO();


    public List<OrderItem> getOrderItemByOrderId(int id) {
        List<OrderItem> list = new ArrayList<>();
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ptm = null;
        try {
            con = getConnection();
            if (con != null) {
                ptm = con.prepareStatement("SELECT order_id, product_id, SUM(quantity) AS quantity, price FROM OrderItem WHERE order_id = ? GROUP BY order_id, product_id, price");
                ptm.setInt(1, id);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int quantity = rs.getInt("quantity");
                    double price = rs.getDouble("price");
                    int productID = rs.getInt("product_id");
                    Product product = pDao.getProductByID(productID);
                    int orderID = rs.getInt("order_id");
                    OrderItem order = new OrderItem(quantity, price, product, orderID);
                    list.add(order);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public boolean createNewOrderDetail(CartItem item, Order order) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("""
                                                        INSERT INTO [dbo].[OrderItem]
                                                                   ([quantity]
                                                                   ,[price]
                                                                   ,[product_id]
                                                                   ,[order_id])
                                                             VALUES (?,?,?,?)""");
                ptm.setInt(1, item.getQuantity());
                ptm.setDouble(2, item.getProduct().getSalePrice());
                ptm.setInt(3, item.getProduct().getId());
                ptm.setInt(4, order.getOrderID());
                ptm.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        OrderItemDAO dao = new OrderItemDAO();
        List<OrderItem> list = dao.getOrderItemByOrderId(1);
        for (OrderItem orderItem : list) {
            System.out.println(orderItem.getProduct().getName());
        }
    }

}
