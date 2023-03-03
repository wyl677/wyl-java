package com.wyl.com.wyl.oracle;

import oracle.jdbc.internal.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;
import org.junit.Test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Author:yanl.wang
 * Date:2022/8/21 17:13
 */
public class CursorTest {


    /**
     * create or replace package Mypackage as
     procedure queryUserList(uid in number,userList out usercursor);
     end mypackage;
     */
    @Test
    public void testCursor(){
        String sql = "{call Mypackage.queryUserList(?,?) }";

        Connection conn = null;
        CallableStatement call = null;
        ResultSet rs = null;
        try {
            //得到数据库连接
            conn = JDBCUtils.getConnection();
            //通过数据库连接创建statement
            call = conn.prepareCall(sql);

            //对于输入参数，赋值
            call.setInt(1, 1);
            //对于输出参数，声明
            call.registerOutParameter(2, OracleTypes.CURSOR);
            //执行调用
            call.execute();
            //将CallableStatement 强转成  OracleCallableStatement 用来获取光标类型Cursor，并得到结果ResultSet
            rs = ((OracleCallableStatement)call).getCursor(2);
            //遍历 ResultSet
            while (rs.next()) {
                //根据类型和列名取值
                int id = rs.getInt("user_id");    //括号内为 列名
                String user_name = rs.getString("user_name");
                int age = rs.getInt("user_age");
                String sex = rs.getString("user_sex");
                System.out.println("查询到的用户信息：\n\tid:"+id+"\n\t姓名："+user_name
                        +"\n\t年龄："+age+"\n\t性别："+sex);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.release(conn, call, rs);
        }
    }

}
