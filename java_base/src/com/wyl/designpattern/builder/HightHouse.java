package com.wyl.designpattern.builder;

/**
 * @auther yanl.wang
 * @date 2023/1/10
 **/
public class HightHouse extends HouseBuilder {
    @Override
    public void buildBaise() {
        System.out.println(" 高级房子打地基100m");
    }

    @Override
    public void buildWalls() {
        System.out.println(" 高级房子砌墙100cm");
    }

    @Override
    public void buildRoofed() {
        System.out.println(" 高级房子封顶");
    }
}
