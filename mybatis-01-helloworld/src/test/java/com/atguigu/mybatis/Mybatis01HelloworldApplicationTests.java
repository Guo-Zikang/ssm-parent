package com.atguigu.mybatis;

import com.atguigu.mybatis.bean.Emp;
import com.atguigu.mybatis.mapper.EmpMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mybatis01HelloworldApplicationTests {

    @Autowired
    EmpMapper empMapper;

    @Test
    void testGetAll() {
        List<Emp> all = empMapper.getAll();

        for (Emp emp : all) {
            System.out.println(emp);
        }
    }

    @Test
    void testCRUD() {
        Emp emp = new Emp();
//        emp.setId(5);
        emp.setEmpName("张三123");
        emp.setAge(19);
        emp.setEmpSalary(11500.0D);
        empMapper.addEmp(emp);
//        empMapper.updateEmp(emp);
//        empMapper.deleteEmpById(5);
        Integer id = emp.getId();
        System.out.println("自增id = " + id);
    }

    @Test
    void contextLoads() {
        System.out.println(empMapper.getClass());
        Emp empById = empMapper.getEmpById(1);
        System.out.println(empById);
    }

}
