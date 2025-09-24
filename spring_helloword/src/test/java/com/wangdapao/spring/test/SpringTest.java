package com.wangdapao.spring.test;

import com.wangdapao.spring.pojo.HelloSpring;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    public void testHello(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloSpring helloSpring = (HelloSpring) ioc.getBean("helloSpring");
        helloSpring.hello();
    }
}
