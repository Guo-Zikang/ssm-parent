package com.atguigu.spring.tx.service;

public interface UserService {
    void checkout(String username, Integer bookID, Integer buyNum) throws Exception;
}
