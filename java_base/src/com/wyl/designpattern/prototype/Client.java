package com.wyl.designpattern.prototype;

import java.sql.SQLOutput;

/**
 * @auther yanl.wang
 * @date 2023/1/9
 *
 * 原型模式
 *
 * 浅拷贝：对于数据类型是基本数据类型的成员变量，浅拷贝会直接进行值传递，也就是将该属性的值复制一份给新的对象。
 *        对于数据类型是引用类型的成员变量，比如说数组、类的对象，那么浅拷贝会进行引用传递，也就是只是将该成员变量的引用值(内存地址)复制一份
 *        给新的对象，因为实际上两个对象的该成员变量都指向同一个实例
 *
 * 深拷贝实现方式：
 *  1.重写clone方法
 *  2.通过对象的序列化实现深拷贝
 *
 * 原型模式注意事项和细节：
 *  1.创建新的对象比较复杂时，可以利用原型模式简化对象的创建过程，同时也能够提高效率
 *  2.不用重新初始化对象，而是动态地获得对象运行时的状态
 *  3.如果原始对象发生变化时（增加或减少属性），其他克隆对象也会发生相应的变化，无需修改代码
 *  4.在实现深克隆的时候可能需要比较复杂的代码
 *  5.缺点：需要为每一个类配备一个克隆方法，这对全新的类来说不是很难，但对已有的类进行改造时，需要修改其源代码，违背类ocp原则。
 *
 * spring中bean的创建用了原型模式
 **/
public class Client {
    public static void main(String[] args) {
//        System.out.println("用原型模式完成对象的创建");
//        Sheep sheep = new Sheep("Tom", 12, "白色");
//        sheep.friend = new Sheep("jack",11,"黑色");
//        Sheep sheep1 = (Sheep) sheep.clone();
//        Sheep sheep2 = (Sheep) sheep.clone();
//        System.out.println(sheep.hashCode()+"=====" + sheep.friend.hashCode());
//        System.out.println(sheep1.hashCode()+"=====" + sheep1.friend.hashCode());
//        System.out.println(sheep2.hashCode()+"=====" + sheep2.friend.hashCode());

//        System.out.println("重写clone方法实现深拷贝～～～～");
//        DeepCopySheep deepCopySheep = new DeepCopySheep("haha", 1, "白色");
//        SheepFriend sheepFriend = new SheepFriend("hehe", 2, "黑色");
//        deepCopySheep.setSheepFriend(sheepFriend);
//        DeepCopySheep deepCopySheep1 = (DeepCopySheep) deepCopySheep.clone();
//        DeepCopySheep deepCopySheep2 = (DeepCopySheep) deepCopySheep.clone();
//        DeepCopySheep deepCopySheep3 = (DeepCopySheep) deepCopySheep.clone();
//        System.out.println(deepCopySheep.hashCode()+"======="+deepCopySheep.getSheepFriend().hashCode());
//        System.out.println(deepCopySheep1.hashCode()+"======="+deepCopySheep1.getSheepFriend().hashCode());
//        System.out.println(deepCopySheep2.hashCode()+"======="+deepCopySheep2.getSheepFriend().hashCode());
//        System.out.println(deepCopySheep3.hashCode()+"======="+deepCopySheep3.getSheepFriend().hashCode());


        System.out.println("通过对象序列化和反序列化实现深拷贝～～～");
        DeepCopySheep deepCopySheep = new DeepCopySheep("haha", 1, "白色");
        SheepFriend sheepFriend = new SheepFriend("hehe", 2, "黑色");
        deepCopySheep.setSheepFriend(sheepFriend);
        DeepCopySheep deepCopySheep1 = (DeepCopySheep) deepCopySheep.deepClone();
        DeepCopySheep deepCopySheep2 = (DeepCopySheep) deepCopySheep.deepClone();
        DeepCopySheep deepCopySheep3 = (DeepCopySheep) deepCopySheep.deepClone();
        System.out.println(deepCopySheep.hashCode()+"======="+deepCopySheep.getSheepFriend().hashCode());
        System.out.println(deepCopySheep1.hashCode()+"======="+deepCopySheep1.getSheepFriend().hashCode());
        System.out.println(deepCopySheep2.hashCode()+"======="+deepCopySheep2.getSheepFriend().hashCode());
        System.out.println(deepCopySheep3.hashCode()+"======="+deepCopySheep3.getSheepFriend().hashCode());
    }
}
