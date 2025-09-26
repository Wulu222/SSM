package com.wangdapao.spring.service;

public interface Checkout {

    /**
     * 批量下单
     * @param userId
     * @param bookIds
     */
    void checkout(Integer userId, Integer[] bookIds);
}
