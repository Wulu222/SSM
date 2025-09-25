package com.wangdapao.spring.test;

import com.wangdapao.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryBeanTest {

    @Test
    public void testFactoryBean(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("spring-factory.xml");
        User user1 = ioc.getBean(User.class);
        System.out.println(user1);
    }
}
