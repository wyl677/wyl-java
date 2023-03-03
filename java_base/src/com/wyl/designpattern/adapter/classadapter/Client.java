package com.wyl.designpattern.adapter.classadapter;

/**
 * @auther yanl.wang
 * @date 2023/1/12
 * 类适配器模式：
 *  Adapter类，通过继承src类，实现dst类接口,完成src->dst的适配
 *
 * 适配器模式工作原理：
 *  1。适配器模式：将一个类的接口转换成另一个种接口，让原本接口不兼容的类可以兼容。
 *  2。从用户的角度看不到被适配者，是解藕的
 **/
public class Client {
    public static void main(String[] args) {
        System.out.println("==类适配器模式==");
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter());
    }
}
