package com.example.skyprospringhomework28.service;

import com.example.skyprospringhomework28.model.Employee;

import java.util.List;

public interface DepartmentService {

    Employee getEmployeeWithMaxSalaryForDepartment(String department);
    Employee getEmployeeWithMinSalaryForDepartment(String department);
    List<Employee> printEmployeesListForDepartment(String department);
    List<Employee> printEmployeesListByDepartment();
}
