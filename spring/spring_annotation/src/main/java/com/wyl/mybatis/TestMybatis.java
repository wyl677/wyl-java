package com.wyl.mybatis;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @auther yanl.wang
 * @date 2023/3/7
 **/
public class TestMybatis {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MybatisConfiguration.class);
        UserDao userDao = (UserDao) context.getBean("userDao");

        User user = new User();
        user.setId(8111);
        user.setUsername("qw111e1");
        userDao.save(user);
    }
}
