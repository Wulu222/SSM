package com.wangdapao.spring.dao.impl;

import com.wangdapao.spring.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public Integer updatePriceByBookId(Integer bookId) {
        String sql = "select price from t_book where book_id = ?";
        return jdbcTemplate.queryForObject(sql,Integer.class,bookId);

    }

    @Override
    public void updateStockByBookId(Integer bookId) {
        String sql = "update t_book set stock = stock -1 where book_id = ?";
        jdbcTemplate.update(sql,bookId);
    }

    @Override
    public void updateUserBalanceByUserId(Integer userId, Integer price) {
        String sql = "update t_booker set balance = balance - ? where user_id = ?";
        jdbcTemplate.update(sql,price,userId);
    }
}
