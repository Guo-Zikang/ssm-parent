package com.atguigu.spring02aop;

import com.atguigu.spring02aop.calculator.MathCalculator;
import com.atguigu.spring02aop.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AopTest {
    @Autowired
    MathCalculator mathCalculator;

    @Autowired
    UserService userService;

    @Test
    public void test01() {
/*        System.out.println("mathCalculator = " + mathCalculator);
        mathCalculator.add(10, 20);
        System.out.println("=======================");*/

        mathCalculator.div(10, 0);

//        userService.updateUser();


    }
}
