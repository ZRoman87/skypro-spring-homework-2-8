package com.example.skyprospringhomework28.service;

import com.example.skyprospringhomework28.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeServiceImpl employeeService;
    private final List<Employee> employees;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
        employees = employeeService.printEmployees();
    }

    @Override
    public Employee getEmployeeWithMaxSalaryForDepartment(String department) {
        return employees.stream().filter(e -> e.getDepartment().equals(department)).max(Comparator.comparingDouble(Employee::getSalary)).get();
    }
    @Override
    public Employee getEmployeeWithMinSalaryForDepartment(String department) {
        return employees.stream().filter(e -> e.getDepartment().equals(department)).min(Comparator.comparingDouble(Employee::getSalary)).get();
    }
    @Override
    public List<Employee> printEmployeesListForDepartment(String department) {
        return employees.stream().filter(e -> e.getDepartment().equals(department)).collect(Collectors.toList());
    }
    @Override
    public List<Employee> printEmployeesListByDepartment() {
        return employees.stream().sorted(Comparator.comparing(Employee::getDepartment)).collect(Collectors.toList());
    }

}
