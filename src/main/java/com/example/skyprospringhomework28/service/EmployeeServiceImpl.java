package com.example.skyprospringhomework28.service;

import com.example.skyprospringhomework28.exeption.EmployeeAlreadyAddedException;
import com.example.skyprospringhomework28.exeption.EmployeeNotFoundException;
import com.example.skyprospringhomework28.exeption.EmployeeStorageIsFullException;
import com.example.skyprospringhomework28.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    //static Employee[] employees = new Employee[10];
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
    public Employee getEmployeeWithMaxSalaryForDepartment(String department) {
        return employees.stream().filter(e -> e.getDepartment().equals(department)).max(Comparator.comparingDouble(Employee::getSalary)).get();
    }

    @Override
    public Employee getEmployeeWithMinSalaryForDepartment(String department) {
        return employees.stream().filter(e -> e.getDepartment().equals(department)).min(Comparator.comparingDouble(Employee::getSalary)).get();
    }
    @Override
    public List<Employee> printEmployees() {
        return Collections.unmodifiableList(employees);
    }
    @Override
    public List<Employee> printEmployeesListForDepartment(String department) {
        return printEmployees().stream().filter(e -> e.getDepartment().equals(department)).collect(Collectors.toList());
    }

    @Override
    public List<Employee> printEmployeesListByDepartment() {
        return printEmployees().stream().sorted(Comparator.comparing(Employee::getDepartment)).collect(Collectors.toList());
    }

}
