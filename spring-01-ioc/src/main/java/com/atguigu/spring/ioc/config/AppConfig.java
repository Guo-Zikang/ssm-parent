package com.atguigu.spring.ioc.config;

import ch.qos.logback.core.CoreConstants;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(CoreConstants.class)
@ComponentScan(basePackages = "com.atguigu.spring")
@Configuration
public class AppConfig {
}
