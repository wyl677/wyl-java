package com.wyl.designpattern.builder;

/**
 * @auther yanl.wang
 * @date 2023/1/10
 * 抽象的建造者
 **/
public abstract class HouseBuilder {
    protected House house = new House();

    //将建造的流程写好，抽象方法
    public abstract void buildBaise();
    public abstract void buildWalls();
    public abstract void buildRoofed();

    //建造房子
    public House buildHouse(){
        return house;
    }
}
