package com.wyl.createThread;

import lombok.extern.slf4j.Slf4j;

/**
 * @auther yanl.wang
 * @date 2023/3/12
 * 演示线程的6种状态
 **/
@Slf4j
public class TestState {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> { //NEW
            log.info("running.....");
        },"t1");

        Thread t2 = new Thread(() -> { //RUNNABLE
            while (true){

            }
        }, "t2");
        t2.start();

        Thread t3 = new Thread(() -> { //TERMINATED
            log.info("running.....");
        }, "t3");
        t3.start();

        Thread t4 = new Thread(() -> { //TIMED_WAITING
            synchronized (TestState.class){
                try {
                    Thread.sleep(1000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t4");
        t4.start();

        Thread t5 = new Thread(() -> { //WATTING
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t5");
        t5.start();

        Thread t6 = new Thread(() -> { //BLOCKED
            synchronized (TestState.class){
                try {
                    Thread.sleep(1000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "t6");
        t6.start();

        log.info("t1 state {}",t1.getState());
        log.info("t2 state {}",t2.getState());
        log.info("t3 state {}",t3.getState());
        log.info("t4 state {}",t4.getState());
        log.info("t5 state {}",t5.getState());
        log.info("t6 state {}",t6.getState());
    }
}
