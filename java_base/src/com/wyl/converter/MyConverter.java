package com.wyl.converter;

import org.junit.Test;

/**
 * @auther yanl.wang
 * @date 2023/2/7
 * 类型转换
 **/
public class MyConverter {

    /**
     * 字符串转数字
     */
    @Test
    public void StringToNumber(){
        String str = "1";
        int i = Integer.parseInt(str);
        System.out.println(i);
    }
}
