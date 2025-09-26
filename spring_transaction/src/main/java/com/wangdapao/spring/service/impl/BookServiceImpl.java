package com.wangdapao.spring.service.impl;

import com.wangdapao.spring.dao.BookDao;
import com.wangdapao.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;


    @Override
//    @Transactional(
//            propagation = Propagation.REQUIRES_NEW
//    )
    public void buyBook(Integer userId, Integer bookId) {

        /**
         * 查询余额
         * @param bookId
         */
        Integer price = bookDao.updatePriceByBookId(bookId);

        /**
         * 减库存
         * @param bookId
         */
        bookDao.updateStockByBookId(bookId);

        /**
         * 减余额
         * @param userId
         * @param price
         */
        bookDao.updateUserBalanceByUserId(userId,price);
    }
}
