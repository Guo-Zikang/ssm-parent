package com.atguigu.mybatis.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@MapperScan("com.atguigu.mybatis.mapper")
@Configuration
public class MyBatisConfig {

    @Bean
    PageInterceptor pageInterceptor() {
        //1. 创建分页插件对象
        PageInterceptor pageInterceptor = new PageInterceptor();
        //2. 设置参数
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }
}
