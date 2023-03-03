package com.wyl.designpattern.factory.common.order;

/**
 * @auther yanl.wang
 * @date 2023/1/7
 * 客户端，发起披萨订购
 **/
public class PizzaStore {

    public static void main(String[] args) {
//        new OrderPizza();

        //使用工厂模式
        new OrderPizzaSimpleFactory(new SimpleFactory());
        System.out.println("退出程序。。。。。");
    }
}
