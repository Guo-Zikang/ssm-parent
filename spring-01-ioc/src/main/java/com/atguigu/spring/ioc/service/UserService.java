package com.atguigu.spring.ioc.service;

import com.atguigu.spring.ioc.bean.Dog;
import com.atguigu.spring.ioc.bean.Person;
import com.atguigu.spring.ioc.dao.UserDao;
import jakarta.annotation.Resource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Data
@Service
public class UserService {

    @Autowired
    Person abc;

    @Resource
    UserDao userDao;

//    @Autowired(required = false)
//    Dog ab;
}
