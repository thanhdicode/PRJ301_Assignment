
package DAO;

import utils.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Payment;

/**
 *
 * @author thanhhuynh
 */
public class PaymentDAO extends DBContext {


    public Payment getPaymentById(int id) throws SQLException {
        Payment result = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT * FROM Payments WHERE paymentid = ?");
                ptm.setInt(1, id);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String method = rs.getString("payment_method");
                    result = new Payment(id, method);
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

    public List<Payment> getPaymentData() throws SQLException {
        List<Payment> result = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT * FROM Payments");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("paymentid");
                    String method = rs.getString("payment_method");
                    Payment payment = new Payment(id, method);
                    result.add(payment);
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
    
    public static void main(String[] args) throws SQLException {
        PaymentDAO dao = new PaymentDAO();
        List<Payment> pms = dao.getPaymentData();
        for (Payment pm : pms) {
            System.out.println(pm.getPaymentMethod());
            
        }
        
    }
}
