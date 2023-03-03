package com.wyl.captcha;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.text.impl.DefaultTextCreator;
import com.wyl.com.wyl.collection.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @auther yanl.wang
 * @date 2022/10/4
 **/
public class Test {
    public static void main(String[] args) throws Exception  {
        Student student = new Student();
        student.setName("zhangsan");
        student.setAge("20");
        System.out.println(student);

        System.out.println(getPreTime("20221209131801","10"));
    }

    /**
     *
     * @param startTime 传入日期
     * @param preMin 前n分钟
     * @return startTime的前n分钟的yyyyMMddHHmmss格式的时间
     * @throws ParseException
     */
    public static String getPreTime(String startTime,String preMin) throws ParseException {
        //传入startTime转yyyyMMddHHmmss日期格式
        Date date = new SimpleDateFormat("yyyyMMddHHmmss").parse(startTime);
        //获取startTime时间戳
        long time = date.getTime();
        //字符串分钟数转Long类型
        long min = Long.parseLong(preMin);
        //starTime时间戳-preMin的毫秒数
        long result = time - (min * 60 * 1000);
        String preTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(result));
        return preTime;
    }

}
