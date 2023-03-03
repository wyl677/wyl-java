package com.wyl.designpattern.factory.common.order;

import com.sun.tools.corba.se.idl.constExpr.Or;
import com.wyl.designpattern.factory.common.pizza.CheesePizza;
import com.wyl.designpattern.factory.common.pizza.GreekPizza;
import com.wyl.designpattern.factory.common.pizza.Pizza;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @auther yanl.wang
 * @date 2023/1/7
 **/
public class OrderPizza {

    //构造器
    public OrderPizza(){
        Pizza pizza = null;
        String orderType;//订购披萨类型
        do {
            orderType = getType();
            if (orderType.equals("greek")){
                pizza = new GreekPizza();
                pizza.setName("希腊披萨 ");
            }else if (orderType.equals("cheese")){
                pizza = new CheesePizza();
                pizza.setName("奶酪披萨 ");
            }else {
                break;
            }

            //输出披萨的制作过程
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();

        }while (true);


    }

    //写一个方法，可以获取客户订购的披萨种类
    private String getType(){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            return br.readLine();
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }
}
