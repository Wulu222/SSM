package com.wangdapao.mybatis.mapper;

import com.wangdapao.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialSQLMapper {

    /**
     * 模糊查询
     * @param mohu
     * @return
     */
    List<User> getUserLike(@Param("mohu")String mohu);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteMore(@Param("ids") String ids);

    /**
     * 获取指定表中的数据
     * @param tableName
     * @return
     */
    List<User> getUserByTableName(@Param("tableName") String tableName);

    /**
     * 添加用户信息并获取添加后自增的主键
     * @param user
     */
    int insertUser(User user);
}
