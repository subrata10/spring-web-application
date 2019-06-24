package com.org.oracle.service;

import com.org.oracle.domain.Department;

import java.util.List;

public interface DepartmentService {

    Department saveDepartment(Department dept);

    Department findByDepartmentId(String departmentId);

    void deleteByDepartmentId(String departmentId);

    void updateDepartment(Department dept);

    boolean departmentExists(Department dept);

    List<Department> findAll();

    void deleteAll();
}
