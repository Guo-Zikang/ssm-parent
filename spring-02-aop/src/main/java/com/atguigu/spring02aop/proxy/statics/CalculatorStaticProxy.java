package com.atguigu.spring02aop.proxy.statics;

import com.atguigu.spring02aop.calculator.MathCalculator;

public class CalculatorStaticProxy implements MathCalculator {

    private MathCalculator target;

    public CalculatorStaticProxy(MathCalculator mc) {
        this.target = mc;
    }

    @Override
    public int add(int a, int b) {
        System.out.println("【日志】 add开始，参数：" + a + ", " + b);
        int res = target.add(a, b);
        System.out.println("【日志】 add返回，结果：" + res);
        return res;
    }

    @Override
    public int sub(int a, int b) {
        int res = target.sub(a, b);
        return res;
    }

    @Override
    public int mul(int a, int b) {
        int res = target.mul(a, b);
        return res;
    }

    @Override
    public int div(int a, int b) {
        int res = target.div(a, b);
        return res;
    }

}
