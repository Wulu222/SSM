package com.wangdapao.mybatis;

import com.wangdapao.mybatis.mapper.EmpMapper;
import com.wangdapao.mybatis.pojo.Emp;
import com.wangdapao.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestMBG {
    @Test
    public void testSelectByPrimaryKey(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.selectByPrimaryKey(1);
        System.out.println(emp);
        sqlSession.close();
    }
}
