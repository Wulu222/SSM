package com.wangdapao.controller;

import com.wangdapao.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 测试参数获取
 * 1.通过servletAPI获取参数
 *     使用HttpServletRequest获取参数：
 *          在方法参数中添加HttpServletRequest对象，通过request对象获取参数
 *
 * 2.通过控制器方法参数获取参数
 *      在控制器方法的参数位置设置相同的参数名，SpringMVC会自动将请求参数赋给参数（需要请求参数和控制器方法参数一致，编译器能保留参数）
 *      可以使用@RequestParam注解将请求参数和控制器方法的参数进行绑定
 * @RequestParam注解的三个属性：
 *      value：指定绑定的请求参数
 *      required：设置请求参数是否必须提供，默认值为true
 *      defaultValue：设置请求参数的默认值
 *
 * 3.@RequestHeader 获取请求头信息 用法与@RequestParam一致
 * 4.@CookieValue 获取Cookie信息 用法与@RequestParam一致
 *
 * 5.通过控制器方法的实体类类型的形参获取请求参数
 *
 * 6.解决请求参数中文乱码问题
 * 在web.xml中配置了过滤器CharacterEncodingFilter，解决中文乱码问题
 */

@Controller
public class TestParamController {

    @RequestMapping("/param/servletAPI")
    public String testServletAPI(HttpServletRequest  request){
        // 获取Session 会在页面中多一个set- cookie的响应头
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+username+" password:"+password);
        return "success";
    }

    @RequestMapping("/param/controller")
    public String testController(@RequestParam(value = "username",required = true,defaultValue = "admin") String username,
                                 @RequestParam("password") String password,
                                 @RequestHeader("referer") String referer,
                                 @CookieValue("JSESSIONID") String jsessionid
                                 ){
        System.out.println("referer:"+referer);
        System.out.println("JSESSIONID:"+jsessionid);
        System.out.println("username:"+username+" password:"+password);
        return "success";
    }

    @RequestMapping("/param/pojo")
    public String testPojo(User user){
        System.out.println(user);
        return "success";
    }

}
