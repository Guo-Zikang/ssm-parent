package com.atguigu.rest.crud.service.impl;

import com.atguigu.rest.crud.bean.Employee;
import com.atguigu.rest.crud.dao.EmployeeDao;
import com.atguigu.rest.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service // controller -> service -> dao
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee = employeeDao.getEmployeeById(id);
        return employee;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        // 防null处理
        // 1. 去数据库查询员工原来的值
        // 2. 将页面带来的不为null的属性赋值给员工
        Long id = employee.getId();
        if (id == null) {
            return;
        }
        Employee employeeById = employeeDao.getEmployeeById(id);
        if (StringUtils.hasText(employee.getName())) {
            employeeById.setName(employee.getName());
        }
        if (employee.getAge() != null) {
            employeeById.setAge(employee.getAge());
        }
        if (StringUtils.hasText(employee.getEmail())) {
            employeeById.setEmail(employee.getEmail());
        }
        if (StringUtils.hasText(employee.getGender())) {
            employeeById.setGender(employee.getGender());
        }
        if (StringUtils.hasText(employee.getAddress())) {
            employeeById.setAddress(employee.getAddress());
        }
        if (employee.getSalary() != null) {
            employeeById.setSalary(employee.getSalary());
        }
        employeeDao.updateEmployee(employeeById);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeDao.deleteEmployeeById(id);
    }

    @Override
    public List<Employee> getList() {
        return employeeDao.getlist();
    }
}
