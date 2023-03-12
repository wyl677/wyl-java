package com.wyl.createThread;

import lombok.extern.slf4j.Slf4j;
import sun.rmi.runtime.Log;

/**
 * @auther yanl.wang
 * @date 2023/3/12
 * 刚开始线程打断状态是false,调用了Thread.interrupt();线程打断状态就为true，如果线程是睡眠状态调用打断会抛出异常
 **/
@Slf4j
public class TestInterrupt {
    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTerminate terminate = new TwoPhaseTerminate();
        terminate.start();

        Thread.sleep(3000);
        //业务操作


        terminate.stop();
    }
}


@Slf4j
class TwoPhaseTerminate{
    private Thread monite;

    //启动监控线程
    public void start(){
        monite = new Thread(()->{
            while (true){
                Thread current = Thread.currentThread();
                if (current.isInterrupted()){
                    log.info("完成一些后续操作...");
                    break;
                }

                try {
                    Thread.sleep(1000);//情况1
                    log.info("开始监控...");//情况2
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    current.interrupt();
                    System.out.println(current.isInterrupted());
                }
            }
        },"t1");
        monite.start();
    }

    //停止监控线程
    public void stop(){
        monite.interrupt();
    }
}
