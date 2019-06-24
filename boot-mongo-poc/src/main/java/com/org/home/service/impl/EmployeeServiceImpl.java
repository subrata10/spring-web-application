package com.org.oracle.service.impl;

import com.org.oracle.domain.Employee;
import com.org.oracle.repository.EmployeeRepository;
import com.org.oracle.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findByEmployeeId(String employeeId) {
        return employeeRepository.findById(employeeId).get();
    }

    @Override
    public void deleteByEmployeeId(String employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public boolean employeeExists(Employee employee) {
        return employeeRepository.exists(Example.of(employee));
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }
}
