package com.wangdapao.spring.aop.xml;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class ValidateAspect {

    @Before("com.wangdapao.spring.aop.xml.LoggerAspect.pointCut()")
    public void beforeValidate(){
        System.out.println("ValidateAspect----->前置通知");
    }
}
