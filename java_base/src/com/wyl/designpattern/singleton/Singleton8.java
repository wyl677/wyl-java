package com.wyl.designpattern.singleton;

/**
 * @auther yanl.wang
 * @date 2023/1/7
 * 枚举
 *
 * 不仅可以解决线程同步，还可以防止反序列化
 **/
public enum  Singleton8 {
    INSTANCE;
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Singleton8.INSTANCE.hashCode());
            }).start();
        }
    }
}
