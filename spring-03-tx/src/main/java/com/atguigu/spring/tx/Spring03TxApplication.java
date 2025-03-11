package com.atguigu.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@SpringBootApplication
@EnableTransactionManagement
public class Spring03TxApplication {



    public static void main(String[] args) {
        SpringApplication.run(Spring03TxApplication.class, args);
    }

}
