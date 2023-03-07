package com.wyl.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @auther yanl.wang
 * @date 2023/3/7
 **/
public class TestAOP {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userUservice = (UserService) context.getBean("userServiceImpl");
        userUservice.login();
    }
}
