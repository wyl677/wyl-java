package com.wyl.designpattern.factory.common.pizza;

/**
 * @auther yanl.wang
 * @date 2023/1/7
 **/
public class CheesePizza extends Pizza{

    @Override
    public void prepare() {
        System.out.println(" 给制作奶酪披萨准备原材料 ");
    }
}
