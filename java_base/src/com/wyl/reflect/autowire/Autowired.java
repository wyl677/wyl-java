package com.wyl.reflect.autowire;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) //注解的保留位置
@Target(ElementType.FIELD) //注解的作用目标
@Inherited //说明子类可以继承父类中的该注解
@Documented //说明该注解将被包含在javadoc中（描述使用javadoc工具为类生成帮助文档时是否保留其注解信息 javadoc -d doc MyDocumentedTest.java）
/**
 * 注解其实就是代码里的特殊标记，它用于替代配置文件：传统方式通过配置文件告诉类如何运行，有了注解技术后，开发人员可以通过注解告诉类如何运行
 * 在Java技术里注解的典型应用是：可以通过反射技术得到类里面的注解，以觉得类怎么去运行。
 *
 * 注解可以标记在包、类、属性、方法，方法参数以及局部变量上，且同一个地方可以同时标记多个注解。
 *
 * 抑制编译器未指定泛型、未使用、过时警告
 * @SuppressWarnings({"rawtypes","unused","deprecation"})
 */
//自定义注解
@SuppressWarnings({"rawtypes"})
public @interface Autowired {

}
