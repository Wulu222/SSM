package com.wangdapao.spring.test;

import com.wangdapao.spring.controller.UserController;
import com.wangdapao.spring.dao.UserDao;
import com.wangdapao.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByAnnotation {

    /**
     * @Component: 将类标识为组件
     * @Controller: 将类标识为控制器
     * @Service: 将类标识为服务
     * @Repository: 将类标识为数据访问对象
     *
     * 通过注解的bean的id默认为小驼峰，即类名的首字母小写后的驼峰
     * 也可以自定义注解，需要在注解中配置value属性
     *
     * @Autowired: 自动注入
     * 注解的三种位置：1. 属性位置 2. setter方法位置 3. 构造器位置（分别对应依赖注入的位置）
     * 原理：
     * 1.默认根据byType进行注入，如果找到多个相同类型的bean，则根据byName进行注入
     * 2，如果byName找不到（id和属性名不一样），会报NoUniqueBeanDefinitionException
     * 3.可以使用@Qualifier注解精准定位到 需要的类的bean
     */

    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController userController = ioc.getBean("controller",UserController.class);
        System.out.println(userController);
        UserService userService = ioc.getBean("userServiceImpl",UserService.class);
        System.out.println(userService);
        UserDao userDao = ioc.getBean("userDaoImpl",UserDao.class);
        System.out.println(userDao);

    }

    @Test
    public void testAutowired(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController userController = ioc.getBean(UserController.class);
        userController.saveUser();

    }
}
