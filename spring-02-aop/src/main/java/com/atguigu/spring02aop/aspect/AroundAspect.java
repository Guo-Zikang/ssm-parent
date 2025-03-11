package com.atguigu.spring02aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class AroundAspect {
    @Pointcut("execution(int com.atguigu.spring02aop.calculator.MathCalculator.*(..))")
    public void pointcut() {}

    /**
     * @Around固定写法
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        //前置
        System.out.println("环绕 - 前置通知，参数" + Arrays.toString(args));
        Object result;
        try {
            result = joinPoint.proceed(args); //执行目标方法，相当于反射 method.invoke()
            System.out.println("环绕 - 返回通知，返回值：" + result);
        } catch (Throwable e) {
            System.out.println("环绕 - 异常通知：" + e.getMessage());
            throw e;
        } finally {
            System.out.println("环绕 - 后置通知");
        }
        return result;
    }
}
