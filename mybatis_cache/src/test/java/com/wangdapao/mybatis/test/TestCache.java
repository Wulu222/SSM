package com.wangdapao.mybatis.test;

import com.wangdapao.mybatis.mapper.CacheMapper;
import com.wangdapao.mybatis.pojo.User;
import com.wangdapao.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestCache {

    /**
     * 测试一级缓存
     * 默认情况下，MyBatis启用一级缓存，即SqlSession级别的缓存
     * 一级缓存是SqlSession级别的，同一个SqlSession对象获取的缓存数据是相同的
     * 使一级缓存失效的四种情况：
     * 1. 不同的SqlSession对象获取缓存数据
     * 2. 同一个SqlSession对象，但是查询条件不同
     * 3. 同一个SqlSession对象，两次查询之间执行了增删改操作
     * 4. 同一个SqlSession对象，手动清除了缓存
     *
     *
     * 测试二级缓存
     * 二级缓存是SqlSessionFactory级别，多个SqlSession对象共享一个SqlSessionFactory对象
     * 二级缓存是全局变量中的<setting name="cacheEnabled" value="true"/>，默认是开启的
     * 二级缓存是SqlSessionFactory对象中缓存的，即一个SqlSessionFactory对象对应一个二级缓存
     * 二级缓冲的条件
     * 1.全局变量中<setting name="cacheEnabled" value="true"/>，默认开启，不添加也可以
     * 2.当前mapper.xml文件中的<cache/>
     * 3.二级缓冲必须在SqlSession提交或关闭后才生效
     * 4.查询转换的实体类必须实现序列化接口（Serializable）
     *
     * 失效情况：
     * 两次查询之间执行了增删改操作
     *
     */


    @Test
    public void testCache() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession1 = factory.openSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        User user1 = mapper1.getUserById(1);
        System.out.println(user1);
        sqlSession1.close();
        SqlSession sqlSession2 = factory.openSession();
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        User user2 = mapper2.getUserById(1);
        System.out.println(user2);
        sqlSession2.close();
    }


    @Test
    public void testGetUserById() {
        SqlSession sqlSession1 = SqlSessionUtil.getSqlSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        User user1 = mapper1.getUserById(1);
        System.out.println(user1);

//        mapper1.addUser(new User(null, "张无忌", "123456", 21, '男', null));
        sqlSession1.clearCache();

        User user2 = mapper1.getUserById(1);
        System.out.println(user2);

//        SqlSession sqlSession2 = SqlSessionUtil.getSqlSession();
//        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
//        User user3 = mapper2.getUserById(1);
//        System.out.println(user3);

        sqlSession1.close();
//        sqlSession2.close();
    }
}
