package com.wyl.createThread;

import lombok.extern.slf4j.Slf4j;

/**
 * @auther yanl.wang
 * @date 2023/3/12
 * 线程间上下文切换导致指令错乱发生线程不安全问题
 * A线程拿到值+1写回去的时候CPU切换到B线程，B线程把自己-1的结果写了回去
 **/
@Slf4j
public class TestContextChange {
    private static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (TestContextChange.class){ //给临界值加锁解决线程安全问题
                    count ++;
                }
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (TestContextChange.class){
                    count --;
                }
            }
        }, "t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("count = " + count);;
    }
}
