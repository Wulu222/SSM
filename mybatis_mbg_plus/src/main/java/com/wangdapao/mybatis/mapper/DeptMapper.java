package com.wangdapao.mybatis.mapper;

import com.wangdapao.mybatis.pojo.Dept;
import com.wangdapao.mybatis.pojo.DeptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    long countByExample(DeptExample example);

    int deleteByExample(DeptExample example);

    int deleteByPrimaryKey(Integer deptId);

    int insert(Dept row);

    int insertSelective(Dept row);

    List<Dept> selectByExample(DeptExample example);

    Dept selectByPrimaryKey(Integer deptId);

    int updateByExampleSelective(@Param("row") Dept row, @Param("example") DeptExample example);

    int updateByExample(@Param("row") Dept row, @Param("example") DeptExample example);

    int updateByPrimaryKeySelective(Dept row);

    int updateByPrimaryKey(Dept row);
}