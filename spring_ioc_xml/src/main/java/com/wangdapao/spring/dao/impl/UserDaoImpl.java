package com.wangdapao.spring.dao.impl;

import com.wangdapao.spring.dao.UserDao;

public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("保存用户数据");
    }
}
