package com.wyl.designpattern.builder;

/**
 * @auther yanl.wang
 * @date 2023/1/10
 * 指挥者，这里去指定制作流程
 **/
public class HouseDirector {
    HouseBuilder houseBuilder = null;

    //构造器传入houseBuilder

    public HouseDirector(HouseBuilder houseBuilder){
        this.houseBuilder = houseBuilder;
    }
    //通过setter方法传入houseBuilder
    public void setHouseBuilder(HouseBuilder houseBuilder){
        this.houseBuilder = houseBuilder;
    }

    //如何处理建房的流程，交给指挥者
    public House constructHouse(){
        houseBuilder.buildBaise();
        houseBuilder.buildWalls();
        houseBuilder.buildRoofed();
        return houseBuilder.buildHouse();
    }
}
