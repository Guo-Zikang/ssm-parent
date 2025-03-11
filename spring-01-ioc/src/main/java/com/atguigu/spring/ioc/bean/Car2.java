package com.atguigu.spring.ioc.bean;

import com.atguigu.spring.ioc.annotation.UUID;
import lombok.Data;

@Data
public class Car2 {

    //@UUID
    private String id;

    public Car2() {
        System.out.println("Car2 Constructor......");
    }
}
