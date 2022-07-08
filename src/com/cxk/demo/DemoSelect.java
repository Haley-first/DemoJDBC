package com.cxk.demo;

import com.cxk.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.cxk.util.Conn.getConn;

public class DemoSelect {
    // 查询全部记录
    public List<User> select_all() {
        Connection conn = getConn();    // 创建连接
        String sql = "select * from user";  //查询的sql语句
        PreparedStatement pstmt;    // 创建一个PreparedStatement用来构建sql
        List<User> userList = new ArrayList<>();    //创建一个User集合,用来储存查询结果
        try {
            pstmt = conn.prepareStatement(sql); // 使用PreparedStatement对象来构建SQL语句
            ResultSet rs = pstmt.executeQuery();    // 使用 preStmt 执行 SQL 语句
            while (rs.next()) { // 循环赋值
                User user = new User(rs.getString("id"), rs.getString("name"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    // 查询单条记录
    public User select_one(String id){
        Connection conn = getConn();  // 创建连接
        String sql = "select * from user where id='" + id + "'";    //拼接where查询条件
        PreparedStatement pstmt;    // 创建一个PreparedStatement用来构建sql
        User user = new User(); //创建一个User对象
        try {
            pstmt = conn.prepareStatement(sql); // 使用PreparedStatement对象来构建SQL语句
            ResultSet rs = pstmt.executeQuery();    // 使用 preStmt 执行 SQL 语句
            while (rs.next()) {
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
            }
            pstmt.close();  // 清空预编译的sql
            conn.close();   // 关闭数据库资源
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}
