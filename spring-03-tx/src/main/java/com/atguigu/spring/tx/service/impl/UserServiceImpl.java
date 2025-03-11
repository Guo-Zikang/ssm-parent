package com.atguigu.spring.tx.service.impl;

import com.atguigu.spring.tx.bean.Book;
import com.atguigu.spring.tx.dao.AccountDao;
import com.atguigu.spring.tx.dao.BookDao;
import com.atguigu.spring.tx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private AccountDao accountDao;

    @Override
    @Transactional(timeout = 3, rollbackFor = Exception.class)
    public void checkout(String username, Integer bookID, Integer buyNum) throws Exception {
        //1. 根据ID查询图书信息
        Book book = bookDao.getBookById(bookID);
        //2. 查询图书价格
        BigDecimal price = book.getPrice();
        //3. 扣减余额
        BigDecimal money = price.multiply(new BigDecimal(buyNum));
        accountDao.updateBalanceByUsername(username, money);

        //4. 扣减库存
        bookDao.updateBookStock(bookID, buyNum);

        int i = 10 / 0;

    }
}
