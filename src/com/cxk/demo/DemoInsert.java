package com.cxk.demo;

import com.cxk.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static com.cxk.util.Conn.getConn;

public class DemoInsert {
    // 单条数据插入
    public int insert_one(User user) {
        Connection conn = getConn();    // 创建数据库连接
        int i = 0;  // sql执行受影响行数
        String sql = "insert into user (Id,Name) values(?,?)";  // sql语句
        PreparedStatement pstmt; // 创建一个PreparedStatement用来构建sql
        try {
            pstmt = conn.prepareStatement(sql); // 构建sql
            pstmt.setString(1, user.getId());   // 在上面sql中问号位置设置值
            pstmt.setString(2, user.getName());
            i = pstmt.executeUpdate();  //  执行编译好的sql
            pstmt.close();  // 清空预编译的sql
            conn.close();   // 关闭数据库资源
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("成功插入"+ i + "条数据");
        return i;
    }

    // 多条数据插入
    public int insert_many(List<User> userList) {
        Connection conn = getConn();
        int[] i;
        int r = 0;
        String sql = "insert into user (Id,Name) values(?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
           for(User user: userList){    // 遍历userList,循环插入值
               pstmt.setString(1,user.getId());
               pstmt.setString(2,user.getName());
               pstmt.addBatch();    // 拼接sql
           }
           i = pstmt.executeBatch();    //批量执行,返回受影响数组
           r = i.length;   // 转换为行数
           pstmt.close();  // 清空预编译的sql
           conn.close();   // 关闭数据库资源
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("成功插入"+ r + "条数据");
        return r;
    }

}
