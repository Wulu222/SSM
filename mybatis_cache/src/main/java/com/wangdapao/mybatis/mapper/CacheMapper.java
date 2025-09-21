package com.wangdapao.mybatis.mapper;

import com.wangdapao.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface CacheMapper {

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    User getUserById(@Param("userId") Integer userId);

    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);
}
