package com.wyl.dynamic;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @auther yanl.wang
 * @date 2023/2/8
 **/
public class Around implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("---------调用原始方法执行之前的代码----------");
        Object ret = null;
        try {
             ret = invocation.proceed();
        }catch (Exception e){
            System.out.println("异常时执行");
            e.printStackTrace();
        }
        return ret;
    }
}
