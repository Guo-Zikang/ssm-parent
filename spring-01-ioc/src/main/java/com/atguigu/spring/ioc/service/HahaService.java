package com.atguigu.spring.ioc.service;

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Getter
@Data
@Service
public class HahaService implements EnvironmentAware, BeanNameAware {
    private Environment env;
    private String name;

    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment;
    }

    public String getOsType() {
        return env.getProperty("OS");
    }

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }
}
