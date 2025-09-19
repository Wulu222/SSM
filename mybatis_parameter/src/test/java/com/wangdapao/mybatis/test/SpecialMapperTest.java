package com.wangdapao.mybatis.test;

import com.wangdapao.mybatis.mapper.SpecialSQLMapper;
import com.wangdapao.mybatis.pojo.User;
import com.wangdapao.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class SpecialMapperTest {

    @Test
    public void testSpecialSQL() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> a = mapper.getUserLike("a");
        System.out.println(a);
        sqlSession.close();
    }

    @Test
    public void testDeleteMore() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        int result = mapper.deleteMore("8,9,10");
        System.out.println(result);
        sqlSession.close();
    }

    @Test
    public void testGetUserByTableName() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> user = mapper.getUserByTableName("t_user");
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        User user = new User(null, "张三丰", "123456", 18, "男", "123@123.com");
        int result = mapper.insertUser(user);
        System.out.println(result);
        System.out.println(user);
        sqlSession.close();
    }
}
