package com.atguigu.spring.tx.dao;

import com.atguigu.spring.tx.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;


@Component
public class BookDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 按照id查询图书
     */
    public Book getBookById(Integer id) {
        String sql = "select * from book where id = ?";
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
        return book;
    }

    /**
     * 添加图书
     */
    public void addBook(Book book) {
        String sql = "insert into book(bookName, price, stock) values(?,?,?)";
        jdbcTemplate.update(sql, book.getBookName(), book.getPrice(), book.getStock());
    }

    /**
     * 按照图书ID修改图书库存
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateBookStock(Integer id, Integer num) {
        String sql = "update book set stock = stock - ? where id = ?";
        jdbcTemplate.update(sql, num, id);
    }

    /**
     * 删除图书
     */
    public void deleteBookById(Integer id) {
        String sql = "delete from book where id = ?";
        jdbcTemplate.update(sql, id);
    }

    /**
     * 根据图书id读取价格。
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public BigDecimal getBookPriceById(Integer id) {
        String sql = "select price from book where id = ?";
        BigDecimal price = jdbcTemplate.queryForObject(sql, BigDecimal.class, id);
        BigDecimal price2 = jdbcTemplate.queryForObject(sql, BigDecimal.class, id);
        BigDecimal price3 = jdbcTemplate.queryForObject(sql, BigDecimal.class, id);
        return price;
    }
}
