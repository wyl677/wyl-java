package com.wyl.proxy;

/**
 * @auther yanl.wang
 * @date 2023/2/8
 **/
public interface UserService {
    public void register(User user);
    public boolean login(String name,String password);
}
