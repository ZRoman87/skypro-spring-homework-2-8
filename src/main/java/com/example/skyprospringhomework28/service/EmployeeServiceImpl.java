package com.example.skyprospringhomework28.service;

import com.example.skyprospringhomework28.exeption.EmployeeAlreadyAddedException;
import com.example.skyprospringhomework28.exeption.EmployeeNotFoundException;
import com.example.skyprospringhomework28.exeption.EmployeeStorageIsFullException;
import com.example.skyprospringhomework28.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final int CAPACITY = 5;
    public List<Employee> employees = new ArrayList<>(CAPACITY);

    @Override
    public Employee addEmployee(String firstName, String lastName, String department, double salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        } else if (employees.size() == CAPACITY) {
            throw new EmployeeStorageIsFullException();
        } else {
            employees.add(employee);
            return employee;
        }
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName, String department, double salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employees.remove(employee)) {
            return employee;
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, String department, double salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employees.contains(employee)) {
            return employee;
        } else {
            throw new EmployeeNotFoundException();
        }
    }
    @Override
    public List<Employee> printEmployees() {
        return Collections.unmodifiableList(employees);
    }

}
