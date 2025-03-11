package com.atguigu.spring.ioc.dao;

import com.atguigu.spring.ioc.dataSource.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeliveryDao {
    @Autowired
    MyDataSource dataSource;

    public void saveDelivery() {
        System.out.println("数据源：保存数据 " + dataSource);
    }
}
