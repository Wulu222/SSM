package com.wangdapao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * RequestMapping的位置
 * 1.类上：映射请求的请求路径的初始信息
 * 2.方法上：映射请求的请求路径的具体信息
 *当前的请求路径为：/test/success
 *
 * 1.对于RequestMapping的value属性可以有如下情况：
 * value属性是一个数组，可以同时匹配多个请求路径
 *
 * 2.对于RequestMapping的method属性可以有如下情况：
 * method属性是一个数组，可以同时指定多个请求方式,值域为RequestMethod枚举类
 * 通过请求方式匹配请求
 *      常用的枚举对象：GET POST
 *      在RequestMapping的基础上，结合请求方式进行匹配的派生注解
 *      @GetMapping  @PostMapping @DeleteMapping @PutMapping
 *
 * 3.对于RequestMapping的params属性可以有如下情况：
 * params属性是一个数组，可以同时指定多个请求参数（需要全不满足才不会报错）
 * 形式：
 *      params = "username"  username参数必须存在
 *      params = "username=admin"  username参数必须等于admin
 *      params = "!username"  username参数必须不存在
 *      params = "username!=admin"  username参数可以不存在 若存在必须不等于admin
 * 不常用
 *
 * 4.对于RequestMapping的headers属性可以有如下情况：
 * 与params属性类似，但是是请求头信息
 *
 * 5.RequestMapping支持ant风格的匹配
 * 形式：
 *      ?    匹配任意一个字符 (不包括 ? /)
 *      *    匹配任意多个字符 (不包括 ? /)
 *      **   匹配任意层数的任意多个路径
 *
 * 6.RequestMapping支持rest的占位符
 *  传统获取参数：/test/success?username=admin&password=123
 *  rest风格获取参数：/test/success/admin/123
 *  形式：
 *      @RequestMapping("/test/rest/{username}/{password}")
 *      @PathVariable（"username"） String username，@PathVariable("password") Integer  password
 */

@Controller
@RequestMapping("/test")
public class TestRequestMappingController {

    @RequestMapping(
            value = {"/success","/abc"},
            method = {RequestMethod.POST,RequestMethod.GET},
//            params = {"username","password!=123","age=18","!neige"}
            headers = "referer"
    )
    public String testRequestMapping(){
        return "success";
    }

//    @RequestMapping("/a?a/test/ant")
//    public String testAnt1(){
//        return "success";
//    }

//    @RequestMapping("/a*a/test/ant")
//    public String testAnt2(){
//        return "success";
//    }

    @RequestMapping("/test/ant/**")
    public String testAnt3(){
        return "success";
    }

    @RequestMapping("/test/rest/{username}/{password}")
    public String testRest(@PathVariable("username") String username,@PathVariable("password") Integer  password){
        System.out.println("username:"+username+"  password:"+password);
        return "success";
    }

}
