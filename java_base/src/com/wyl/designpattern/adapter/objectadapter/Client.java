package com.wyl.designpattern.adapter.objectadapter;

/**
 * @auther yanl.wang
 * @date 2023/1/12
 *
 **/
public class Client {
    public static void main(String[] args) {
        System.out.println("==对象配器模式==");
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter(new Voltage220V()));
    }
}
