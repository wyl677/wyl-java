package com.wyl.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @auther yanl.wang
 * @date 2022/5/8
 **/
public class TestSimpleDateFormat {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmSSS");
        System.out.println("格式化当前时间为yyyyMMddHHmmSSS" + dateFormat.format(date));


        System.out.println("推荐使用的获取时间戳的方法，效率最高："+System.currentTimeMillis());
        System.out.println("Date类："+ new Date().getTime());
        System.out.println("Calendar类，效率最低：" + Calendar.getInstance().getTimeInMillis());
    }
}
