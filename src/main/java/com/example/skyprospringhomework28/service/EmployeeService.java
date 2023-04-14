package com.example.skyprospringhomework28.service;

import com.example.skyprospringhomework28.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, String department, double salary);
    Employee removeEmployee(String firstName, String lastName, String department, double salary);
    Employee findEmployee(String firstName, String lastName, String department, double salary);
    List<Employee> printEmployees();

}
