package com.wangdapao.spring.test;

import com.wangdapao.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleTest {

    /**
     * 测试生命周期
     * 1.实例化：无参构造器方法
     * 2.依赖注入：set方法
     * 3.初始化前置处理：BeanPostProcessor.postProcessBeforeInitialization
     * 4.初始化：初始化方法
     * 5.初始化后置处理：BeanPostProcessor.postProcessAfterInitialization
     * 6.销毁：销毁方法
     *
     * 单例情况下：实例化，依赖注入，初始化随着ioc容器的获取而建立，销毁依靠ioc容器的关闭而销毁
     * 多例情况下：实例化，依赖注入，初始化，随着对象的创建而创建，销毁需要依靠手动销毁或者JVM虚拟机的垃圾回收机制
     */
    @Test
    public void testLifeCycle(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User user = ioc.getBean("user", User.class);
        System.out.println(user);
        ioc.close();
    }
}
