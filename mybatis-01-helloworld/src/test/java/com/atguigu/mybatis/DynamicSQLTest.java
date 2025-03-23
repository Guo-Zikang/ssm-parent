package com.atguigu.mybatis;

import com.atguigu.mybatis.bean.Emp;
import com.atguigu.mybatis.mapper.EmpDynamicSQLMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class DynamicSQLTest {

    @Autowired
    EmpDynamicSQLMapper empDynamicSQLMapper;

    @Test
    public void test03() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<Emp> emps = empDynamicSQLMapper.getEmpsByIdIn(list);
        System.out.println(emps);
    }

    @Test
    public void test02() {
//        List<Emp> emps = empDynamicSQLMapper.getEmpByNameAndSalaryWhen("tom", new BigDecimal("5000"));
        List<Emp> emps = empDynamicSQLMapper.getEmpByNameAndSalaryWhen(null, null);
        System.out.println(emps);

    }

    @Test
    public void test01() {
        Emp emp = new Emp();
        emp.setId(7);
        emp.setEmpName("123666999haha");
        emp.setAge(70);
        emp.setEmpSalary(1999.0D);

        empDynamicSQLMapper.updateEmp(emp);
    }

    @Test
    public void test() {
        List<Emp> emps = empDynamicSQLMapper.getEmpByNameAndSalary(null, new BigDecimal("666.66"));
        System.out.println(emps);
    }
}
