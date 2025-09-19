package com.wangdapao.mybatis.mapper;

import com.wangdapao.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper {

    /**
     * 根据username查询用户信息
     * @param username
     * @return
     */
    User getUserByUsername(String username);

    /**
     * 登录查询 用户名和密码
     * @param username password
     * @return
     */
    User checkLogin(String username, String password);

    /**
     * 登录查询 用户名和密码（Map）
     * @param  map
     * @return
     */
    User checkLoginByMap(Map<String, Object> map);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 登录查询 用户名和密码（@Param注解）
     * @param  username password
     * @return
     */
    User checkLoginByParam(@Param(value = "username") String username,@Param("password") String password);

}
