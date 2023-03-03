package com.wyl.interfaceAndAbstractClass;

/**
 * @auther yanl.wang
 * @date 2023/1/5
 **/
public interface TestInterface {
    //不能有私有和保护的成员变量
    String str = "111";
    public String str1 = "222";
    public static final String str2 = "333";

    //不能有方法体,不能有静态方法
    void test1();
    public void test2();
    public abstract void test3();

}
