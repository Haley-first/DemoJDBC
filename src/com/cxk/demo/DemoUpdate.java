package com.cxk.demo;


import com.cxk.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.cxk.util.Conn.getConn;

public class DemoUpdate {
    public int update_one(User user, String id) {
        Connection conn = getConn();    // 获取数据库连接
        int i = 0;  // 返回受影响行数
        String sql = "update  user set id=?, name = ? where id = '" + id + "'"; //sql语句
        PreparedStatement pstmt;    // 创建一个PreparedStatement用来构建sql
        try {
            pstmt = conn.prepareStatement(sql); // 构建sql,预编译sql
            pstmt.setString(1,user.getId());    // 传参
            pstmt.setString(2,user.getName());
            i = pstmt.executeUpdate();  // 执行sql
            pstmt.close();  // 清空预编译的sql
            conn.close();   // 关闭数据库资源
            System.out.println("成功修改"+ i +"行数据");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }


}
