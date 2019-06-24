package com.org.home.service;

import com.org.home.domain.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Employee findByEmployeeId(String employeeId);

    void deleteByEmployeeId(String employeeId);

    void updateEmployee(Employee employee);

    boolean employeeExists(Employee employee);

    List<Employee> findAll();

    void deleteAll();

}
