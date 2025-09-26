package com.wangdapao.spring.controller;

import com.wangdapao.spring.service.BookService;
import com.wangdapao.spring.service.Checkout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private Checkout checkout;

    public void buyBook(Integer userId, Integer bookId){
        bookService.buyBook(userId, bookId);
    }

    public void checkout(Integer userId, Integer[] bookIds){
        checkout.checkout(userId, bookIds);
    }
}
