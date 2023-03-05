package com.wyl.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @auther yanl.wang
 * @date 2023/2/7
 * Spring自定义类型转换器
 *    实现Converter接口，重写converter(),配置文件自定义类型转换器注册
 *
 * 细节
 *    1。ConversionServiceFactoryBean定义id属性值必须为conversionService
 *    2。Spring框架内置日期类型的转换器（只能转2023/01/01这种格式日期）
 *
 **/
public class MyDateConverter implements Converter<String, Date> {
    private String pattern;

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /*
       convert方法作用：String --->  Date
                      SimpleDateFormat sdf = new SimpleDateFormat();
                      sdf.parset(String) ---> Date
       param:source 代表的是配置文件中 日期字符串 <value>2020-10-11</value>

       return : 当把转换好的Date作为convert方法的返回值后，Spring自动的为birthday属性进行注入（赋值）

     */

    /**
     * 字符串转日期
     * @param source 代表配置文件中 日期字符串
     * @return 返回值自动赋值
     */
    @Override
    public Date convert(String source) {

        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            date = sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
