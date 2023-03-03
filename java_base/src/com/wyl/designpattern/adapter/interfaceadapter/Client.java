package com.wyl.designpattern.adapter.interfaceadapter;

/**
 * @auther yanl.wang
 * @date 2023/1/12
 * 接口适配器模式
 *  1。一些书籍称为：适配器模式或缺省适配器模式。
 *  2。当不需要全部实现接口提供的方法时，可先设计一个抽象类实现接口，并为该接口中每个方法提供一个默认实现(空方法)，那么该抽象类的子类可有选择地覆盖父类的
 *  某些方法来实现需求
 *  3。适用于一个接口不想使用其所有的方法的情况
 **/
public class Client {
    public static void main(String[] args) {
        AbsAdapter absAdapter = new AbsAdapter(){
            //只需要覆盖我们 需要使用的 接口方法
            @Override
            public void m1() {
                System.out.println("使用了m1的方法");
            }
        };

        absAdapter.m1();
    }
}
