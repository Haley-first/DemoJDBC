package com.cxk.test;

import com.cxk.demo.DemoInsert;
import com.cxk.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test_Insert {
    public static void main(String[] args) {
        DemoInsert demoInsert = new DemoInsert();
        Scanner scanner = new Scanner(System.in);

        // 插入单条数据
        System.out.println("请输入ID");
        String id = scanner.next();
        System.out.println("请输入name");
        String name = scanner.next();
        User user = new User(id,name);
        demoInsert.insert_one(user);

        // 插入多条数据
        String s = "Y";
        List<User> userList = new ArrayList<>();
        while (s.equalsIgnoreCase("y")){
            System.out.println("请输入ID");
            String id2 = scanner.next();
            System.out.println("请输入name");
            String name2 = scanner.next();
            User user2 = new User(id2, name2);
            userList.add(user2);
            System.out.println("是否继续输入? (请输入 Y or N)");
            s = scanner.next();
        }
        demoInsert.insert_many(userList);
    }

}
