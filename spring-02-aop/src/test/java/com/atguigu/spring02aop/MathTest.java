package com.atguigu.spring02aop;

import com.atguigu.spring02aop.calculator.MathCalculator;
import com.atguigu.spring02aop.calculator.impl.MathCalculatorImpl;
import com.atguigu.spring02aop.proxy.dynamic.DynamicProxy;
import com.atguigu.spring02aop.proxy.statics.CalculatorStaticProxy;
import com.atguigu.spring02aop.service.UserService;
import com.atguigu.spring02aop.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MathTest {
    @Test
    public void test03() {
        MathCalculator proxyInstance = (MathCalculator) DynamicProxy.getProxyInstance(new MathCalculatorImpl());
        proxyInstance.add(1, 2);
        System.out.println("===================================");

        UserService instance = (UserService) DynamicProxy.getProxyInstance(new UserServiceImpl());
        instance.saveUser();
        System.out.println("===================================");
        proxyInstance.div(10, 0);
    }

    @Test
    public void test02() {
        //1. 原生对象
        MathCalculator target = new MathCalculatorImpl();
        //target.add(1, 2);

        InvocationHandler h = new InvocationHandler() {
            /**
             * proxy 代理对象：经纪人
             * method 代理对象准备调用目标对象的方法
             * args 方法调用传递的参数
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //System.out.println("看看参数：" + Arrays.asList(args));
                Object result = method.invoke(target, args);
                return result;
            }
        };

        /**
         * ClassLoader loader, 目标对象的类加载器
         * Class<?>[] interfaces, 目标对象实现的接口
         * InvocationHandler h
         */
        MathCalculator proxyInstance = (MathCalculator) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                h
        );

        int add = proxyInstance.add(1,2);
        System.out.println(add);
    }

    @Test
    public void test01() {
        // 目标对象
        MathCalculator target = new MathCalculatorImpl();
        target.add(1, 2);
        System.out.println("=====================");

        MathCalculator proxy = new CalculatorStaticProxy(target);
        int added = proxy.add(1, 2);
        System.out.println(added);
    }
}
