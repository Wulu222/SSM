package com.wangdapao.spring.test;

import com.wangdapao.spring.controller.UserController;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireByXMLTest {

    /**
     * 自动装配：通过xml配置自动装配bean
     * 1.no和default：不进行装配
     * 2.byName：通过bean的id进行装配
     * 3.byType：通过bean的属性（类型）进行装配
     */

    @Test
    public void testAutowire(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("spring-autowire-xml.xml");
        UserController userController = ioc.getBean(UserController.class);
        userController.save();
    }
}
