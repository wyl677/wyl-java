package com.wyl.designpattern.factory.common.pizza;

/**
 * @auther yanl.wang
 * @date 2023/1/7
 *
 * 披萨抽象类
 **/
public abstract class Pizza {
    protected String name;

    //准备原材料
    public abstract void prepare();

    //烘烤
    public void bake(){
        System.out.println(name + " baking;");
    }

    //切
    public void cut(){
        System.out.println(name + " cutting;");
    }

    //打包
    public void box(){
        System.out.println(name + " boxing;");
    }

    public void setName(String name){
        this.name = name;
    }
}
