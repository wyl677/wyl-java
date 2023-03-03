package com.wyl.reflect.autowire;

import java.util.stream.Stream;

/**
 * Author:yanl.wang
 * Date:2022/4/3 9:08
 */
public class Test {
    public static void main(String[] args) {
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();

        //为给定的元素创建顺序流。获取所有的属性(n多个属性，有的有Autowired有的没有。数组转集合)
        Stream.of(clazz.getDeclaredFields()).forEach(field -> {
            //判断每个属性是否有注解
            Autowired annotation = field.getAnnotation(Autowired.class);
            if (annotation != null){
                field.setAccessible(true); //true取消访问安全检查
                Class<?> type = field.getType();

                //实例化对象
                Object o = null;
                try {
                    o = type.newInstance();
                    field.set(userController,o);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        });

        System.out.println(userController.getUserService());

    }
}
