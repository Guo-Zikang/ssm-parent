package com.atguigu.spring02aop.service.impl;

import com.atguigu.spring02aop.annotation.MyAn;
import com.atguigu.spring02aop.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Override
    public void saveUser() {
        System.out.println("业务：保存用户");
    }

    @MyAn
    @Override
    public void updateUser() {
        System.out.println("业务：查询用户");
    }
}
