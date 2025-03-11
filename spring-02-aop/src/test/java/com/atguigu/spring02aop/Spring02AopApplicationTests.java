package com.atguigu.spring02aop;

import com.atguigu.spring02aop.calculator.MathCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Spring02AopApplicationTests {

    @Autowired
    MathCalculator mathCalculator;

    @Test
    void contextLoads() {
        int add = mathCalculator.add(1, 2);
        System.out.println(add);
    }

}
