package com.wyl.createThread;

import lombok.extern.slf4j.Slf4j;

/**
 * @auther yanl.wang
 * @date 2023/3/12
 * 守护线程，其他线程结束他就结束了
 **/
@Slf4j
public class TestDaemon {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
            }
            log.info("结束");
        }, "t1");
        t1.setDaemon(true);
        t1.start();


        Thread.sleep(1000);
        log.info("结束");
    }
}
