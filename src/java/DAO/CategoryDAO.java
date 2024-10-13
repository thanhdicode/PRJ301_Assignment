
package DAO;

import utils.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Type;


public class CategoryDAO extends DBContext {

 

    public List<Category> getData() throws SQLException {
        List<Category> categories = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT * FROM Categories");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    TypeDAO dao = new TypeDAO();
                    Type type = dao.getTypeById(rs.getInt("type_id"));
                    int categoryId = rs.getInt("categoryid");
                    String categoryName = rs.getString("categoryname");
                    int typeid = rs.getInt("type_id");
                    categories.add(new Category(categoryId, categoryName, type));
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
        return categories;
    }

    public List<Category> getCategoriesByTypeId(int typpid) throws SQLException {
        List<Category> categories = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT * FROM Categories WHERE type_id = ?");
                ptm.setInt(1, typpid);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    TypeDAO dao = new TypeDAO();
                    Type type = dao.getTypeById(rs.getInt("type_id"));
                    int categoryId = rs.getInt("categoryid");
                    String categoryName = rs.getString("categoryname");
                    int typeid = rs.getInt("type_id");
                    categories.add(new Category(categoryId, categoryName, type));
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
        return categories;
    }

    public Category getCategoryById(int id) throws SQLException {
        Category category = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT * FROM Categories WHERE categoryid = ?");
                ptm.setInt(1, id);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    TypeDAO dao = new TypeDAO();
                    Type type = dao.getTypeById(rs.getInt("type_id"));
                    int categoryId = rs.getInt("categoryid");
                    String categoryName = rs.getString("categoryname");
                    int typeid = rs.getInt("type_id");
                    category = new Category(categoryId, categoryName, type);
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
        return category;
    }

    public int getQuantityByName(String name) throws SQLException {
        int quantity = 0;
        Category category = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT COUNT(*) AS Total FROM Categories WHERE categoryname = ?");
                ptm.setString(1, name);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    quantity = rs.getInt("Total");
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
        return quantity;
    }

    public boolean insertCategory(String categoryName, String typeId) {
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = getConnection();
            if (con != null) {
                ptm = con.prepareStatement("INSERT INTO Categories VALUES (?,?)");
                ptm.setString(1, categoryName);
                ptm.setString(2, typeId);
                ptm.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public void deleteCategory(String cid) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("DELETE FROM Categories WHERE categoryid = ?");
                ptm.setString(1, cid);
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

    public void editCategory(String name, String tId, String id) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("UPDATE Categories SET categoryname = ?, Type_id = ? WHERE categoryid = ?");
                ptm.setString(1, name);
                ptm.setString(2, tId);
                ptm.setString(3, id);
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

    public static void main(String[] args) throws SQLException {
        CategoryDAO dao = new CategoryDAO();
        dao.editCategory("mimo", "1", "1");
        List<Category> list = dao.getData();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName());
        }

        for (Category category : list) {
            System.out.println(category.getName());
        }

        int quantity = dao.getQuantityByName("T-shirt");
        System.out.println(quantity);

    }
}
