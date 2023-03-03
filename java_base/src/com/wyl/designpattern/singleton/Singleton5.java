package com.wyl.designpattern.singleton;

/**
 * @auther yanl.wang
 * @date 2023/1/7
 * 懒汉式(线程不安全，同步代码块)
 *
 **/
public class Singleton5 {
    private static Singleton5 instance;

    private Singleton5(){}

    public static Singleton5 getInstance(){
        if (instance == null){
            /**
             * 第一个线程来了为空，先暂停。第二个线程来了依然为空。第二个线程申请锁，
             * 持有这把锁，new了对象，释放锁。
             * 第一个线程继续，持有锁new对象，返回。
             * 根源问题就是一个线程在上锁当中，另一个线程已经把值new了出来
             * 妄图通过减小同步代码块的方式提高效率，然后不行
             */
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (Singleton5.class){
                instance = new Singleton5();
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Singleton5.getInstance().hashCode());
            }).start();
        }
    }
}
