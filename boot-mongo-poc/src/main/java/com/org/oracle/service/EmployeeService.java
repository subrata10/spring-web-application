package com.org.oracle.service;

import com.org.oracle.domain.Employee;

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
