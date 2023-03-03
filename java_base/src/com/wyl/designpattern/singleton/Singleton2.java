package com.wyl.designpattern.singleton;

import sun.applet.Main;

/**
 * @auther yanl.wang
 * @date 2023/1/7
 * 饿汉式（静态代码块）
 *
 * 跟Singleton1一个意思
 **/
public class Singleton2 {
    private final static Singleton2 INSTANCE;
    private Singleton2(){}

    static {
        INSTANCE = new Singleton2();
    }

    public static Singleton2 getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        System.out.println(Singleton2.getInstance() == Singleton2.getInstance());
    }
}
