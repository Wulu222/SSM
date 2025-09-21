package com.wangdapao.mybatis.test;

import com.wangdapao.mybatis.mapper.DynamicSqlMapper;
import com.wangdapao.mybatis.pojo.User;
import com.wangdapao.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class TestDynamicSql {

    @Test
    public void testGetUserByCondition(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        User user = new User(null,"", null, null, null,null);
        List<User> list = mapper.getUserByCondition(user);
        list.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testGetUserByChoose(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        User user = new User(null,"wulux", null, 100, null,null);
        List<User> list = mapper.getUserByChoose(user);
        list.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testInsertUserByForeach(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        User user1=new User(null,"赵敏", "854891",25, '女',"<EMAIL>");
        User user2=new User(null,"小龙女", "123456",25, '女',"<EMAIL>");
        User user3=new User(null,"魏无羡", "123456",30, '男',"<EMAIL>");
        User user4=new User(null,"扶苏", "123456",2500, '男',"<EMAIL>");
        User user5=new User(null,"胡亥", "123456",2489, '男',"<EMAIL>");
        List<User> users = Arrays.asList(user1, user2, user3, user4, user5);
        mapper.insertUserByForeach(users);
        sqlSession.close();
    }

    @Test
    public void testDeleteUserByForeach(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        Integer[] userIds = new Integer[]{5, 6, 7};
        mapper.deleteUserByForeach(userIds);
        sqlSession.close();
    }

    @Test
    public void testGetUserByForeach(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        Integer[] userIds = new Integer[]{1,2,3,4};
        List<User> list = mapper.getUserByForeach(userIds);
        list.forEach(System.out::println);
        sqlSession.close();
    }
}
