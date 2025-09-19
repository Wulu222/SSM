package com.wangdapao.mybatis.test;

import com.wangdapao.mybatis.mapper.UserMapper;
import com.wangdapao.mybatis.pojo.User;
import com.wangdapao.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
//    private SqlSession sqlSession;
//    private UserMapper mapper;
//
//    @Before//@Before表示在测试方法执行之前执行，获取mapper接口的代理对象
//    public void test() throws IOException {
//        //获取输入流
//        InputStream io = Resources.getResourceAsStream("mybatis-config.xml");
//        //获取SqlSessionFactoryBuilder对象
//        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//        //获取SqlSessionFactory对象
//        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(io);
//        //获取sql会话对象SqlSession对象，是mybatis的核心对象，能执行sql语句
////        sqlSession = factory.openSession();
//        sqlSession = factory.openSession(true);
//        //获取UserMapper接口的代理对象,可以代理接口的所有方法
//        mapper = sqlSession.getMapper(UserMapper.class);
//    }

    @Test
    public void testInsertUser() throws IOException {
        //获取输入流
        InputStream io = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory对象
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(io);
        //获取sql会话对象SqlSession对象，是mybatis的核心对象，能执行sql语句
//        sqlSession = factory.openSession();
        SqlSession sqlSession = factory.openSession(true);
        //获取UserMapper接口的代理对象,可以代理接口的所有方法
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int insertUser = mapper.insertUser();
        System.out.println(insertUser);
        //提交事务
//        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int delectUser = mapper.deleteUser();
        System.out.println(delectUser);
        sqlSession.close();
    }

    @Test
    public void testUpdateUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int updateUser = mapper.updateUser();
        System.out.println(updateUser);
        sqlSession.close();
    }

    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById();
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> allUser = mapper.getAllUser();
        allUser.forEach(System.out::println);
        sqlSession.close();
    }

}
