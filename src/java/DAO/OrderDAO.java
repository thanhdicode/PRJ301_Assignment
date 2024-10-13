
package DAO;

import utils.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Order;
import model.Payment;
import model.User;

/**
 *
 * @author thanhhuynh
 */
public class OrderDAO extends DBContext {

    private final UserDAO uDao = new UserDAO();
    private final PaymentDAO pDao = new PaymentDAO();

    private static final String CREATE_ORDER = """
                                               INSERT INTO [dbo].[Orders]
                                                          ([orderdate]
                                                          ,[totalprice]
                                                          ,[paymentid]
                                                          ,[username]
                                                          ,[status]
                                                            ,[note])
                                                    VALUES(?,?,?,?, 0,?)""";

    public double getTotalSale() throws SQLException {
        double result = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT SUM(totalprice) AS TotalSale from [Orders]");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    result = rs.getDouble("TotalSale");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public double getTotalSaleToday() throws SQLException {
        double result = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT sum(totalprice) AS TotalSale FROM [Orders] " + " WHERE cast(orderdate as Date) = cast(getdate() as Date)");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    result = rs.getDouble("TotalSale");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public double getTotalMoneyByYear(int year) throws SQLException {
        double result = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT SUM(totalprice) AS TotalSale from [Orders] where year([orderdate]) = ? AND Status = 1");
                ptm.setInt(1, year);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    result = rs.getDouble("TotalSale");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public double getTotalMoneyByMonth(int month) throws SQLException {
        double result = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT SUM(totalprice) AS TotalSale from [Orders] where month([orderdate]) = ? AND Status = 1");
                ptm.setInt(1, month);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    result = rs.getDouble("TotalSale");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public List<Order> getRecentOrders() throws SQLException {
        List<Order> orders = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT Top 10 * FROM Orders ORDER BY orderdate DESC");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int orderId = rs.getInt("order_id");
                    Date orderDate = rs.getDate("orderdate");
                    double totalPrice = rs.getDouble("totalprice");
                    int paymentId = rs.getInt("paymentid");
                    Payment payment = pDao.getPaymentById(paymentId);
                    String userName = rs.getString("username");
                    User user = uDao.getUserByName(userName);
                    boolean status = rs.getBoolean("status");
                    String note = rs.getString("note");
                    Order order = new Order(orderId, orderDate, totalPrice, payment, user, status,note);
                    orders.add(order);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return orders;
    }

    public Order getTheLatestOrder() throws SQLException {
        Order order = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT TOP 1 * FROM Orders ORDER BY order_id DESC");
                rs = ptm.executeQuery();
                if (rs.next()) {
                    int orderId = rs.getInt("order_id");
                    Date orderDate = rs.getDate("orderdate");
                    double totalPrice = rs.getDouble("totalprice");
                    int paymentId = rs.getInt("paymentid");
                    Payment payment = pDao.getPaymentById(paymentId);
                    String userName = rs.getString("username");
                    User user = uDao.getUserByName(userName);
                    boolean status = rs.getBoolean("status");
                    String note = rs.getString("note");
                    order = new Order(orderId, orderDate, totalPrice, payment, user, status,note);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return order;
    }

    public List<Order> getOrdersByUsername(String userName) throws SQLException {
        List<Order> orders = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT * FROM [Orders] WHERE username = ?");
                ptm.setString(1, userName);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int orderId = rs.getInt("order_id");
                    Date orderDate = rs.getDate("orderdate");
                    double totalPrice = rs.getDouble("totalprice");
                    int paymentId = rs.getInt("paymentid");
                    Payment payment = pDao.getPaymentById(paymentId);
                    boolean status = rs.getBoolean("status");
                    User user = uDao.getUserByName(userName);
                    String note = rs.getString("note");
                    Order order = new Order(orderId, orderDate, totalPrice, payment, user, status,note);
                    orders.add(order);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return orders;
    }

    public Order getOrdersByID(String id) throws SQLException {
        Order order = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT * FROM [Orders] WHERE order_id = ?");
                ptm.setString(1, id);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int orderId = rs.getInt("order_id");
                    Date orderDate = rs.getDate("orderdate");
                    double totalPrice = rs.getDouble("totalprice");
                    int paymentId = rs.getInt("paymentid");
                    Payment payment = pDao.getPaymentById(paymentId);
                    boolean status = rs.getBoolean("status");
                    String userName = rs.getString("username");
                    User user = uDao.getUserByName(userName);
                    String note = rs.getString("note");
                    order = new Order(orderId, orderDate, totalPrice, payment, user, status,note);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return order;
    }

    public int getTotalOrders() throws SQLException {
        int result = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT COUNT(*) AS Total FROM [Orders]");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    result = rs.getInt("Total");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public List<Order> getAllOrders() throws SQLException {
        List<Order> orders = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT * FROM [Orders]");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int orderId = rs.getInt("order_id");
                    Date orderDate = rs.getDate("orderdate");
                    double totalPrice = rs.getDouble("totalprice");
                    int paymentId = rs.getInt("paymentid");
                    Payment payment = pDao.getPaymentById(paymentId);
                    String userName = rs.getString("username");
                    User user = uDao.getUserByName(userName);
                    boolean status = rs.getBoolean("status");
                    String note = rs.getString("note");
                    Order order = new Order(orderId, orderDate, totalPrice, payment, user, status,note);
                    orders.add(order);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return orders;
    }

    public void UpdateStatus(String orderId) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("UPDATE [Orders] SET status = 1 WHERE order_id = ?");
                ptm.setString(1, orderId);
                ptm.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public boolean CreateNewOrder(String date, double total, Payment payment, User user, String note) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE_ORDER);
                ptm.setString(1, date);
                ptm.setDouble(2, total);
                ptm.setInt(3, payment.getPaymentID());
                ptm.setString(4, user.getUserName());
                ptm.setString(5, note);
                ptm.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }

//   public static void main(String[] args) {
//        try {
//            OrderDAO dao = new OrderDAO();
//
//            // Test getTotalSale
//            System.out.println("Total Sale: " + dao.getTotalSale());
//
//            // Test getTotalSaleToday
//            System.out.println("Total Sale Today: " + dao.getTotalSaleToday());
//
//            // Test getTotalMoneyByYear
//            int year = 2023;
//            System.out.println("Total Money by Year (" + year + "): " + dao.getTotalMoneyByYear(year));
//
//            // Test getTotalMoneyByMonth
//            int month = 6;
//            System.out.println("Total Money by Month (" + month + "): " + dao.getTotalMoneyByMonth(month));
//
//            // Test getRecentOrders
//            List<Order> recentOrders = dao.getRecentOrders();
//            System.out.println("Recent Orders:");
//            for (Order order : recentOrders) {
//                System.out.println(order);
//            }
//
//            // Test getTheLatestOrder
//            Order latestOrder = dao.getTheLatestOrder();
//            System.out.println("Latest Order: " + latestOrder);
//
//            // Test getOrdersByUsername
//            String userName = "testUser";
//            List<Order> ordersByUser = dao.getOrdersByUsername(userName);
//            System.out.println("Orders by User (" + userName + "):");
//            for (Order order : ordersByUser) {
//                System.out.println(order);
//            }
//
//            // Test getOrdersByID
//            String orderId = "1";
//            Order orderById = dao.getOrdersByID(orderId);
//            System.out.println("Order by ID (" + orderId + "): " + orderById);
//
//            // Test getTotalOrders
//            System.out.println("Total Orders: " + dao.getTotalOrders());
//
//            // Test getAllOrders
//            List<Order> allOrders = dao.getAllOrders();
//            System.out.println("All Orders:");
//            for (Order order : allOrders) {
//                System.out.println(order);
//            }
//
//            // Test UpdateStatus
//            String updateOrderId = "1";
//            dao.UpdateStatus(updateOrderId);
//            System.out.println("Updated Order Status for ID: " + updateOrderId);
//
//            // Test CreateNewOrder
//            String date = "2024-06-21";
//            double total = 100.0;
//            Payment payment = new Payment(1, "Credit Card"); // Assuming constructor and attributes
//            User user = new UserDAO().getUserByName("admin");
//            String note = "Test Note";
//            boolean isCreated = dao.CreateNewOrder(date, total, payment, user, note);
//            System.out.println("Create New Order: " + (isCreated ? "Success" : "Failure"));
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
