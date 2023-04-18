package com.example.skyprospringhomework28.controller;

import com.example.skyprospringhomework28.model.Employee;
import com.example.skyprospringhomework28.service.DepartmentServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentServiceImpl departmentService;
    public DepartmentController(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/max-salary")
    public Employee getEmployeeWithMaxSalaryForDepartment(@RequestParam(required = false) String department) {
        return departmentService.getEmployeeWithMaxSalaryForDepartment(department);
    }

    @GetMapping(path = "/min-salary")
    public Employee getEmployeeWithMinSalaryForDepartment(@RequestParam(required = false) String department) {
        return departmentService.getEmployeeWithMinSalaryForDepartment(department);
    }

    @GetMapping(path = "/all", params = "department")
    public List<Employee> printEmployeesListForDepartment(@RequestParam(required = false) String department) {
        return departmentService.printEmployeesListForDepartment(department);
    }
    @GetMapping(path = "/all")
    public Map<String, List<Employee>> printEmployeesListByDepartment() {
        return departmentService.printEmployeesListByDepartment();
    }

}
