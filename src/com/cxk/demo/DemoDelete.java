package com.cxk.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static com.cxk.util.Conn.getConn;

public class DemoDelete {

    // 根据主键单条删除
    public int delete_one(String id) {
        Connection conn = getConn();  // 获取数据库连接
        int i = 0;  // 受影响行数
        String sql = "delete from user where Id='" + id + "'";  // sql语句
        PreparedStatement pstmt;   // 创建一个PreparedStatement用来构建sql
        try {
            pstmt = conn.prepareStatement(sql); // 预编译sql
            i = pstmt.executeUpdate();  // 执行sql
            pstmt.close();  // 清空预编译的sql
            conn.close();   // 关闭数据库资源
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("成功删除"+ i + "条数据");
        return i;
    }

    // 根据数据多条删除
    public int delete_many(List<String> stringList) {
        // 将String集合转化为以逗号分隔的字符串,满足sql语句的格式
        StringBuffer stringBuffer = new StringBuffer();
        stringList.stream().forEach(str->{
            stringBuffer.append(str).append(",");
        });
        stringBuffer.deleteCharAt(stringBuffer.length()-1);
        String str_in = stringBuffer.toString();

        Connection conn = getConn();  // 获取数据库连接
        int i = 0;  // 受影响行数
        String sql = "delete from user where id in (" + str_in + ")";  // sql语句
        PreparedStatement pstmt;   // 创建一个PreparedStatement用来构建sql
        try {
            pstmt = conn.prepareStatement(sql); // 预编译sql
            i = pstmt.executeUpdate();  // 执行sql
            pstmt.close();  // 清空预编译的sql
            conn.close();   // 关闭数据库资源
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("成功删除"+ i + "条数据");
        return i;
    }
}
