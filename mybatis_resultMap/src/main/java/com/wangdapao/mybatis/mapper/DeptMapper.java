package com.wangdapao.mybatis.mapper;

import com.wangdapao.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {

    /**
     * 获取员工信息，并且查询员工所对应的部门信息，分布查询第二步
     * @param deptId
     * @return
     */
    Dept getDeptById(@Param("deptId") Integer deptId);

    /**
     * 获取部门信息，并且查询部门中所有员工信息 多对一
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByDeptId(@Param("deptId") Integer deptId);

    /**
     * 获取部门信息，并且查询部门中员工信息，分步查询第一步
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByStepOne(@Param("deptId") Integer deptId);


}
