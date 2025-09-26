package com.wangdapao.spring.dao;

public interface BookDao {

    /**
     * 修改图书价格
     * @param bookId
     * @return
     */
    Integer updatePriceByBookId(Integer bookId);

    /**
     * 修改图书库存
     * @param bookId
     */
    void updateStockByBookId(Integer bookId);

    /**
     * 修改用户余额
     * @param userId
     * @param price
     */
    void updateUserBalanceByUserId(Integer userId, Integer price);
}
