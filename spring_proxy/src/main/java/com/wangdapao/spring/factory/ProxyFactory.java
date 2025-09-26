package com.wangdapao.spring.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {
     private Object target;
     public ProxyFactory(Object target){
         this.target = target;
     }

     public Object getProxy(){
         /**
          * (ClassLoader loader,类加载器
          * Class<?>[] interfaces,被代理对象所实现的所有接口
          * InvocationHandler h 代理逻辑处理
          */
         ClassLoader classLoader = this.getClass().getClassLoader();

         Class<?>[] interfaces = target.getClass().getInterfaces();
         InvocationHandler h = new InvocationHandler() {
             @Override
             public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                 //proxy: 代理对象 menthod: 被代理对象方法 args: 方法参数
                 Object result = null;
                 try {
                     System.out.println("开始事务");
                     System.out.println("日志，方法："+method.getName()+"，参数"+ Arrays.toString( args));
                     result = method.invoke(target, args);
                     System.out.println("提交事务");
                     System.out.println("日志，方法:"+method.getName()+"，结果"+result);
                 } catch (Exception e) {
                     System.out.println("出现错误"+e);
                     e.printStackTrace();
                 }  finally {
                     System.out.println("关闭连接");
                 }

                 return  result;
             }
         };
         return Proxy.newProxyInstance(classLoader,interfaces,h);
     }
}
