package com.wyl.reflect.autowire;

/**
 * Author:yanl.wang
 * Date:2022/3/30 21:22
 */
public class UserController {

    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }
}
