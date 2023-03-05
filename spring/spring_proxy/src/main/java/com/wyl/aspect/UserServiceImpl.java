package com.wyl.aspect;

import com.wyl.proxy.User;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @auther yanl.wang
 * @date 2023/2/8
 * AOP开发中的一个坑
 *  在同一业务类中，进行业务方法间的互相调用，只有最外层的方法，才是加入了额外功能（内部的方法，通过普通的方式调用，都调用的是原始方法）。如果想让
 *  内层的方法也调用代理对象的方法，就要ApplicationContextAware获得工厂，进而获得代理对象。
 **/
public class UserServiceImpl implements UserService, ApplicationContextAware {

    private ApplicationContext context;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }


    @Override
    public boolean login(String name, String password) {
        System.out.println("UserServiceImpl.login");

        /**
         * 调用的是原始对象的register方法
         * ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext3.xml");
         * UserService userService = (UserService) context.getBean("userService");
         * userService.login("wyl","123456");
         * Spring工厂重量级资源，一个应用中 应该只创建一个工厂
         *
         */
        UserService userService = (UserService) context.getBean("userService");
        userService.register(new User());
        return true;
    }

    @Override
    public void register(User user) {
        System.out.println("UserServiceImpl.register");
    }



}
