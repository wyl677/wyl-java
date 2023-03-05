package com.wyl.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @auther yanl.wang
 * @date 2023/2/15
 * 1.额外功能
 *  public class Around implements MethodInterceptor {
 *      public Object invoke(MethodInvocation invocation) throws Throwable {
 *      Object ret = invocation.proceed();
 *      return ret;
 *      }
 *  }
 *
 *  2.切入点
 *  <aop:config>
 *         <aop:pointcut id="pc" expression="execution(* *(..))"/>
 *         <aop:advisor advice-ref="around" pointcut-ref="pc"></aop:advisor>
 *     </aop:config>
 **/
@Aspect //切面类
public class MyAspect {

    @Pointcut("execution(* *..UserServiceImpl.*(..))") //切入点提取，便于复用
    public void myPointcut(){}

    @Around(value = "myPointcut()") //相当于类继承了MethodInterceptor接口重写的 invoke方法。Object也代表原始方法的返回值,ProceedingJoinPoint相当于MethodInvocation
    public Object arround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("-------aspect log-------");
        Object ret = joinPoint.proceed();
        return ret;
    }

    @Around(value = "myPointcut()") //相当于类继承了MethodInterceptor接口重写的 invoke方法。Object也代表原始方法的返回值,ProceedingJoinPoint相当于MethodInvocation
    public Object arround1(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("-------aspect tx-------");
        Object ret = joinPoint.proceed();
        return ret;
    }
}
