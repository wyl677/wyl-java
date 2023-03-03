package com.wyl.designpattern.adapter.classadapter;

/**
 * @auther yanl.wang
 * @date 2023/1/12
 **/
public class Phone {
    //充电
    public void charging(IVoltage5V iVoltage5V){
        if (iVoltage5V.output5V() == 5){
            System.out.println("电压为5V，可以充电～～");
        }else if (iVoltage5V.output5V() > 5){
            System.out.println("电压大于5V，不能充电～～");
        }
    }
}
