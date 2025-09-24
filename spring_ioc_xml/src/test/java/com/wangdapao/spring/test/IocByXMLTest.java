package com.wangdapao.spring.test;

import com.wangdapao.spring.pojo.Clazz;
import com.wangdapao.spring.pojo.People;
import com.wangdapao.spring.pojo.Student;
import com.wangdapao.spring.pojo.Teacher;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocByXMLTest {

    /**
     * getBean的三种方式
     * 1.getBean(String beanName)
     * 需要强转
     * 2.getBean(Class<?> requiredType)
     * 不能有多种同类型的bean
     * 3.getBean(String beanName, Class<?> requiredType)
     */

    @Test
    public void testIoc(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Student student = (Student) ioc.getBean("studentOne");
//        Student student = ioc.getBean(Student.class);
        Student student = ioc.getBean("studentOne", Student.class);
//        People student = ioc.getBean(Student.class);
//        People student = ioc.getBean(People.class);
        System.out.println(student);
    }

    @Test
    public void testDIBySetting(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = ioc.getBean("studentTwo",Student.class);
        System.out.println(student);
    }

    @Test
    public void testDIByConstructor(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = ioc.getBean("studentThree",Student.class);
        System.out.println(student);
    }

    @Test
    public void testDI(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = ioc.getBean("studentFour",Student.class);
        System.out.println(student);
    }

    @Test
    public void testDIForRef(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

        Student student = ioc.getBean("studentFive",Student.class);
        System.out.println(student);
        System.out.println("----------------------------");

        Student student2 = ioc.getBean("studentSix",Student.class);
        System.out.println(student2);
        System.out.println("----------------------------");
        /**
         * 因为studentFive和studentSix引用了同一个Class的bean，所以class的bean会被重写，体现为两个输出的数据都一样
         */

        Student student3 = ioc.getBean("studentSeven",Student.class);
        System.out.println(student3);
    }

    @Test
    public void testDIFotArray(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = ioc.getBean("studentEight",Student.class);
        System.out.println(student);
    }

    @Test
    public void testDIFotList(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Clazz classTwo = ioc.getBean("classTwo", Clazz.class);
        System.out.println(classTwo);

        Clazz classThree = ioc.getBean("classThree", Clazz.class);
        System.out.println(classThree);
    }

    @Test
    public void testDIFotMap(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Teacher teacherOne = ioc.getBean("teacherOne", Teacher.class);
        System.out.println(teacherOne);

        Teacher teacherTwo = ioc.getBean("teacherTwo", Teacher.class);
        System.out.println(teacherTwo);
    }

    @Test
    public void testDIForP(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Teacher teacherThree = ioc.getBean("teacherThree", Teacher.class);
        System.out.println(teacherThree);
    }
}
