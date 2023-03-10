package com.wyl.controller;

import com.wyl.annotation.WylAutowired;
import com.wyl.annotation.WylRequestMapping;
import com.wyl.annotation.WylRequestParam;
import com.wyl.com.wyl.service.WylService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @auther yanl.wang
 * @date 2023/2/3
 **/
@com.wyl.annotation.WylController
@WylRequestMapping("/wyl")
public class WylController {
    @WylAutowired("WylServiceImpl") //map.get(key)
    private WylService wylService;

    @WylRequestMapping("/query")
    public void query(HttpServletRequest request, HttpServletResponse response, @WylRequestParam("name") String name,@WylRequestParam("age") String age){
        try {
            PrintWriter pw = response.getWriter();
            String result = wylService.query(name, age);
            pw.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
