package com.cxk.test;

import com.cxk.demo.DemoDelete;
import com.cxk.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.cxk.util.Conn.getConn;

public class Test_Delete {
    public static void main(String[] args) {
        DemoDelete demoDelete = new DemoDelete();
        Scanner scanner = new Scanner(System.in);
        // 删除一条
        System.out.println(" 请输入要删除的ID");
        String id = scanner.next();
        demoDelete.delete_one(id);

        // 删除多条(以集合形式传参删除)
        List<String> stringList = new ArrayList<>();
        String s = "y";
        while (s.equalsIgnoreCase("y")){
            System.out.println(" 请输入要删除的ID");
            String id2 = scanner.next();
            stringList.add(id2);
            System.out.println("是否继续输入? (请输入 Y or N)");
            s = scanner.next();
        }
        demoDelete.delete_many(stringList);
    }
}
