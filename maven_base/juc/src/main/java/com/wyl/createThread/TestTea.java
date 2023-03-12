package com.wyl.createThread;

import lombok.extern.slf4j.Slf4j;

/**
 * @auther yanl.wang
 * @date 2023/3/12
 * 泡茶
 *    洗水壶，烧开水
 *    洗茶壶，洗茶杯，拿茶叶，泡茶
 **/
@Slf4j
public class TestTea {
    private static Thread t1;
    private static Thread t2;
    public static void main(String[] args) {

         t1 = new Thread(() -> {
            try {
                log.info("洗水壶...");
                Thread.sleep(1000);
                log.info("烧开水");
                Thread.sleep(5000);

                t2.join();
                log.info("泡茶");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "老王");


         t2 = new Thread(() -> {
            try {
                log.info("洗茶壶");
                Thread.sleep(1000);
                log.info("洗茶杯");
                Thread.sleep(1000);
                log.info("拿茶叶");
                Thread.sleep(1000);
//                t1.join();
//                log.info("泡茶。。。。。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "小王");



        t1.start();
        t2.start();
    }

}
