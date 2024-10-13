package DAO;

import utils.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Supplier;

/**
 *
 * @author thanhhuynh
 */
public class SupplierDAO extends DBContext {

    public List<Supplier> getData() throws SQLException {
        List<Supplier> suppliers = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT * FROM Suppliers");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int supplierId = rs.getInt("supplierid");
                    String supplierName = rs.getString("suppliername");
                    String supplierImage = rs.getString("supplierimage");
                    suppliers.add(new Supplier(supplierId, supplierName, supplierImage));
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
        return suppliers;
    }

    public Supplier getSupplierById(int id) throws SQLException {
        Supplier supplier = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT * FROM Suppliers WHERE supplierid = ?");
                ptm.setInt(1, id);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int supplierId = rs.getInt("supplierId");
                    String supplierName = rs.getString("suppliername");
                    String supplierImage = rs.getString("supplierimage");
                    supplier = new Supplier(supplierId, supplierName, supplierImage);
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
        return supplier;
    }

    public static void main(String[] args) throws SQLException {
        SupplierDAO dao = new SupplierDAO();
        List<Supplier> list = dao.getData();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName());
        }
    }
}
