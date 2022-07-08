package com.cxk.test;


import com.cxk.demo.DemoUpdate;
import com.cxk.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import static com.cxk.util.Conn.getConn;

public class Test_Update {

    public static void main(String[] args) {
        DemoUpdate demoUpdate = new DemoUpdate();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要修改的ID");
        String edit_id = scanner.next();
        System.out.println("请输入新的ID");
        String id = scanner.next();
        System.out.println("请输入新的name");
        String name = scanner.next();
        User user = new User(id, name);
        demoUpdate.update_one(user, edit_id);
    }

}
