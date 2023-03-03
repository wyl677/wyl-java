package com.wyl.designpattern.builder;

/**
 * @auther yanl.wang
 * @date 2023/1/10
 **/
public class CommonsHouse extends HouseBuilder {
    @Override
    public void buildBaise() {
        System.out.println(" 普通房子打地基10m");
    }

    @Override
    public void buildWalls() {
        System.out.println(" 普通房子砌墙10cm");
    }

    @Override
    public void buildRoofed() {
        System.out.println(" 普通房子封顶");
    }
}
