package com.atguigu.spring.ioc.controller;

import com.atguigu.spring.ioc.bean.Person;
import com.atguigu.spring.ioc.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Data
@Controller
public class UserController {
    @Autowired
    UserService abc;

    @Autowired
    Person bill;

//    @Autowired
//    Person[] persons;

    @Autowired
    Map<String, Person> map;
}
