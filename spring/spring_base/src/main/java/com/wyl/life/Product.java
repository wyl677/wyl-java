package com.wyl.life;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @auther yanl.wang
 * @date 2023/2/7
 * 生命周期的3个阶段
 *    创建阶段
 *       scope="singleton" spring工厂创建的同时创建对象。加lazy-init="true"就会在获取的时候在创建
 *       scope="prototype" spring工厂获取对象的同时创建对象
 *    初始化阶段（spring工厂在创建完对象后，调用对象的初始化方法，完成对应的初始化操作）
 *       初始化方法程序员提供，spring工厂调用
 *       方式一：实现InitializingBean,重写afterPropertiesSet()
 *       方式二：对象中提供一个普通方法,在配置文件中属性写init-method="方法名"
 *    销毁阶段（spring销毁对象前，会调用对象的销毁方法，完成销毁操作）context.close()关闭工厂的时候销毁对象
 *       方式一：实现DisposableBean,重写destory()
 *       方式二：对象中提供一个普通方法，在配置文件中属性写destory-method="方法名"
 *
 **/
public class Product implements InitializingBean, DisposableBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setName:" + name);
        this.name = name;
    }

    public Product(){
        System.out.println("Product无参构造");
    }

    /**
     * 方式一
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Product的初始化方法");
    }

    public void myInit(){
        System.out.println("方式二初始化");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("销毁方法");
    }

    public void myDestory(){
        System.out.println("自定义销毁方法");
    }
}
