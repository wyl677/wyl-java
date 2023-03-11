package com.wyl.createThread;

import lombok.extern.slf4j.Slf4j;

/**
 * @auther yanl.wang
 * @date 2023/3/11
 **/
@Slf4j
public class TestThread2 implements Runnable{
    public static void main(String[] args) {
        //不是实现接口直接实现
         /*
         Runnable runnable = new Runnable() {
            @Override
            public void run() {
                log.info("线程体");
            }
        };

        Thread thread = new Thread(runnable,"t1");
        thread.start();
        */

        TestThread2 testThread2 = new TestThread2();
        Thread thread = new Thread(testThread2, "t1");
        thread.start();
    }

    @Override
    public void run() {
        log.info("xianchengti");
    }
}
