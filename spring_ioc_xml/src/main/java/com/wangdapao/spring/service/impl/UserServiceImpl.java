package com.wangdapao.spring.service.impl;

import com.wangdapao.spring.dao.UserDao;
import com.wangdapao.spring.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        userDao.save();
    }
}
