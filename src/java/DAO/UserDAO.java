 package DAO;

import utils.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author thanhhuynh
 */
public class UserDAO extends DBContext {

    // lay toan bo du lieu cua nguoi dung tu database 
    public List<User> getData() throws SQLException {
        List<User> users = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT * FROM Users WHERE status = 1 Order by roleid asc");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    String email = rs.getString("email");
                    String avatar = rs.getString("avatar");
                    String userName = rs.getString("userName");
                    String password = rs.getString("password");
                    String address = rs.getString("address");
                    String phone = rs.getString("phone");
                    int roleId = rs.getInt("roleId");
                    boolean status = rs.getBoolean("status");
                    users.add(new User(id, firstName, lastName, email, avatar, userName, password, address, phone, roleId, status));
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
        return users;
    }

    /*  xac thuc thong tin dang nhap cua nguoi dung 
    // tra ve 1 user neu tim thay
     tra ve null neu khong tim thay*/
    public User checkLogin(String userName, String password) throws SQLException {
        User user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT * FROM Users WHERE (username=? OR email = ?) AND password=? and status=1");
                ptm.setString(1, userName);
                ptm.setString(2, userName);
                ptm.setString(3, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String firstname = rs.getString("firstname");
                    String lastname = rs.getString("lastname");
                    String email = rs.getString("email");
                    String userNamee = rs.getString("userName");
                    String avatar = rs.getString("avatar");
                    String address = rs.getString("address");
                    String phone = rs.getString("phone");
                    int roleid = rs.getInt("roleID");
                    boolean roleID = rs.getBoolean("roleID");
                    user = new User(id, firstname, lastname, email, avatar, userNamee, password, address, phone, roleid, roleID);
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
        return user;
    }
// lay ra tong user hien co trong database
    // dung cho phan admin sau nay

    public int getTotalUsers() throws SQLException {
        int result = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT COUNT(*) AS Total FROM Users WHERE status = 1 AND roleid=2");
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

    /*
    1.cap nhat thong tin cua nguoi dung vao database
    2. dung cho phan "EDIT my Profile"
    3. dung cho phan admin de chinh sua thong tin hoac ban 
     */
    public void updateUser(String firstName, String lastName, String email, String address, String phone, String userName, String avatar, int roleId) throws SQLException {
        User user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("UPDATE Users SET firstName = ?, lastName = ?, email = ?, address = ?, phone = ?, avatar = ?, roleid = ? WHERE username = ?");
                ptm.setString(1, firstName);
                ptm.setString(2, lastName);
                ptm.setString(3, email);
                ptm.setString(4, address);
                ptm.setString(5, phone);
                ptm.setString(6, avatar);
                ptm.setInt(7, roleId);
                ptm.setString(8, userName);
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
    dung de chinh sua password trong truong hop nguoi dung quen may pass
    va yeu cau reset ==> forgot pass
     */
    public boolean updatePasswordUser(User user, String pass) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("UPDATE Users SET password = ? WHERE username = ?");
                ptm.setString(1, pass);
                ptm.setString(2, user.getUserName());
                ptm.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
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

    /*
    lay thong tin cua nguoi dung thong qua ten 
    truy xuat ten tim thay don hang cua nguoi dung
    lien lac thong qua sdt....
     */
    public User getUserByName(String userName) throws SQLException {
        User user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT * FROM Users WHERE username = ? AND status = 1");
                ptm.setString(1, userName);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String firstname = rs.getString("firstname");
                    String lastname = rs.getString("lastname");
                    String email = rs.getString("email");
                    String avatar = rs.getString("avatar");
                    String address = rs.getString("address");
                    String password = rs.getString("password");
                    String phone = rs.getString("phone");
                    int roleid = rs.getInt("roleID");
                    boolean roleID = rs.getBoolean("roleID");
                    user = new User(id, firstname, lastname, email, avatar, userName, password, address, phone, roleid, roleID);
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
        return user;
    }

    /*
  forgot pass ==> lay ra nguoi dung tu email cua ho 
    roi doi pass
     */
    public User getUserByEmail(String email) throws SQLException {
        User user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT * FROM Users WHERE email = ? AND status = 1");
                ptm.setString(1, email);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String firstname = rs.getString("firstname");
                    String userName = rs.getString("userName");
                    String lastname = rs.getString("lastname");
                    String avatar = rs.getString("avatar");
                    String address = rs.getString("address");
                    String password = rs.getString("password");
                    String phone = rs.getString("phone");
                    int roleid = rs.getInt("roleID");
                    boolean status = rs.getBoolean("status");
                    user = new User(id, firstname, lastname, email, avatar, userName, password, address, phone, roleid, status);
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
        return user;
    }

    /*
    kiem tra username cua nguoi dung co bi trung lap voi ai khac khong
    nham tranh truong hop nguoi dung tao tai khoan da ton tai username
     */
    public boolean checkUserNameDuplicate(String username) throws SQLException {
        boolean ok = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT * FROM Users WHERE userName = ? or email = ? and [status] = 1");
                ptm.setString(1, username);
                ptm.setString(2, username);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    ok = true;
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
        return ok;
    }

    /*
    tao 1 tai khoan moi. Het
     */
    public void registerUser(User user) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("""
                                                INSERT INTO [dbo].[Users]
                                                           ([firstname]
                                                           ,[lastname]
                                                           ,[email]
                                                           ,[avatar]
                                                           ,[username]
                                                           ,[password]
                                                           ,[address]
                                                           ,[phone]
                                                           ,[roleid]
                                                           ,[status])
                                                     VALUES
                                                           (?,?,?,?,?,?,?,?,?,?)""");
                ptm.setString(1, user.getFirstName());
                ptm.setString(2, user.getLastName());
                ptm.setString(3, user.getEmail());
                ptm.setString(4, user.getAvatar());
                ptm.setString(5, user.getUserName());
                ptm.setString(6, user.getPassword());
                ptm.setString(7, user.getAddress());
                ptm.setString(8, user.getPhone());
                ptm.setInt(9, user.getRoleID());
                ptm.setBoolean(10, user.isStatus());
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
    truong hop nguoi dung vi pham chinh sach se bi xoa ra khoi database
    ban tai khoan, du dinh phat trien tinh nang nguoi dung muon xoa tai khoan
     */
    public void deleteUser(String uid) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("UPDATE Users SET status = 0 WHERE id = ?");
                ptm.setString(1, uid);
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

}
