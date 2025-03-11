package com.atguigu.spring.ioc.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:dog.properties")
@Data
public class Dog {
    @Value("旺财")
    private String name;

    @Value("${dog.age}")
    private int age;

    private String color;

    @Value("#{T(java.util.UUID).randomUUID().toString()}")
    private String id;

    @Value("#{'hello world'.substring(0, 5)}")
    private String msg;

    @Value("#{new int[]{1, 2, 3}}")
    private int[] array;

    public Dog() {
        System.out.println("Dog constructor");
    }

}
