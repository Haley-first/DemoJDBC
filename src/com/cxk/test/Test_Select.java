package com.cxk.test;

import com.cxk.demo.DemoSelect;
import com.cxk.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.cxk.util.Conn.getConn;

public class Test_Select {

    public static void main(String[] args) {
        DemoSelect demoSelect = new DemoSelect();

        // 查询全部记录
        List<User> userList = demoSelect.select_all();  //查询全部记录
        System.out.println("==================================");
        System.out.print("Id" + "\t");
        System.out.println("名称");
        for (User user : userList) {    // 遍历list
            System.out.print(user.getId()+ "\t");
            System.out.println(user.getName());
        }
        System.out.println("==================================");


        // 查询单条记录
        Scanner scanner=new Scanner(System.in); //创建一个Scanner对象从控制台获取数据
        System.out.println("请输入id: ");  //提示信息
        String id = scanner.next(); // 获取控制台输入的ID
        User user = demoSelect.select_one(id);  //查询全部记录
        String user_string  = user.toString();  //调取实体类toString方法
        System.out.println(user_string);    // 输出信息
    }

}
