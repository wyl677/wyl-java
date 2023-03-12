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
 *
 * 线程的栈内存是相互独立的，互不干扰。
 *
 * 线程上下文切换
 *     1.线程的CPU时间片用完
 *     2.垃圾回收
 *     3.有更高优先级的线程需要运行
 *     4.线程自己调用了sleep、yield、wait、join、park、synchronized、lock等方法。
 *
 * sleep:让出CPU时间片，此线程状态为BLOCKED
 * yield:礼让，此线程的状态为RUNNABLE
 * yield和setPriority()都不能控制任务的调度，只是给任务调度器的一个提示，决定权还是任务调度器。
 * join：可以理解为插队，被插线程阻塞等待插队线程执行完。
 *
 **/
@Slf4j
public class TestJiaoti {
    public static void main(String[] args) {
        //线程是交替执行的
      new Thread(()->{while (true){log.info("t1线程");}},"t1").start();
      new Thread(()->{while (true){log.info("t2线程");}},"t2").start();
    }
}
