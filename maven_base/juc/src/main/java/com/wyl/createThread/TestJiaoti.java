package com.wyl.createThread;

import lombok.extern.slf4j.Slf4j;

/**
 * @auther yanl.wang
 * @date 2023/3/12
 *
 * jstack PID :查看进程PID的这一时刻详细信息
 * jps:查看Java进程
 * top:查看所有进行信息
 * top -H -p PID:查看PID进程详细信息
 **/
@Slf4j
public class TestJiaoti {
    public static void main(String[] args) {
        //线程是交替执行的
      new Thread(()->{while (true){log.info("t1线程");}},"t1").start();
      new Thread(()->{while (true){log.info("t2线程");}},"t2").start();
    }
}
