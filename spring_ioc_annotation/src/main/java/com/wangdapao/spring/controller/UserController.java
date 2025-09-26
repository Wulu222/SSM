package com.wangdapao.spring.controller;

import com.wangdapao.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller("controller")
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService1;

    public void saveUser(){
        userService1.saveUser();
    }
}
