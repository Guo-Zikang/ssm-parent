package com.atguigu.spring.ioc;

import com.atguigu.spring.ioc.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloTest {
    @Autowired
    User user;

    @Test
    void test01() {
        System.out.println(user);
    }
}
