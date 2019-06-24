package com.org.home.controller;

import com.org.home.domain.Employee;
import com.org.home.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.findAll();

        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

       //employees.forEach(employee -> employee.add(linkTo(methodOn(EmployeeController.class).getAllEmployees()).withRel("employees")));
        //employees.forEach(employee -> employee.add(linkTo(methodOn(EmployeeController.class).getEmployeeById(employee.getEmployeeId())).withSelfRel()));

        return ResponseEntity.ok(employees);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
        Employee employee = employeeService.findByEmployeeId(id);

        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        //employee.add(linkTo(methodOn(EmployeeController.class).getEmployeeById(id)).withSelfRel());

        return ResponseEntity.ok(employee);
    }

    @PostMapping("/employee")
    public ResponseEntity<?> saveEmployee(@RequestBody Employee emp) {
        if (employeeService.employeeExists(emp)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        Employee employee = employeeService.saveEmployee(emp);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/employees/employee/{id}")
                .buildAndExpand(emp.getEmployeeId()).toUri();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(location);

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable String id, @RequestBody Employee emp) {
        Employee employee = employeeService.findByEmployeeId(id);

        if (employee == null) {
            return ResponseEntity.notFound().build();
        }

        employeeService.updateEmployee(emp);

        //emp.add(linkTo(methodOn(EmployeeController.class).getEmployeeById(emp.getEmployeeId())).withSelfRel());

        return ResponseEntity.ok(emp);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id) {
        employeeService.deleteByEmployeeId(id);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/employee")
    public ResponseEntity<?> deleteAll() {
        employeeService.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
