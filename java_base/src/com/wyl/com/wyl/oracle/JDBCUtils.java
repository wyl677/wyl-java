package com.wyl.com.wyl.oracle;

import java.sql.*;

/**
 * Author:yanl.wang
 * Date:2022/8/21 16:59
 */
public class JDBCUtils {


    private static String driver = "oracle.jdbc.OracleDriver";
    private static String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
    private static String user = "sunds";
    private static String password = "sunds";

    //注册数据库驱动
    static{
        try {
            Class.forName(driver);
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 释放数据库连接资源
     * @param conn
     * @param st
     * @param rs
     */
    public static void release(Connection conn, Statement st, ResultSet rs){
        if (rs!=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                rs = null;
            }
        }

        if (st!=null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                st = null;
            }
        }

        if (conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                conn = null;
            }
        }
    }
}
