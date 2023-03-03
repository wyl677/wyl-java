package com.wyl.designpattern.singleton;

/**
 * @auther yanl.wang
 * @date 2023/1/7
 * 饿汉式（静态常量）
 *
 * 类加载到内存后，就实例化一个单例，
 * jvm保证线程安全  简单实用，推荐使用
 * 唯一缺点：不管用到与否，类装载时就完成实例化  Class.forName("") (话说你不用的，你装载它干啥)
 **/
public class Singleton1 {
    private final static Singleton1 INSTANCE = new Singleton1();

    private Singleton1(){}

    public static Singleton1 getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        Singleton1 instance = Singleton1.getInstance();
        Singleton1 instance2 = Singleton1.getInstance();
        System.out.println(instance==instance2);

    }
}
