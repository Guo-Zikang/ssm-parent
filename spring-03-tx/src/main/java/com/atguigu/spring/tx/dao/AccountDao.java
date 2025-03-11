package com.atguigu.spring.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Component
public class AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 按照username扣减账户余额
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateBalanceByUsername(String username, BigDecimal delta) {
        String sql = "update account set balance = balance - ? where username = ?";
        jdbcTemplate.update(sql, delta, username);
    }
}
