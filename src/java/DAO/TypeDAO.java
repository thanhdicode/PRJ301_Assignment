
package DAO;

import utils.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Type;


public class TypeDAO extends DBContext {

    public Type getTypeById(int id) throws SQLException {
        Type type = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT * FROM Types WHERE id = ?");
                ptm.setInt(1, id);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    int typeid = rs.getInt("id");
                    String name = rs.getString("name");
                    type = new Type(typeid, name);
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
        return type;
    }

    public List<Type> getAllType() throws SQLException {
        List<Type> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT * FROM Types");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int typeid = rs.getInt("id");
                    String name = rs.getString("name");
                    Type type = new Type(typeid, name);
                    list.add(type);
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
        return list;
    }

    public static void main(String[] args) throws SQLException {
        TypeDAO dao = new TypeDAO();
//        Type list = dao.getTypeById(1);
//        System.out.println(list);
        List<Type> list = dao.getAllType();
        for (Type type : list) {
            System.out.println(type.getName());
        }
    }
}
