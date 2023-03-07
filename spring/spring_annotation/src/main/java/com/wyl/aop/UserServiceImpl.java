package com.wyl.aop;


import org.springframework.stereotype.Service;

/**
 * @auther yanl.wang
 * @date 2023/2/20
 **/
@Service
public class UserServiceImpl implements UserService{
    @Override
    public void register() {
        System.out.println("UserServiceImpl.register");
    }

    @Override
    public void login() {
        System.out.println("UserServiceImpl.login");
    }
}
