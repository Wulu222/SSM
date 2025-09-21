package com.wangdapao.mybatis.mapper;

import com.wangdapao.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSqlMapper {

    /**
     * 获取用户列表 if标签
     * @param user
     * @return
     */
    List<User> getUserByCondition(User user);

    /**
     * 获取用户列表 choose标签
     * @param user
     * @return
     */
    List<User> getUserByChoose(User user);

    /**
     * 批量添加 foreach标签
     * @param users
     * @return
     */
    void insertUserByForeach(@Param("users") List<User> users);

    /**
     * 批量删除 foreach标签
     * @param userIds
     * @return
     */
    void deleteUserByForeach(@Param("userIds") Integer[] userIds);

    /**
     * 批量查询 foreach标签
     * @param userIds
     * @return
     */
    List getUserByForeach(@Param("userIds") Integer[] userIds);
}
