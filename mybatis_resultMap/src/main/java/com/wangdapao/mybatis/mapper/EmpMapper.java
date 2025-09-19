package com.wangdapao.mybatis.mapper;

import com.wangdapao.mybatis.pojo.Emp;

public interface EmpMapper {

    /**
     * 根据员工id查询员工信息
     * @param empId
     * @return
     */
    Emp getEmpById(Integer empId);
}
