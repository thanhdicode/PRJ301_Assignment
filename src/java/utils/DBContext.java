package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {

    public Connection getConnection() throws Exception {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        String url = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=ClothesShop";

        Connection con = DriverManager.getConnection(url, "SA1", "12345");
        return con;
    }
//     public static void main(String[] args) {
//        DBContext dbContext = new DBContext();
//        Connection connection = null;
//
//        try {
//            connection = dbContext.getConnection();
//            if (connection != null) {
//                System.out.println("Connection successful!");
//            } else {
//                System.out.println("Failed to make connection!");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
}
