package com.atguigu.mybatis.service;

import com.atguigu.mybatis.bean.Emp;
import com.atguigu.mybatis.mapper.EmpDynamicSQLMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpService {
    @Autowired
    private EmpDynamicSQLMapper empDynamicSQLMapper;

    @Transactional
    public void updateBatch(List<Emp> emps) {
        empDynamicSQLMapper.updateEmps(emps);
        int i = 1 / 0;
    }
}
