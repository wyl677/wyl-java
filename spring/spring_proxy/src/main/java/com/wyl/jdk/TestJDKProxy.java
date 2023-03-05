package com.wyl.jdk;

import com.wyl.proxy.User;
import com.wyl.proxy.UserService;
import com.wyl.proxy.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @auther yanl.wang
 * @date 2023/3/5
 * 通过接口创建代理类
 * <p>
 * 代理创建3要素
 * 1。原始对象
 * 2。额外功能
 * 3。代理对象和原始对象实现相同的接口
 **/
public class TestJDKProxy {


    public static void main(String[] args) {
        //1.创建原始对象
        UserService userService = new UserServiceImpl();

        //内部类实现接口的方式
        InvocationHandler handler = new InvocationHandler() {
            /**
             *
             * @param proxy 代理对象
             * @param method 原始对象的方法
             * @param args 原始对象方法的参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("------proxy log ------");
                //原始方法运行
                Object ret = method.invoke(userService, args);
                return ret;
            }
        };

        //2.JDK创建动态代理
        /**
         * ClassLoader:类加载器，动态代理类没有实际的.class文件，由类加载器加载代理类到jvm
         * interface:代理类和原始类共同实现的接口
         * InvocationHandler:额外功能书写
         */
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(TestJDKProxy.class.getClassLoader(), userService.getClass().getInterfaces(), handler);
        userServiceProxy.register(new User());
        System.out.println("==========================");
        userServiceProxy.login("wyl", "123456");
    }
}
