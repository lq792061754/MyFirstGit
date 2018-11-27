package com.lq.login.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lq.login.exception.DBException;

public class DBUtil {

    public static Connection getConnection() {
        //1.加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2.得到connection对象
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "lq031310");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException();
        }
        return conn;
    }
    public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
      //5.关闭资源
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
