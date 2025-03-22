package com.atguigu.mybatis;

import com.atguigu.mybatis.bean.Customer;
import com.atguigu.mybatis.bean.Emp;
import com.atguigu.mybatis.bean.Order;
import com.atguigu.mybatis.mapper.CustomerMapper;
import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.mapper.EmpReturnValueMapper;
import com.atguigu.mybatis.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@SpringBootTest
class Mybatis01HelloworldApplicationTests {

    @Autowired
    EmpMapper empMapper;

    @Autowired
    EmpReturnValueMapper empReturnValueMapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    CustomerMapper customerMapper;

    @Test
    void test04() {
        Customer customer = customerMapper.getCustomerByIdWithOrders(1L);
        System.out.println("customer = " + customer);
    }

    @Test
    void test03() {
        Order order = orderMapper.getOrderByIdWithCustomer(1L);
        System.out.println("order = " + order);
    }

    @Test
    void test02() {
        Emp empById = empReturnValueMapper.getEmpById(1);
        System.out.println(empById);
    }

    @Test
    void testCountEmp() {
        Long countEmp = empReturnValueMapper.countEmp();
        System.out.println("countEmp = " + countEmp);

        BigDecimal empSalaryById = empReturnValueMapper.getEmpSalaryById(1);
        System.out.println("empSalaryById = " + empSalaryById);

        empReturnValueMapper.getAll().forEach(System.out::println);
        System.out.println("====================================");

        Map<Integer, Emp> allEmpMap = empReturnValueMapper.getAllEmpMap();
        System.out.println("allEmpMap = " + allEmpMap);
        Emp emp = allEmpMap.get(1);
        System.out.println("emp = " + emp);

    }

    @Test
    void testGetAll() {
        List<Emp> all = empMapper.getAll();

        for (Emp emp : all) {
            System.out.println(emp);
        }
    }

    @Test
    void testCRUD() {
        Emp emp = new Emp();
//        emp.setId(5);
        emp.setEmpName("张三123");
        emp.setAge(19);
        emp.setEmpSalary(11500.0D);
        empMapper.addEmp(emp);
//        empMapper.updateEmp(emp);
//        empMapper.deleteEmpById(5);
        Integer id = emp.getId();
        System.out.println("自增id = " + id);
    }

    @Test
    void contextLoads() {
        System.out.println(empMapper.getClass());
        Emp empById = empMapper.getEmpById(1);
        System.out.println(empById);
    }

}
