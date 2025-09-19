package com.wangdapao.mybatis.mapper;

import com.wangdapao.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {

    /**
     * 插入用户
     * @return
     */
    int insertUser();

    /**
     * 删除用户
     * @return
     */
    int deleteUser();

    /**
     * 修改用户
     * @return
     */
    int updateUser();

    /**
     * 查询一个用户
     * @return
     */
    User getUserById();

    /**
     * 查询所有用户
     * @return
     */
    List<User> getAllUser();
}
