package com.wyl.cglib;

import com.wyl.proxy.User;

/**
 * @auther yanl.wang
 * @date 2023/2/9
 **/
public class UserService {
    public void login(String name,String password){
        System.out.println("UserService.login");
    }

    public void register(User user){
        System.out.println("UserService.register");
    }
}
