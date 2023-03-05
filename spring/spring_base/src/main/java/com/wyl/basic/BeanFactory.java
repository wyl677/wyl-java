package com.wyl.basic;

import java.io.InputStream;
import java.util.Properties;

/**
 * @auther yanl.wang
 * @date 2023/3/5
 **/
public class BeanFactory {

    private static Properties env = new Properties();

    static {
        try {
            //1.获取输入流
            InputStream inputStream = BeanFactory.class.getResourceAsStream("/applicationContext.properties");
            //2.文件内容 封装 Properties集合中 key = userService value = com.wyl.basic.UserServiceImpl
            env.load(inputStream);

            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object getBean(String key) {
        Object ret = null;
        try {
            Class<?> clazz = Class.forName(env.getProperty(key));
            ret = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

}
