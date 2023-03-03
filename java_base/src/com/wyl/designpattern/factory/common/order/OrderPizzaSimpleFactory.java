package com.wyl.designpattern.factory.common.order;

import com.wyl.designpattern.factory.common.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @auther yanl.wang
 * @date 2023/1/8
 **/
public class OrderPizzaSimpleFactory {
    //定义一个简单工厂对象
    SimpleFactory simpleFactory;
    Pizza pizza = null;

    public OrderPizzaSimpleFactory(SimpleFactory simpleFactory){
        setSimpleFactory(simpleFactory);
    }
    public void setSimpleFactory(SimpleFactory simpleFactory){
        String orderType = ""; //用户输入
        this.simpleFactory = simpleFactory;

        do {
            orderType = getType();
            pizza = this.simpleFactory.createPizza(orderType);

            if (pizza != null){
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else {
                System.out.println("订购披萨失败");
                break;
            }
        }while (true);
    }

    public String getType(){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
