package com.atguigu.spring.tx;
import java.math.BigDecimal;

import com.atguigu.spring.tx.bean.Book;
import com.atguigu.spring.tx.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Spring03TxApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    BookDao bookDao;

    @Test
    void deleteBookById() {
        bookDao.deleteBookById(4);
    }

    @Test
    void updateBookStock() {
        bookDao.updateBookStock(4, 2);
    }

    @Test
    void testAddBook() {
        Book book = new Book();
        book.setBookName("西游记");
        book.setPrice(new BigDecimal("19.9"));
        book.setStock(100);
        bookDao.addBook(book);
    }

    @Test
    void testQuery() {
        Book bookById = bookDao.getBookById(1);
        System.out.println(bookById);
    }

    @Test
    void contextLoads() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

}
