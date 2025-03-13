package com.atguigu.rest.crud.dao.impl;

import com.atguigu.rest.crud.bean.Employee;
import com.atguigu.rest.crud.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Employee getEmployeeById(Long id) {
        String sql = "select * from employee where id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class), id);
    }

    @Override
    public void addEmployee(Employee employee) {
        String sql = "insert into employee(name, age, email, gender, address, salary) values(?, ?, ?, ?, ?, ?)";
        int update = jdbcTemplate.update(sql,
                employee.getName(),
                employee.getAge(),
                employee.getEmail(),
                employee.getGender(),
                employee.getAddress(),
                employee.getSalary());
        System.out.println("新增成功，影响行数：" + update);
    }

    @Override
    public void updateEmployee(Employee employee) {
        String sql = "update employee set name = ?, age = ?, email = ?, gender = ?, address = ?, salary = ? where id = ?";
        int update = jdbcTemplate.update(sql,
                employee.getName(),
                employee.getAge(),
                employee.getEmail(),
                employee.getGender(),
                employee.getAddress(),
                employee.getSalary(),
                employee.getId());
        System.out.println("更新成功，影响行数：" + update);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        String sql = "delete from employee where id = ?";
        int update = jdbcTemplate.update(sql, id);
        System.out.println("删除成功，影响行数：" + update);
    }
}
