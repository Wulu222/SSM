package com.wangdapao.mybatis.mapper;

import com.wangdapao.mybatis.pojo.Dept;
import java.util.List;

public interface DeptMapper {
    int deleteByPrimaryKey(Integer deptId);

    int insert(Dept row);

    Dept selectByPrimaryKey(Integer deptId);

    List<Dept> selectAll();

    int updateByPrimaryKey(Dept row);
}