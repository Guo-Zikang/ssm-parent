package com.atguigu.rest.crud.controller;

import com.atguigu.rest.crud.bean.Employee;
import com.atguigu.rest.crud.common.R;
import com.atguigu.rest.crud.service.EmployeeService;
import com.atguigu.rest.crud.vo.req.EmployeeAddVo;
import com.atguigu.rest.crud.vo.req.EmployeeUpdateVo;
import com.atguigu.rest.crud.vo.resp.EmployeeRespVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin // 允许跨域
@RequestMapping("/api/v1")
@RestController
@Tag(name = "员工管理", description = "员工管理相关接口")
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
    @Operation(summary = "按照id查询员工")
    @Parameters({
            @Parameter(name = "id", description = "员工id", in = ParameterIn.PATH, required = true)
    })
    public R get(@PathVariable("id") Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        System.out.println("查询方法执行......");
        EmployeeRespVo employeeRespVo = new EmployeeRespVo();
        BeanUtils.copyProperties(employee, employeeRespVo);
        return R.success(employeeRespVo);
    }

    /**
     * 新增员工，要求前端将员工的json放在请求体中
     * @param vo
     * @return
     */
    @PostMapping("/employee")
    @Operation(summary = "新增员工")
    public R add(@RequestBody @Valid EmployeeAddVo vo) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(vo, employee);

        employeeService.addEmployee(employee);
        return R.success();

/*        if (!result.hasErrors()) {

        }

        Map<String, String> errorsMap = new HashMap<>();
        for (FieldError fieldError : result.getFieldErrors()) {
            errorsMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return R.error(500, "校验失败", errorsMap);*/
    }

    /**
     * 更新员工信息，要求前端将员工的json放在请求体中，其中id必须有
     * @param vo
     * @return
     */
    @PutMapping("/employee")
    @Operation(summary = "按照id更新员工信息")
    public R update(@RequestBody @Valid EmployeeUpdateVo vo) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(vo, employee);
        employeeService.updateEmployee(employee);
        return R.success();
    }

    /**
     * 按照id删除员工
     * @param id
     * @return
     */
    @DeleteMapping("/employee/{id}")
    @Operation(summary = "按照id删除员工")
    public R delete(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);
        return R.success();
    }

    /**
     * 查询所有员工
     */
    @GetMapping("/employees")
    @Operation(summary = "查询所有员工")
    public R all() {
        List<Employee> employees = employeeService.getList();

        List<EmployeeRespVo> list = employees.stream()
                .map(employee -> {
                    EmployeeRespVo vo = new EmployeeRespVo();
                    BeanUtils.copyProperties(employee, vo);
                    return vo;
                }).toList();

        return R.success(list);
    }
}
