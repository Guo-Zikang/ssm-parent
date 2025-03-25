package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.bean.Employee;

/**
* @author guozikang
* @description 针对表【employee】的数据库操作Mapper
* @createDate 2025-03-25 22:01:26
* @Entity com.atguigu.mybatis.bean.Employee
*/
public interface EmployeeMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

}
