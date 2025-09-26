package com.wangdapao.spring.service.impl;

import com.wangdapao.spring.dao.UserDao;
import com.wangdapao.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userDaoImpl")
    private UserDao userDao1;

    @Override
    public void saveUser() {
        userDao1.saveUser();
    }
}
