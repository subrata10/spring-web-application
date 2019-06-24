package com.org.home.controller;

import com.org.home.domain.Department;
import com.org.home.service.DepartmentService;
import com.org.home.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentService.findAll();

        if (departments.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        // @TODO Need to add HATEOS
        return ResponseEntity.ok(departments);
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable String departmentId) {
        Department department = departmentService.findByDepartmentId(departmentId);

        if (department == null) {
            return ResponseEntity.noContent().build();
        }

        // @TODO Need to add HATEOS

        return ResponseEntity.ok(department);
    }

    @PostMapping("/department")
    ResponseEntity<?> saveDepartment(@RequestBody Department dept) {

        if (departmentService.departmentExists(dept)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }


        Department department = departmentService.saveDepartment(dept);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/departments/department/{id}")
                .buildAndExpand(department.getDepartmentId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/department/{id}")
    public ResponseEntity<?> updateDepartment(@PathVariable String id, @RequestBody Department dept) {
        Department department = departmentService.findByDepartmentId(id);

        if (department == null) {
            return ResponseEntity.notFound().build();
        }

        departmentService.saveDepartment(dept);

        // @todo : Need to add HATEOS

        return ResponseEntity.ok(dept);

    }


    @DeleteMapping("/department/{deptId}")
    public ResponseEntity<?> deleteDepartment(@PathVariable String deptId) {
        departmentService.deleteByDepartmentId(deptId);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/department")
    public ResponseEntity<?> deleteAll() {
        departmentService.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
