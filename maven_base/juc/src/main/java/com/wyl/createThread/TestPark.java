package com.wyl.createThread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

/**
 * @auther yanl.wang
 * @date 2023/3/12
 **/
@Slf4j
public class TestPark {
    public static void main(String[] args) throws InterruptedException {
        test();
    }

    public static void test() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            log.info("park.....");
            LockSupport.park();
            log.info("unpark.....");
            log.info("打断状态{}",Thread.interrupted());
            LockSupport.park();
            log.info("unpark.....");
        },"t1");

        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
    }
}
