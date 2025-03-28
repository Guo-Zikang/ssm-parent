package com.atguigu.boot.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
//@Component
@ConfigurationProperties(prefix = "dog")
public class DogProperties {
    private String name;
    private Integer age;
    private String gender;
}
