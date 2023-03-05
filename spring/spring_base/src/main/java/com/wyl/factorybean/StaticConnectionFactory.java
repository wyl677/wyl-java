package com.wyl.factorybean;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @auther yanl.wang
 * @date 2023/2/7
 * 静态工厂创建复杂对象  整合遗留代码
 **/
public class StaticConnectionFactory {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.83.2:3306/sunds", "root", "123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
