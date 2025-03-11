package com.atguigu.spring.ioc.processor;

import com.atguigu.spring.ioc.bean.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyTestBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof User) {
            System.out.println("PostProcessAfterInitialization方法......");
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof User hello) {
            System.out.println("PostProcessBeforeInitialization方法......");
            hello.setUsername("张三测试");
        }
        return bean;
    }
}
