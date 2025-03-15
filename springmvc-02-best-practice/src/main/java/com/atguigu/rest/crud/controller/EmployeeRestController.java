package com.atguigu.rest.crud.controller;

import com.atguigu.rest.crud.bean.Employee;
import com.atguigu.rest.crud.common.R;
import com.atguigu.rest.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin // 允许跨域
@RequestMapping("/api/v1")
@RestController
public class EmployeeRestController {

    @Autowired
    EmployeeService employeeService;

    /**
     * code: 业务的状态码，比如200表示成功，剩下的都表示失败
     * msg: 服务器返回给前端的提示信息
     * data: 服务器返回给前端的数据
     * {
     *     "code": 300,
     *     "msg": "余额不足",
     *     "data": null
     * }
     */

    /**
     * 按照id查询员工
     * @param id
     * @return
     */
//    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    @GetMapping("/employee/{id}")
    public R<Employee> get(@PathVariable("id") Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        System.out.println("查询方法执行......");
        return R.success(employee);
    }

    /**
     * 新增员工，要求前端将员工的json放在请求体中
     * @param employee
     * @return
     */
    @PostMapping("/employee")
    public R add(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return R.success();
    }

    /**
     * 更新员工信息，要求前端将员工的json放在请求体中，其中id必须有
     * @param employee
     * @return
     */
    @PutMapping("/employee")
    public R update(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
        return R.success();
    }

    /**
     * 按照id删除员工
     * @param id
     * @return
     */
    @DeleteMapping("/employee/{id}")
    public R delete(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);
        return R.success();
    }

    /**
     * 查询所有员工
     */
    @GetMapping("/employees")
    public R all() {
        List<Employee> employees = employeeService.getList();
        return R.success(employees);
    }
}
