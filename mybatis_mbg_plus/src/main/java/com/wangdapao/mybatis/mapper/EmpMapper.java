package com.wangdapao.mybatis.mapper;

import com.wangdapao.mybatis.pojo.Emp;
import com.wangdapao.mybatis.pojo.EmpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmpMapper {
    long countByExample(EmpExample example);

    int deleteByExample(EmpExample example);

    int deleteByPrimaryKey(Integer empId);

    int insert(Emp row);

    int insertSelective(Emp row);

    List<Emp> selectByExample(EmpExample example);

    Emp selectByPrimaryKey(Integer empId);

    int updateByExampleSelective(@Param("row") Emp row, @Param("example") EmpExample example);

    int updateByExample(@Param("row") Emp row, @Param("example") EmpExample example);

    int updateByPrimaryKeySelective(Emp row);

    int updateByPrimaryKey(Emp row);
}