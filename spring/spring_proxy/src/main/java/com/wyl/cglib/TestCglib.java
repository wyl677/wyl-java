package com.wyl.cglib;

import com.wyl.proxy.User;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @auther yanl.wang
 * @date 2023/2/9
 *
 * JDK动态代理和Cglib代理总结：
 *      JDK动态代理：Proxy.newProxyInstance(),通过接口创建代理类的实现类
 *      Cglib动态代理：Enhancer，通过继承父类创建代理类
 **/
public class TestCglib {
    public static void main(String[] args) {
        //1.创建原始对象
        UserService userService = new UserService();

        /**
         * 2.通过cglib方式创建动态代理对象
         * Enhancer.create()
         */

        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(TestCglib.class.getClassLoader());
        enhancer.setSuperclass(userService.getClass());

        MethodInterceptor interceptor = new MethodInterceptor() {
            /**
             * 等同于 InvocationHandler ---invoke
             * @param o
             * @param method
             * @param args
             * @param methodProxy
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("111:"+methodProxy.getSuperName());
                System.out.println("--------cglib log-------------");
                Object ret = method.invoke(userService, args);
                return ret;
            }
        };

        enhancer.setCallback(interceptor);
        UserService userServiceProxy = (UserService) enhancer.create();
        userServiceProxy.login("wyl","123456");
        userServiceProxy.register(new User());

    }
}
