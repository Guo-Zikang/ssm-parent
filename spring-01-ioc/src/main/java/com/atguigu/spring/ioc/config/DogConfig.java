package com.atguigu.spring.ioc.config;

import com.atguigu.spring.ioc.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class DogConfig {

    @Bean
    public Dog dog01() {
        return new Dog();
    }
/*
    @Bean
    public Dog dog02() {
        Dog dog = new Dog();
        dog.setName("02");
        return dog;
    }

    @Bean
    public Dog dog2() {
        return new Dog();
    }

    @Bean
    public Dog dog3() {
        return new Dog();
    }*/
}
