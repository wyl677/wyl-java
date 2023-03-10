package com.wyl.com.wyl.service.com.wyl.service.impl;

import com.wyl.com.wyl.service.WylService;

/**
 * @auther yanl.wang
 * @date 2023/2/3
 **/
@com.wyl.annotation.WylService("WylServiceImpl") //当容器初始化时 map.put(WylServiceImpl,new WylServiceImpl());
public class WylServiceImpl implements WylService {
    @Override
    public String query(String name, String age) {
        return "name===="+name+";   age==="+age;
    }
}
