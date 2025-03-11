package com.atguigu.spring.tx;

import com.atguigu.spring.tx.dao.AccountDao;
import com.atguigu.spring.tx.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class AccountDaoTest {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private UserService userService;

    @Test
    public void testCheckOut() throws Exception {
        userService.checkout("wangwu", 3, 5);
    }

    @Test
    public void testUpdateByUsername() {
        accountDao.updateBalanceByUsername("zhangsan", new BigDecimal("9.9"));
    }
}
