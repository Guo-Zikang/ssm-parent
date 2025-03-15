package com.atguigu.rest.crud;

import com.atguigu.rest.crud.bean.Employee;
import com.atguigu.rest.crud.dao.EmployeeDao;
import com.atguigu.rest.crud.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class EmployeeDaoTest {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    EmployeeService employeeService;

    @Test
    public void test() {
//        Employee employee = employeeDao.getEmployeeById(4L);
//        System.out.println("employee = " + employee);

        Employee employee1 = new Employee();
        employee1.setId(6L);
//        employee1.setName("李四111111");
//        employee1.setAge(18);
        employee1.setEmail("123@qq.com");
//        employee1.setGender("男");
//        employee1.setAddress("北京");
//        employee1.setSalary(new BigDecimal("12.00"));
//        employeeDao.addEmployee(employee1);

        employeeService.updateEmployee(employee1);
//        employeeDao.deleteEmployeeById(5L);
    }
}
