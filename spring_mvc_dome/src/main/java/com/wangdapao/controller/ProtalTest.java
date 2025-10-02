package com.wangdapao.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProtalTest {

    @RequestMapping("/")
    public String protal(){
        //返回逻辑视图
        return "index";
    }

    @RequestMapping("/success")
    public String success(){
        return "success";
    }

}
