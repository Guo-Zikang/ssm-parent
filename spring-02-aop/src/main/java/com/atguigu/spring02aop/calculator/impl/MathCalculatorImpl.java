package com.atguigu.spring02aop.calculator.impl;

import com.atguigu.spring02aop.calculator.MathCalculator;
import org.springframework.stereotype.Component;

@Component
public class MathCalculatorImpl implements MathCalculator {
    @Override
    public int add(int a, int b) {
        //System.out.println("【日志】 add开始，参数：" + a + ", " + b);
        int res = a + b;
        System.out.println("结果是： " + res);
        //System.out.println("【日志】 add返回，结果：" + res);
        return res;
    }

    @Override
    public int sub(int a, int b) {
        int res = a - b;
        return res;
    }

    @Override
    public int mul(int a, int b) {
        int res = a * b;
        return res;
    }

    @Override
    public int div(int a, int b) {
        System.out.println("目标方法执行...");
        int res = a / b;
        return res;
    }
}
