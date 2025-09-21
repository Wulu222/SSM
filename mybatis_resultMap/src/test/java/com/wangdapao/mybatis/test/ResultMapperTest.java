package com.wangdapao.mybatis.test;

import com.wangdapao.mybatis.mapper.DeptMapper;
import com.wangdapao.mybatis.mapper.EmpMapper;
import com.wangdapao.mybatis.pojo.Dept;
import com.wangdapao.mybatis.pojo.Emp;
import com.wangdapao.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class ResultMapperTest {

    @Test
    public void testGetEmpById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpById(1);
        System.out.println(emp);
        sqlSession.close();
    }

    @Test
    public void testGetEmpAndDeptById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptById(1);
        System.out.println(emp);
        sqlSession.close();
    }

    @Test
    public void testGetEmpAndDeptByStepOne() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByStepOne(1);
        System.out.println(emp.getEmpId());
        sqlSession.close();
    }

    @Test
    public void testGetDeptAndEmpByDeptId() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByDeptId(1);
        System.out.println(dept);
        sqlSession.close();
    }

    @Test
    public void testGetDeptAndEmpByStepOne() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByStepOne(1);
        System.out.println(dept.getDeptName());
        sqlSession.close();
    }
}
