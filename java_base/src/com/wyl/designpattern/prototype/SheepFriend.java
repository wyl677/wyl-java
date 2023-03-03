package com.wyl.designpattern.prototype;

import java.awt.*;
import java.io.Serializable;

/**
 * @auther yanl.wang
 * @date 2023/1/9
 **/
public class SheepFriend implements Cloneable, Serializable {
    private String name;
    private int age;
    private String color;

    public SheepFriend(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "SheepFriend{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
