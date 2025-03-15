package com.atguigu.rest.crud.dao;

import com.atguigu.rest.crud.bean.Employee;

import java.util.List;

public interface EmployeeDao {
    /**
     * 根据id查询员工信息
     * @param id
     * @return
     */
    Employee getEmployeeById(Long id);

    /**
     * 添加员工信息
     * @param employee
     * @return
     */
    void addEmployee(Employee employee);

    /**
     * 更新员工信息
     * @param employee
     * @return
     */
    void updateEmployee(Employee employee);

    /**
     * 按照id删除员工信息
     * @param id
     * @return
     */
    void deleteEmployeeById(Long id);

    List<Employee> getlist();
}
