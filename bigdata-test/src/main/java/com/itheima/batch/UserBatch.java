package com.itheima.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class UserBatch {
    public static void main(String[] args) throws Exception {


        insert(10);
        insert(100);
        //insert(1000);

    }
    private static void insert(int num) throws SQLException {
        long start = System.currentTimeMillis();
        Connection connection = getConnection();


        PreparedStatement ps = connection.prepareStatement("insert into user_"+num+" values (null,?,?,?,?,?)");
        for (int i=1;i<=num*10000;i++){
            ps.setString(1,PhoneNumberGenerator.generate());
            ps.setString(2,UUIDUtil.generate());
            ps.setString(3,ChineseNameGenerator.generate());
            ps.setString(4,EmailGenerator.generate());
            ps.setInt(5,AgeGenerator.generate());
            ps.addBatch();
            if (i*1.0%10000==0){
                System.out.println("第"+i+"次...");
                ps.executeBatch();
                ps.clearBatch();
            }
        }
        connection.close();
        long end = System.currentTimeMillis();
        System.out.println("插入"+num+"万条数据花费了:"+(end-start)+"毫秒");
    }


    private static Connection getConnection() throws SQLException {
        String username="root";
        String password="123456";
        String url="jdbc:mysql://localhost:3306/bigdata?characterEncoding=utf8&useServerPrepStmts=true&cachePrepStmts=true&rewriteBatchedStatements=true";
        return DriverManager.getConnection(url,username,password);

    }

}
