package com.org.oracle.service.impl;

import com.org.oracle.domain.Department;
import com.org.oracle.repository.DepartmentRepository;
import com.org.oracle.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department dept) {
        return departmentRepository.save(dept);
    }

    @Override
    public Department findByDepartmentId(String departmentId) {
        Optional<Department> optional = departmentRepository.findById(departmentId);
        return optional.get();
    }

    @Override
    public void deleteByDepartmentId(String departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public void updateDepartment(Department dept) {
        departmentRepository.save(dept);
    }

    @Override
    public boolean departmentExists(Department dept) {
        return departmentRepository.exists(Example.of(dept));
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public void deleteAll() {
        departmentRepository.deleteAll();
    }
}
