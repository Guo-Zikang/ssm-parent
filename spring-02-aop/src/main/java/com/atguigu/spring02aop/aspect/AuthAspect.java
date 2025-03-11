package com.atguigu.spring02aop.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
@Aspect
public class AuthAspect {
    @Pointcut("execution(int com.atguigu.spring02aop.calculator.MathCalculator.*(..))")
    public void pointcut() {}

    @Before("pointcut()")
    public void logStart() {
        System.out.println("【切面 - 权限】开始");
    }

    @After("pointcut()")
    public void logEnd() {
        System.out.println("【切面 - 权限】结束");
    }

    @AfterThrowing("pointcut()")
    public void logException() {
        System.out.println("【切面 - 权限】异常");
    }

    @AfterReturning("pointcut()")
    public void logReturn() {
        System.out.println("【切面 - 权限】返回");
    }
}
