package com.atguigu.rest.crud;

import com.atguigu.rest.crud.bean.Employee;
import com.atguigu.rest.crud.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class EmployeeDaoTest {

    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void test() {
//        Employee employee = employeeDao.getEmployeeById(4L);
//        System.out.println("employee = " + employee);

//        Employee employee1 = new Employee();
//        employee1.setId(5L);
//        employee1.setName("李四111111");
//        employee1.setAge(18);
//        employee1.setEmail("aaa");
//        employee1.setGender("男");
//        employee1.setAddress("北京");
//        employee1.setSalary(new BigDecimal("12.00"));
//        //employeeDao.addEmployee(employee1);

        employeeDao.deleteEmployeeById(5L);
    }
}
