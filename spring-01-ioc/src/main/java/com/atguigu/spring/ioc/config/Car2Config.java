package com.atguigu.spring.ioc.config;

import com.atguigu.spring.ioc.bean.Car2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Car2Config {

    @Bean
    public Car2 car2() {
        return new Car2();
    }
}
