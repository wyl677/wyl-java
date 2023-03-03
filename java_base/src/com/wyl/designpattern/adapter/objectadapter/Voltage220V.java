package com.wyl.designpattern.adapter.objectadapter;

/**
 * @auther yanl.wang
 * @date 2023/1/12
 * 被适配的类
 **/
public class Voltage220V {
    //输出220V的电压
    public int output220V(){
        int src = 220;
        System.out.println("电压=" + src + "伏");
        return src;
    }
}
