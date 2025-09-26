package com.wangdapao.spring.aop.xml;

import org.springframework.stereotype.Component;

@Component
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int a, int b) {
        int ruselt = 0;
        ruselt = a + b;
        System.out.println("方法内部"+ruselt);
        return ruselt;
    }

    @Override
    public int sub(int a, int b) {
        int ruselt = 0;
        ruselt = a - b;
        System.out.println("方法内部"+ruselt);
        return ruselt;
    }

    @Override
    public int mul(int a, int b) {
        int ruselt = 0;
        ruselt = a * b;
        System.out.println("方法内部"+ruselt);
        return ruselt;
    }

    @Override
    public double div(int a, int b) {
        double ruselt = 0;
        ruselt = a / b;
        System.out.println("方法内部"+ruselt);
        return ruselt;
    }
}
