package com.wyl.designpattern.adapter.objectadapter;

/**
 * @auther yanl.wang
 * @date 2023/1/12
 * 适配类
 **/
public class VoltageAdapter implements IVoltage5V {
    private Voltage220V voltage220V;

    //通过构造器，传入一个Voltage220V实例
    public VoltageAdapter(Voltage220V voltage220V){
        this.voltage220V = voltage220V;
    }
    @Override
    public int output5V() {
        int dstV = 0;
        if (null != voltage220V){
            int srcV = voltage220V.output220V();//获取220V电压
            System.out.println("使用对象适配器进行适配～～");
            dstV = srcV / 44;
            System.out.println("适配完成～～，输出的电压为="+dstV);
        }
        return dstV;
    }
}
