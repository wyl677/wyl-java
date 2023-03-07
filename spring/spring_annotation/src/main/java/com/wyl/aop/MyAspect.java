package com.wyl.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * @auther yanl.wang
 * @date 2023/3/7
 **/
@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(* com.wyl.aop..*.*(..))")  //@Pointcut("execution(* com.wyl.aop..*.*(..))")
    public void pointCut(){}

    @Around(value = "pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("----log before---");
        Object ret = joinPoint.proceed();
        System.out.println("-----log after----");
        return ret;
    }
}
