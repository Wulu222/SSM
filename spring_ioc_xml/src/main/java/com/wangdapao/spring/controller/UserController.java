package com.wangdapao.spring.controller;

import com.wangdapao.spring.service.UserService;

public class UserController {
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void save(){
        userService.save();
    }
}
