package com.atguigu.mybatis;

import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GeneratorTest {
    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    void test01() {
        Employee employee = employeeMapper.selectByPrimaryKey(1L);
        System.out.println(employee);

        Employee employee1 = new Employee();
        employee1.setId(1L);
        employee1.setAge(18);
        employeeMapper.updateByPrimaryKeySelective(employee1);
    }
}
