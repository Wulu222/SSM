package com.wangdapao.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 1.使用ModelAndView实现数据共享
 * 2.使用Model实现数据共享
 * 3.使用Map实现数据共享
 * 4.使用MaverMap实现数据共享
 *
 */

@Controller
public class TestScopeController {


    @RequestMapping("/scope/mav")
    public ModelAndView testMAV(){
        ModelAndView mav = new ModelAndView();
        // 向模型中添加数据
        mav.addObject("testRequestScope","Hello ModelAndView");
        // 设置视图名称
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/scope/model")
    public String testModel(Model  model){
        model.addAttribute("testRequestScope","Hello Model");
        return "success";
    }

    @RequestMapping("/scope/modelmap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testRequestScope","Hello ModelMap");
        return "success";
    }

    @RequestMapping("/scope/map")
    public String testMap(Map<String,Object> map){
        map.put("testRequestScope","Hello Map");
        return "success";
    }

    @RequestMapping("/scope/session")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope","Hello Session");
        System.out.println( session+"==============================");
        return "success";
    }

    @RequestMapping("/scope/application")
    public String testApplication(HttpSession session){
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testApplicationScope","Hello Application");
        System.out.println(servletContext+"-------------------------------------");
        return "success";
    }

}
