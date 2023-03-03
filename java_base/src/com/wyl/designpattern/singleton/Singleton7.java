package com.wyl.designpattern.singleton;

/**
 * @auther yanl.wang
 * @date 2023/1/7
 * 静态内部类
 *
 * 在内部类被加载和初始化时，才创建INSTANCE实例对象
 * 静态内部类不会自动随着外部类的加载和初始化而初始化，它是要单独去加载和初始化的。
 * 用的时候才会加载和初始化
 * 因为是在内部类加载和初始化时创建的，因此是线程安全的，(是类加载器对他加载的)
 *
 *
 * 单例模式注意事项
 *  1。单例模式保证类系统内存中该类只存在一个对象，节省了系统资源，对于一些需要频繁创建销毁的对象，使用单例模式可以提高系统性能
 *  2。当想实例化一个单例类的时候，必须要记住使用相应的获取方法，而不是使用new
 *  3。使用场景：需要频繁创建和销毁，创建对象时耗时过多或耗费过多的资源(重量级对象)，但又经常用到的对象、工具类对象、频繁访问数据库或文件对象
 *  (比如数据源、session工厂等)
 **/
public class Singleton7 {

    private Singleton7(){}

    private static class Singleton7Instance{
        private static final Singleton7 INSTANCE = new Singleton7();
    }

    public static Singleton7 getInstance(){
        return Singleton7Instance.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Singleton7.getInstance().hashCode());
            }).start();
        }
    }
}
