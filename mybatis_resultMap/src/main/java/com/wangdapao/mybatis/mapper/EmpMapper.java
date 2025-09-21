package com.wangdapao.mybatis.mapper;

import com.wangdapao.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    /**
     * 根据员工id查询员工信息
     * @param empId
     * @return
     */
    Emp getEmpById(@Param("empId") Integer empId);

    /**
     * 获取员工和部门信息
     * @param empId
     * @return
     */
    Emp getEmpAndDeptById(@Param("empId") Integer empId);

    /**
     * 获取员工信息，并且查询员工所对应的部门信息，分布查询第一步
     * @param empId
     * @return
     */
    Emp getEmpAndDeptByStepOne(@Param("empId")Integer empId);



    /**
     * 根据部门id查询员工信息
     * @param deptId
     * @return
     */
    List<Emp> getEmpByDeptId(@Param("deptId") Integer deptId);
}
