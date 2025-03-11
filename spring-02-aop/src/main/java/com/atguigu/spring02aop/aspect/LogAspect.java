package com.atguigu.spring02aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(2)
@Component
@Aspect //告诉Spring这个组件是个切面
public class LogAspect {
    @Pointcut("execution(int com.atguigu.spring02aop.calculator.MathCalculator.*(..))")
    public void pointcut() {}

    @Before("pointcut()")
    public void logStart(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String name = signature.getName();

        Object[] args = joinPoint.getArgs();
        System.out.println("【切面 - 日志】【" + name + "】开始，参数列表：" + Arrays.toString(args));
    }

    @After("pointcut()")
    public void logEnd(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("【切面 - 日志】【" + name + "】结束...");
    }

    @AfterThrowing(value = "pointcut()", throwing = "throwable")
    public void logException(JoinPoint joinPoint, Throwable throwable) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("【切面 - 日志】【" + name + "】异常，异常信息：" + throwable.getMessage());
    }

    @AfterReturning(value = "pointcut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String name = signature.getName();

        System.out.println("【切面 - 日志】【" + name + "】返回，返回值：" + result);
    }

    //@Before("args(int, int)")
    public void loghahaha() {
        System.out.println("【切面 - 日志】哈哈哈");
    }

    //@Before("@annotation(com.atguigu.spring02aop.annotation.MyAn)")
    public void check() {
        System.out.println("【切面 - 日志】查询@MyAn注解");
    }
}
