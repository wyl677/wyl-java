package com.wyl.proxy;

/**
 * @auther yanl.wang
 * @date 2023/2/8
 **/
public class UserServiceImpl implements UserService{

    @Override
    public void register(User user) {
        System.out.println("UserServiceImpl.register");
//        throw new RuntimeException("运行时异常");
    }

    @Override
    public boolean login(String name, String password) {
        System.out.println("UserServiceImpl.login");
        return true;
    }
}
