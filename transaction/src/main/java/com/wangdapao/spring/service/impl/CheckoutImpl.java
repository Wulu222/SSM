package com.wangdapao.spring.service.impl;

import com.wangdapao.spring.service.BookService;
import com.wangdapao.spring.service.Checkout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CheckoutImpl implements Checkout {

    @Autowired
    private BookService bookService;

    @Override
//    @Transactional
    public void checkout(Integer userId, Integer[] bookIds) {
        for(Integer bookId : bookIds){
            bookService.buyBook(userId, bookId);
        }
    }
}
