package com.atguigu.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class Mybatis01HelloworldApplication {

    public static void main(String[] args) {
        SpringApplication.run(Mybatis01HelloworldApplication.class, args);
    }

}
