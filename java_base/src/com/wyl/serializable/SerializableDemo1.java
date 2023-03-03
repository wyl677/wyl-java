package com.wyl.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @auther yanl.wang
 * @date 2023/1/9
 **/
public class SerializableDemo1 {

    public static void main(String[] args) throws Exception, IOException {
        //初始化对象
        User1 user = new User1();
        user.setName("yaomy");
        user.setAge(23);
        System.out.println(user);
        //序列化对象到文件中
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("template"));
        oos.writeObject(user);
        oos.close();
        //反序列化
        File file = new File("template");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        User1 newUser = (User1)ois.readObject();
        System.out.println(newUser.toString());
    }
}


