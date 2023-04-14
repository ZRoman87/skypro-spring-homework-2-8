package com.example.skyprospringhomework28.controller;

import com.example.skyprospringhomework28.service.EmployeeServiceImpl;
import com.example.skyprospringhomework28.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/employee/add")
    public Employee add(@RequestParam(required = false) String firstName,
                        @RequestParam(required = false) String lastName,
                        @RequestParam(required = false) String department,
                        @RequestParam(required = false) double salary
    ) {
        return employeeService.addEmployee(firstName, lastName, department, salary);
    }

    @GetMapping(path = "/employee/remove")
    public Employee remove(@RequestParam(required = false) String firstName,
                           @RequestParam(required = false) String lastName,
                           @RequestParam(required = false) String department,
                           @RequestParam(required = false) double salary
    ) {
        return employeeService.removeEmployee(firstName, lastName, department, salary);
    }

    @GetMapping(path = "/employee/find")
    public Employee find(@RequestParam(required = false) String firstName,
                         @RequestParam(required = false) String lastName,
                         @RequestParam(required = false) String department,
                         @RequestParam(required = false) double salary
    )  {
        return employeeService.findEmployee(firstName, lastName, department, salary);
    }
    @GetMapping(path = "/employee/print")
    public List<Employee> print() {
        return employeeService.printEmployees();
    }
}
