package com.wyl.designpattern.singleton;

import javax.sound.midi.Soundbank;

/**
 * @auther yanl.wang
 * @date 2023/1/7
 *
 * 懒汉试(线程不安全)
 *
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 *
 **/
public class Singleton3 {
    private static Singleton3 instance;

    private Singleton3(){}

    public static Singleton3 getInstance(){
        if (instance == null){//第一个线程来了，你是不是空。第二个线程来了，你是不是依然为空。两个线程同时进入执行
            try {//如果不睡眠，第一个线程执行过快，下一个线程执行的时候发现已有实例就不会去创建，发现不了问题。
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Singleton3();
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Singleton3.getInstance().hashCode());
            }).start();
        }

        System.out.println("11111111");
    }
}
