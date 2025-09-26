package com.wangdapao.spring.aop.xml;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class LoggerAspect {

    /**
     * 1.在切面中，需要通过指定的注解将方法标识为切点（通知方法）
     * @Before：前置通知 在目标方法执行前执行
     * @After：后置通知 在目标方法后的finally子句中执行的
     * @AfterReturning：返回通知 在目标方法正常返回后执行的
     * @AfterThrowing：异常通知 在目标方法抛出异常后执行的
     * @Around：环绕通知 在目标方法执行前后执行
     *
     * 2.切入点表达式：设置在标识通知的注解的value属性中
     * execution(访问权限符 返回值类型 方法名(参数列表))
     * *表示任意
     * ..表示任意多个参数
     *
     * 3.重用切入点表达式：@Pointcut
     * @Pointcut("execution(* com.wangdapao.spring.aop.annotation.CalculatorImpl.*(..))")
     * public void pointCut(){}
     * @Before("pointCut()")
     * 标注一个公共的切入点表达式，方便其他通知方法调用
     *
     * 4.获取连接点的信息：JoinPoint
     * 获取方法签名：signature
     * 获取方法参数：args
     *
     * 5.切面的优先级：@Order注解设置，默认为Integer的最大值
     * @Order注解中value的值越写，优先级越高
     */



    public void beforeAdviceMethod(JoinPoint joinPoint){
        // 获取方法签名
        Signature signature = joinPoint.getSignature();
        // 获取方法参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect 前置通知 方法名："+ signature.getName()+" 参数："+ Arrays.toString(args));
    }

    public void afterAdviceMethod(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect 后置通知 方法名："+ signature.getName()+" 参数："+ Arrays.toString(args)+"执行完毕");
    }


    public void afterReturningAdviceMethod(JoinPoint joinPoint,Object result){
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect 返回通知 方法名："+ signature.getName()+" 参数："+ Arrays.toString(args)+"返回结果："+result);
    }


    public void afterThrowingAdviceMethod(JoinPoint joinPoint,Throwable ex){
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect 异常通知 方法名："+ signature.getName()+" 参数："+ Arrays.toString(args)+"异常信息："+ex);
    }

    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){
        Object result = null;
        try {
            System.out.println("环绕通知--->前置通知");
            //方法的执行
            result = joinPoint.proceed();
            System.out.println("环绕通知--->返回通知");
        } catch (Throwable e) {
            System.out.println("环绕通知--->异常通知");
            throw new RuntimeException(e);
        } finally {
            System.out.println("环绕通知--->后置通知");
        }
        return result;
    }
}
