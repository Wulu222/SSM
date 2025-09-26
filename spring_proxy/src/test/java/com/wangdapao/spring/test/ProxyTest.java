package com.wangdapao.spring.test;

import com.wangdapao.spring.factory.ProxyFactory;
import com.wangdapao.spring.proxy.Calculator;
import com.wangdapao.spring.proxy.impl.CalculatorImpl;
import org.junit.Test;

public class ProxyTest {

    /**
     * 动态代理分为两种：
     * jdk动态代理，基于接口，必须要有接口，生成的代理类和目标类接口一致，位置为com.sun.proxy包下,类名为$proxy0
     * cglib动态代理，基于继承，生成的代理类和目标类一致，位置为目标类同一个包下,类名为CGLIB$$CalculatorImpl$$proxy0
     */

    @Test
    public void testProxy(){
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.add(1,2);
        proxy.div(4,4);
    }

}
