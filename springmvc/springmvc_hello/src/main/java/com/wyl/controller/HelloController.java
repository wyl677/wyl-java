package com.wyl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @auther yanl.wang
 * @date 2023/1/13
 **/
@Controller  //作为Spring IOC容器的组件
public class HelloController {

    @RequestMapping("/")
    public String index(){
        //返回视图名称
        return "index";
    }

    @RequestMapping("/target")
    public String toTarget(){
       return "target";
    }
}
