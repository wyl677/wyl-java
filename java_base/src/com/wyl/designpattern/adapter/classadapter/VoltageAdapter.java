package com.wyl.designpattern.adapter.classadapter;

/**
 * @auther yanl.wang
 * @date 2023/1/12
 * 适配类
 **/
public class VoltageAdapter extends Voltage220V implements IVoltage5V{
    @Override
    public int output5V() {
        //获取到220V电压
        int srcV = output220V();
        int dstV = srcV / 44;//转成5V
        return dstV;
    }
}
