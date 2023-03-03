package com.wyl.designpattern.singleton;

/**
 * @auther yanl.wang
 * @date 2023/1/7
 * 懒汉式(线程安全，同步方法)
 *
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题 .可以通过synchronized解决，但也带来效率下降
 **/
public class Singleton4 {
    private static Singleton4 instance;

    private Singleton4(){}

    public static synchronized Singleton4 getInstance(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (instance == null){
            instance = new Singleton4();
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Singleton4.getInstance().hashCode());
            }).start();
        }
    }
}
