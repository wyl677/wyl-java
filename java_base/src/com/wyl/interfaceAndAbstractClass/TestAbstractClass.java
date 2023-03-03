package com.wyl.interfaceAndAbstractClass;

/**
 * @auther yanl.wang
 * @date 2023/1/5
 **/
public abstract class TestAbstractClass {
    //可以有公共，保护，默认，私有的修饰成员变量
    String str = "111";
    public String str1 = "222";
    private String str2 = "333";
    protected String str3 = "444";

    //非抽象方法必须要有方法体
    void test1() {
        System.out.println("抽象类中非抽象方法必须要有方法体");
    }

    abstract void test2();

    //可以有静态方法
    static void test3() {
        System.out.println("方法体");
    }

    //可以有静态代码块
    static {};
}
