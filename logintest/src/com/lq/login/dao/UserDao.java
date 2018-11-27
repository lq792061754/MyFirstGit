package com.lq.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lq.login.exception.DBException;
import com.lq.login.po.User;
import com.lq.login.util.DBUtil;

public class UserDao {
    public User getUserByName(String userName) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;
            try {
                conn = DBUtil.getConnection();
                //3.准备PreparedStatement对象
                stmt =  conn.prepareStatement("SELECT id, user_name, password FROM user WHERE user_name = ?");
                stmt.setString(1, userName);
                //4.得到数据并处理
                rs = stmt.executeQuery();
                if (rs.next()) {
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUserName(rs.getString("user_name"));
                    user.setPassword(rs.getString("password"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new DBException();
            } finally {
                DBUtil.close(rs, stmt, conn);
            }
        return user;
    }

}
