package com.cxk.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
    public static Connection getConn() {
        String driver = "com.mysql.cj.jdbc.Driver";
        // 数据库地址
        String url = "jdbc:mysql://localhost:3306/test02?serverTimezone=GMT"; //serverTimezone 设置时区
        String username = "root";   //数据库用户名
        String password = "123456"; //数据库密码
        Connection conn = null; // 首先创建一个空连接
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);   //获取连接
        } catch (ClassNotFoundException e) {
            e.printStackTrace();    // jar包未找到
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
