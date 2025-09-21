package com.wangdapao.mybatis.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wangdapao.mybatis.mapper.EmpMapper;
import com.wangdapao.mybatis.pojo.Emp;
import com.wangdapao.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class PageTest {

    @Test
    public void testPage() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
//      开启分页功能
        Page<Object> page = PageHelper.startPage(3, 5);
        List<Emp> emps = mapper.selectByExample(null);
        emps.forEach(System.out::println);

        PageInfo<Object> pageInfo = new PageInfo<>(page, 5);
        System.out.println(pageInfo);
        sqlSession.close();

    }
}
