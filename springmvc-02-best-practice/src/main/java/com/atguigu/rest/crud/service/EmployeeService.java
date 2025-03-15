package com.atguigu.rest.crud.service;

import com.atguigu.rest.crud.bean.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getEmployeeById(Long id);

    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployeeById(Long id);

    List<Employee> getList();
}
