package DAO;

import utils.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.CartItem;
import model.Category;
import model.Product;
import model.Supplier;
import model.Type;


public class ProductDAO extends DBContext {

    public List<Product> getData() throws SQLException {
        List<Product> products = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT * FROM Products WHERE status = 1");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    CategoryDAO cDao = new CategoryDAO();
                    SupplierDAO sDao = new SupplierDAO();
                    TypeDAO tDao = new TypeDAO();
                    String productname = rs.getString("productname");
                    int id = rs.getInt("id");
                    Supplier supplier = sDao.getSupplierById(rs.getInt("supplierid"));
                    Category category = cDao.getCategoryById(rs.getInt("categoryid"));
                    Type type = tDao.getTypeById(rs.getInt("typeid"));
                    int stock = rs.getInt("stock");
                    String description = rs.getString("description");
                    Date date = rs.getDate("releasedate");
                    double discount = rs.getDouble("discount");
                    int unitSold = rs.getInt("unitSold");
                    double price = rs.getDouble("price");
                    boolean status = rs.getBoolean("status");
                    String colors[] = rs.getString("colors").split(",");
                    String images[] = rs.getString("images").split(" ");
                    String sizes[] = rs.getString("size").split(",");
                    Product product = new Product(id, productname, description, stock, unitSold, images, colors, sizes, date, discount, price, status, category, supplier, type);
                    products.add(product);
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
        return products;
    }

    public void insertProduct(String name, int cId, int sId, int tId, double price, double discount, String size, String color, int stock,
            String date, String images, String description) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("INSERT INTO Products VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                ptm.setString(1, name);
                ptm.setInt(2, sId);
                ptm.setInt(3, cId);
                ptm.setString(4, size);
                ptm.setInt(5, stock);
                ptm.setString(6, description);
                ptm.setString(7, images);
                ptm.setString(8, color);
                ptm.setString(9, date);
                ptm.setDouble(10, discount);
                ptm.setInt(11, 0);
                ptm.setDouble(12, price);
                ptm.setInt(13, 1);
                ptm.setInt(14, tId);
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

    public Product getProductByID(int id) {
        Product product = null;
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            if (con != null) {
                ptm = con.prepareStatement("SELECT * FROM Products WHERE id = ? AND status = 1");
                ptm.setInt(1, id);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    CategoryDAO cDao = new CategoryDAO();
                    SupplierDAO sDao = new SupplierDAO();
                    TypeDAO tDao = new TypeDAO();
                    String productname = rs.getString("productname");
                    Supplier supplier = sDao.getSupplierById(rs.getInt("supplierid"));
                    Category category = cDao.getCategoryById(rs.getInt("categoryid"));
                    Type type = tDao.getTypeById(rs.getInt("typeid"));
                    int stock = rs.getInt("stock");
                    String description = rs.getString("description");
                    Date date = rs.getDate("releasedate");
                    double discount = rs.getDouble("discount");
                    int unitSold = rs.getInt("unitSold");
                    double price = rs.getDouble("price");
                    boolean status = rs.getBoolean("status");
                    String colors[] = rs.getString("colors").split(",");
                    String images[] = rs.getString("images").split(" ");
                    String sizes[] = rs.getString("size").split(",");
                    product = new Product(id, productname, description, stock, unitSold, images, colors, sizes, date, discount, price, status, category, supplier, type);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;

    }

    public List<Product> getProductByTypeId(int typeId) {
        List<Product> products = new ArrayList<>();
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            if (con != null) {
                ptm = con.prepareStatement("SELECT * FROM Products WHERE typeid = ? AND status = 1");
                ptm.setInt(1, typeId);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    CategoryDAO cDao = new CategoryDAO();
                    SupplierDAO sDao = new SupplierDAO();
                    TypeDAO tDao = new TypeDAO();
                    String productname = rs.getString("productname");
                    Supplier supplier = sDao.getSupplierById(rs.getInt("supplierid"));
                    Category category = cDao.getCategoryById(rs.getInt("categoryid"));
                    Type type = tDao.getTypeById(typeId);
                    int id = rs.getInt("id");
                    int stock = rs.getInt("stock");
                    String description = rs.getString("description");
                    Date date = rs.getDate("releasedate");
                    double discount = rs.getDouble("discount");
                    int unitSold = rs.getInt("unitSold");
                    double price = rs.getDouble("price");
                    boolean status = rs.getBoolean("status");
                    String colors[] = rs.getString("colors").split(",");
                    String images[] = rs.getString("images").split(" ");
                    String sizes[] = rs.getString("size").split(",");
                    Product product = new Product(id, productname, description, stock, unitSold, images, colors, sizes, date, discount, price, status, category, supplier, type);
                    products.add(product);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;

    }

    public List<Product> getProductByCategoryId(List<Product> list, int categoryid) {
        if (categoryid == 0) {
            return list;
        }
        List<Product> rs = new ArrayList<>();
        for (Product product : list) {
            if (product.getCategory().getId() == categoryid) {
                rs.add(product);
            }
        }
        return rs;

    }

    public List<Product> getProductSupplierId(int supplierid) {
        List<Product> products = new ArrayList<>();
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            if (con != null) {
                ptm = con.prepareStatement("SELECT * FROM Products WHERE supplierid = ? AND status = 1");
                ptm.setInt(1, supplierid);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    CategoryDAO cDao = new CategoryDAO();
                    SupplierDAO sDao = new SupplierDAO();
                    TypeDAO tDao = new TypeDAO();
                    String productname = rs.getString("productname");
                    Supplier supplier = sDao.getSupplierById(supplierid);
                    Category category = cDao.getCategoryById(rs.getInt("categoryid"));
                    int id = rs.getInt("id");
                    Type type = tDao.getTypeById(rs.getInt("typeid"));
                    int stock = rs.getInt("stock");
                    String description = rs.getString("description");
                    Date date = rs.getDate("releasedate");
                    double discount = rs.getDouble("discount");
                    int unitSold = rs.getInt("unitSold");
                    boolean status = rs.getBoolean("status");
                    double price = rs.getDouble("price");
                    String colors[] = rs.getString("colors").split(",");
                    String images[] = rs.getString("images").split(" ");
                    String sizes[] = rs.getString("size").split(",");
                    Product product = new Product(id, productname, description, stock, unitSold, images, colors, sizes, date, discount, price, status, category, supplier, type);
                    products.add(product);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;

    }

    public int getTotalProducts() throws SQLException {
        int result = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT COUNT(*) AS Total FROM Products WHERE status = 1");
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

    public int getQuantitySold() throws SQLException {
        int result = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT SUM(unitSold) AS Total from Products");
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

    public int getStock(int id) throws SQLException {
        int result = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT stock AS Total FROM Products WHERE id = ?");
                ptm.setInt(1, id);
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

    public int getProductsLowQuantity() throws SQLException {
        int result = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT COUNT(*) AS Total from Products WHERE Stock < 10 AND status = 1");
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

    public List<Product> getListByPage(List<Product> list, int start, int end) {
        ArrayList<Product> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    public List<Product> getProductNew() throws SQLException {
        List<Product> products = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT * from Products WHERE year(releasedate) = 2024 AND status = 1");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    CategoryDAO cDao = new CategoryDAO();
                    SupplierDAO sDao = new SupplierDAO();
                    TypeDAO tDao = new TypeDAO();
                    String productname = rs.getString("productname");
                    int id = rs.getInt("id");
                    Supplier supplier = sDao.getSupplierById(rs.getInt("supplierid"));
                    Category category = cDao.getCategoryById(rs.getInt("categoryid"));
                    Type type = tDao.getTypeById(rs.getInt("typeid"));
                    int stock = rs.getInt("stock");
                    String description = rs.getString("description");
                    Date date = rs.getDate("releasedate");
                    double discount = rs.getDouble("discount");
                    int unitSold = rs.getInt("unitSold");
                    double price = rs.getDouble("price");
                    boolean status = rs.getBoolean("status");
                    String colors[] = rs.getString("colors").split(",");
                    String images[] = rs.getString("images").split(" ");
                    String sizes[] = rs.getString("size").split(",");
                    Product product = new Product(id, productname, description, stock, unitSold, images, colors, sizes, date, discount, price, status, category, supplier, type);
                    products.add(product);
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
        return products;
    }

    public List<Product> getProductsBestSeller() throws SQLException {
        List<Product> products = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT TOP(5) * from Products WHERE status = 1 order by unitSold desc");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    CategoryDAO cDao = new CategoryDAO();
                    SupplierDAO sDao = new SupplierDAO();
                    TypeDAO tDao = new TypeDAO();
                    String productname = rs.getString("productname");
                    int id = rs.getInt("id");
                    Supplier supplier = sDao.getSupplierById(rs.getInt("supplierid"));
                    Category category = cDao.getCategoryById(rs.getInt("categoryid"));
                    Type type = tDao.getTypeById(rs.getInt("typeid"));
                    int stock = rs.getInt("stock");
                    String description = rs.getString("description");
                    Date date = rs.getDate("releasedate");
                    double discount = rs.getDouble("discount");
                    int unitSold = rs.getInt("unitSold");
                    double price = rs.getDouble("price");
                    boolean status = rs.getBoolean("status");
                    String colors[] = rs.getString("colors").split(",");
                    String images[] = rs.getString("images").split(" ");
                    String sizes[] = rs.getString("size").split(",");
                    Product product = new Product(id, productname, description, stock, unitSold, images, colors, sizes, date, discount, price, status, category, supplier, type);
                    products.add(product);
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
        return products;
    }

    public List<Product> getProductBySearch(String txtSearch) throws SQLException {
        List<Product> products = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT * FROM Products WHERE productname LIKE ? AND status = 1");
                ptm.setString(1, "%" + txtSearch + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    CategoryDAO cDao = new CategoryDAO();
                    SupplierDAO sDao = new SupplierDAO();
                    TypeDAO tDao = new TypeDAO();
                    String productname = rs.getString("productname");
                    int id = rs.getInt("id");
                    Supplier supplier = sDao.getSupplierById(rs.getInt("supplierid"));
                    Category category = cDao.getCategoryById(rs.getInt("categoryid"));
                    Type type = tDao.getTypeById(rs.getInt("typeid"));
                    int stock = rs.getInt("stock");
                    String description = rs.getString("description");
                    Date date = rs.getDate("releasedate");
                    double discount = rs.getDouble("discount");
                    int unitSold = rs.getInt("unitSold");
                    double price = rs.getDouble("price");
                    boolean status = rs.getBoolean("status");
                    String colors[] = rs.getString("colors").split(",");
                    String images[] = rs.getString("images").split(" ");
                    String sizes[] = rs.getString("size").split(",");
                    Product product = new Product(id, productname, description, stock, unitSold, images, colors, sizes, date, discount, price, status, category, supplier, type);
                    products.add(product);
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
        return products;
    }

    public List<Product> sortProduct(List<Product> list, String value) throws SQLException {
        List<Product> result = new ArrayList<>(list);
        if (value.equals("1")) {
            Collections.sort(result, (Product s1, Product s2) -> {
                return Double.compare(s1.getSalePrice(), s2.getSalePrice());
            });
        } else if (value.equals("2")) {
            Collections.sort(result, (Product s1, Product s2) -> {
                return -(Double.compare(s1.getSalePrice(), s2.getSalePrice()));
            });
        } else if (value.equals("3")) {
            Collections.sort(result, (Product s1, Product s2) -> {
                return s1.getName().compareTo(s2.getName());
            });
        }
        return result;
    }

    public void editProduct(int id, String name, String description, int stock, String image,
            String color, String size, String releasedate, double discount, double price, int categoryId, int supplierId, int typeId) {
        String sql = """
                     UPDATE [dbo].[Products]
                        SET [productname] = ?
                        ,[supplierid] = ?
                           ,[categoryid] = ?
                           ,[size]=? 
                           ,[stock] =? 
                           ,[description] =? 
                     """;
        if (!(image.equals(""))) {
            sql += "      ,[images] =? \n";
        }
        sql += """
                     ,[colors] =? 
                     ,[releasedate] =? 
                     ,[discount] =? 
                     ,[price] =? 
                     ,[typeid] =? 
                WHERE [id]=?""";
        try {
            Connection conn = null;
            PreparedStatement ptm = null;
            ResultSet rs = null;
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(sql);
                ptm.setString(1, name);
                ptm.setInt(2, supplierId);
                ptm.setInt(3, categoryId);
                ptm.setString(4, size);
                ptm.setInt(5, stock);
                ptm.setString(6, description);
                if (!image.equals("")) {
                    ptm.setString(7, image);
                    ptm.setString(8, color);
                    ptm.setString(9, releasedate);
                    ptm.setDouble(10, discount);
                    ptm.setDouble(11, price);
                    ptm.setInt(12, typeId);
                    ptm.setInt(13, id);
                    ptm.executeUpdate();
                    return;
                } else {
                    ptm.setString(7, color);
                    ptm.setString(8, releasedate);
                    ptm.setDouble(9, discount);
                    ptm.setDouble(10, price);
                    ptm.setInt(11, typeId);
                    ptm.setInt(12, id);
                    ptm.executeUpdate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    
     */
    public void deleteProduct(String pid) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("UPDATE Products SET status = 0 WHERE id = ?");
                ptm.setString(1, pid);
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

    /*
    1.cap nhat so luong san pham co trong kho chua
    2. muc dich dung de cho ben nguoi ban 
     */
    public void updateQuanityProduct(CartItem item) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("UPDATE Products SET [stock] = ? WHERE id = ?");
                ptm.setInt(1, (item.getProduct().getStock() - item.getQuantity()));
                ptm.setInt(2, item.getProduct().getId());
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

    public List<Product> searchByPrice(List<Product> list, double priceFrom, double priceTo) {
        List<Product> rs = new ArrayList<>();
        for (Product product : list) {
            if (priceFrom != 0) {
                if (priceTo != 0) {
                    if (product.getSalePrice() >= priceFrom && product.getSalePrice() <= priceTo) {
                        rs.add(product);
                    }
                } else if (product.getSalePrice() >= priceFrom) {
                    rs.add(product);
                }
            }
        }
        return rs;
    }

    public List<Product> searchByDiscount(List<Product> list, double discount) {
        List<Product> rs = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getDiscount() > discount) {
                rs.add(list.get(i));
            }
        }
        return rs;
    }

    public List<Product> searchByCheckBox(List<Product> list, int[] cid) throws Exception {

        List<Product> result = new ArrayList<>();

        if (cid[0] == 0) {
            return list;
        }

        for (Product product : list) {
            for (int i = 0; i < cid.length; i++) {
                if (product.getCategory().getId() == cid[i]) {
                    result.add(product);
                }
            }
        }

        return result;
    }

     public List<Product> getProductByCategoryId2(int categoryId) throws SQLException {
        List<Product> products = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT * FROM Products WHERE categoryid= ? and status = 1");
                ptm.setInt(1, categoryId);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    CategoryDAO cDao = new CategoryDAO();
                    SupplierDAO sDao = new SupplierDAO();
                    TypeDAO tDao = new TypeDAO();
                    String productname = rs.getString("productname");
                    int id = rs.getInt("id");
                    Supplier supplier = sDao.getSupplierById(rs.getInt("supplierid"));
                    Category category = cDao.getCategoryById(rs.getInt("categoryid"));
                    Type type = tDao.getTypeById(rs.getInt("typeid"));
                    int stock = rs.getInt("stock");
                    String description = rs.getString("description");
                    Date date = rs.getDate("releasedate");
                    double discount = rs.getDouble("discount");
                    int unitSold = rs.getInt("unitSold");
                    double price = rs.getDouble("price");
                    boolean status = rs.getBoolean("status");
                    String colors[] = rs.getString("colors").split(",");
                    String images[] = rs.getString("images").split(" ");
                    String sizes[] = rs.getString("size").split(",");
                    Product product = new Product(id, productname, description, stock, unitSold, images, colors, sizes, date, discount, price, status, category, supplier, type);
                    products.add(product);
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
        return products;
    }
    
    public static void main(String[] args) throws SQLException {
        ProductDAO dao = new ProductDAO();
        List<Product> plist = dao.getProductBySearch("quần");
        for(int i = 0;i<=plist.size()-1;i++){
            System.out.println(plist.get(i).getName());
        }
       

    }
}
