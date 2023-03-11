package com.wyl.createThread;

import lombok.extern.slf4j.Slf4j;

/**
 * @auther yanl.wang
 * @date 2023/3/11
 **/
@Slf4j
public class TestThread1 extends Thread{
    public static void main(String[] args) {
        //不写继承直接实现
        /*
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("线程体");
            }
        });

        thread.start();

        //lambda表达式写法
        new Thread(()->log.info("xianchengti")).start();
        */


        TestThread1 testThread1 = new TestThread1();
        testThread1.setName("t1");
        testThread1.start();
    }

    @Override
    public void run() {
        log.info("线程体");
    }
}
