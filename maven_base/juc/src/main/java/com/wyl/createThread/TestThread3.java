package com.wyl.createThread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @auther yanl.wang
 * @date 2023/3/11
 **/
@Slf4j
public class TestThread3 implements Callable<Integer> {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
       /*
       Callable<Integer> callable = () -> {
            log.info("running...");
            Thread.sleep(1000);
            return 100;
        };
        FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);

        Thread thread = new Thread(futureTask, "t1");
        thread.start();

        log.info("{}",futureTask.get()); //如果有线程使用上面线程的返回结果get()时就会一直等待上面线程的返回(阻塞)
        */


        TestThread3 testThread3 = new TestThread3();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(testThread3);
        Thread thread = new Thread(futureTask, "t1");
        thread.start();
        Integer integer = futureTask.get();
        log.info("{}",integer);

    }

    @Override
    public Integer call() throws Exception {
        log.info("线程体......");
        Thread.sleep(1000);
        return 100;
    }
}
