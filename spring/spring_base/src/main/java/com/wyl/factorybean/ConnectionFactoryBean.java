package com.wyl.factorybean;

import org.springframework.beans.factory.FactoryBean;

import javax.security.auth.login.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @auther yanl.wang
 * @date 2023/3/5
 **/
public class ConnectionFactoryBean implements FactoryBean<Connection> {
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Override
    public Connection getObject() throws Exception {
        Class.forName(driverClassName);
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    @Override
    public Class<?> getObjectType() {
        return Configuration.class;
    }

    /**
     * true:单例
     * @return
     */
    @Override
    public boolean isSingleton() {
        return false;
    }


    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
