package com.wyl;

import java.io.InputStream;
import java.util.Properties;

/**
 * @auther yanl.wang
 * @date 2023/2/5
 * spring结构项目，读取properties文件类容(联想工作流自定义参与者的编写)
 *
 * IO流在整个Java中是系统级资源，尽量避免重复性的打开IO，最好是在程序启动时一次性的读取想要的类容
 **/
public class ReadProperties {
    private static Properties env = new Properties();
    static {
        try {
            //1.获取IO输入流
            InputStream is = ReadProperties.class.getResourceAsStream("/application.properties");
            //2.文件类容，封装Properties集合中
            env.load(is);
            System.out.println(env.getProperty("userService"));
            System.out.println(env.getProperty("aaaa"));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }

}
