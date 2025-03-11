package com.atguigu.spring.ioc.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class User implements InitializingBean, DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("实现了 DisposableBean 接口的 destroy 方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("实现了 InitializingBean 接口的 afterPropertiesSet 方法");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("@PostConstruct......");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy......");
    }

    private String username;
    private String password;

    private Car car;

    @Autowired
    public void setCar(Car car) {
        System.out.println("自动注入：属性值 " + car);
        this.car = car;
    }

    public User() {
        System.out.println("User构造器执行");
    }

    public void initUser() {
        System.out.println("@Bean初始化：initUser");
    }

    public void destroyUser() {
        System.out.println("@Bean销毁：destroyUser");
    }
}
