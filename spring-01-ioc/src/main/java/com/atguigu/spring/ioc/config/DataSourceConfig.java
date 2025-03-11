package com.atguigu.spring.ioc.config;

import com.atguigu.spring.ioc.dataSource.MyDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DataSourceConfig {

    @Profile({"dev", "default"})
    @Bean
    public MyDataSource dev() {
        MyDataSource dataSource = new MyDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/dev");
        dataSource.setUsername("dev_user");
        dataSource.setPassword("dev_password");
        return dataSource;
    }

    @Profile("test")
    @Bean
    public MyDataSource test() {
        MyDataSource dataSource = new MyDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("test_user");
        dataSource.setPassword("test_password");
        return dataSource;
    }

    @Profile("pro")
    @Bean
    public MyDataSource pro() {
        MyDataSource dataSource = new MyDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/pro");
        dataSource.setUsername("pro_user");
        dataSource.setPassword("pro_password");
        return dataSource;
    }
}
