package com.wyl.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @auther yanl.wang
 * @date 2023/2/15
 * 普通非框架类项目使用德鲁伊连接池
 **/
public class DBConfig {


    private static Logger logger = LoggerFactory.getLogger(DBConfig.class);
    //声明连接池对象
    private static DataSource dataSource;

    //使用静态，是类加载的时候就创建连接池
    static {
        try {
            //读取配置文件
            String parent = new File(java.net.URLDecoder.decode(String.valueOf(DBConfig.class.getProtectionDomain().getCodeSource().getLocation()), "UTF-8")).getParent();
            parent = parent.substring(5);
            parent = parent  + File.separator + "application-config.properties";
            InputStream inputStream = new FileInputStream(new File(parent));
            //获取Properties对象，加载到该对象中
            Properties properties = new Properties();
            //获取配置文件
            properties.load(inputStream);
            //创建druid工厂
            dataSource = DruidDataSourceFactory.createDataSource(properties);
            logger.info("DBConfig|数据库连接成功，连接对象：" + dataSource);
        }catch (Exception e){
            logger.info("DBConfig|数据库连接失败：" + e.getMessage() );
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * 关闭连接
     * @param connection
     * @param statement
     * @param resultSet
     */
    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            logger.info("DBConfig|关闭数据库异常：" + e.getMessage());
            e.printStackTrace();
        }
    }
}
