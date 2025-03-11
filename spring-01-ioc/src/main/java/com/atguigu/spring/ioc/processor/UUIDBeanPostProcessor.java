package com.atguigu.spring.ioc.processor;

import com.atguigu.spring.ioc.annotation.UUID;
import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class UUIDBeanPostProcessor implements BeanPostProcessor {

    @Override
    @SneakyThrows
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(UUID.class) && field.getType().equals(String.class)) {
                field.setAccessible(true);
                String s = java.util.UUID.randomUUID().toString();
                System.out.println("11111111111111111111111");
                field.set(bean, s);
            }
        }
        return bean;
    }
}
