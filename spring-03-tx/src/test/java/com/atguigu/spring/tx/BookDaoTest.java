package com.atguigu.spring.tx;

import com.atguigu.spring.tx.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class BookDaoTest {

    @Autowired
    private BookDao bookDao;

    @Test
    public void testQuery() {
        BigDecimal bookPriceById = bookDao.getBookPriceById(1);
        System.out.println(bookPriceById);
        BigDecimal bookPriceById2 = bookDao.getBookPriceById(1);
        System.out.println(bookPriceById2);
        BigDecimal bookPriceById3 = bookDao.getBookPriceById(1);
        System.out.println(bookPriceById3);
    }
}
