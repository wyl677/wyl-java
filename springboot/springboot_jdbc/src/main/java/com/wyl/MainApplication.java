package com.wyl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @auther yanl.wang
 * @date 2023/3/1
 * SpringBoot操作数据库
 *  1.引入相关场景
 *      spring-boot-starter-data-jdbc 操作数据库场景
 *      spring-boot-starter-test 测试场景使用(测试类标@SpringBootTest注解，目录结构要和主程序类一个层级)
 *  2.配置文件
 *      数据源相关配置
 **/
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class);
    }
}
