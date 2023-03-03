package com.wyl.designpattern.prototype;

import java.io.*;

/**
 * @auther yanl.wang
 * @date 2023/1/9
 *
 **/
public class DeepCopySheep implements Cloneable,Serializable{
    private String name;
    private int age;
    private String color;
    private SheepFriend sheepFriend;

    public DeepCopySheep(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSheepFriend(SheepFriend sheepFriend) {
        this.sheepFriend = sheepFriend;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public SheepFriend getSheepFriend() {
        return sheepFriend;
    }

    @Override
    public String toString() {
        return "DeepCopySheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", sheepFriend=" + sheepFriend +
                '}';
    }

    //1.深拷贝--重写clone方法实现
    @Override
    protected Object clone() {
        DeepCopySheep deepCopySheep = null;
        try {
           deepCopySheep = (DeepCopySheep) super.clone();
//           deepCopySheep.sheepFriend = (SheepFriend) sheepFriend.clone();
            deepCopySheep.setSheepFriend((SheepFriend) sheepFriend.clone());
           //对引用类型的属性单独处理

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return deepCopySheep;
    }


    //2.深拷贝--通过对象的序列化实现(推荐)
    public Object deepClone(){
        //创建流对象
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        try {
            //对象序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this); //当前这个对象以对象流的方式输出

            //对象发序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            DeepCopySheep deepCopySheep = (DeepCopySheep) ois.readObject();
            return deepCopySheep;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
          try {
             ois.close();
             bis.close();
             oos.close();
             bos.close();
          }catch (Exception e){
              System.out.println(e.getMessage());
          }

        }
    }
}
