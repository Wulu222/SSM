package com.wangdapao.mybatis.mapper;

import com.wangdapao.mybatis.pojo.Emp;
import java.util.List;

public interface EmpMapper {
    int deleteByPrimaryKey(Integer empId);

    int insert(Emp row);

    Emp selectByPrimaryKey(Integer empId);

    List<Emp> selectAll();

    int updateByPrimaryKey(Emp row);
}