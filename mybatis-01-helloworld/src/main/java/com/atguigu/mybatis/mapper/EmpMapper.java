package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.bean.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper {
    //按照id查询员工
    Emp getEmpById(Integer id);

    //查询所有员工
    List<Emp> getAll();

    //添加员工
    void addEmp(Emp emp);

    //修改员工
    void updateEmp(Emp emp);

    //删除员工
    void deleteEmpById(Integer id);
}
