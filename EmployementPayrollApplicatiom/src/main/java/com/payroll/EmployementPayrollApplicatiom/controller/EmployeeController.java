
package com.payroll.EmployementPayrollApplicatiom.controller;


import com.payroll.EmployementPayrollApplicatiom.DTO.EmployeeDTO;
import com.payroll.EmployementPayrollApplicatiom.model.Employee;
import com.payroll.EmployementPayrollApplicatiom.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Slf4j
public class EmployeeController {

    // Autowire the EmployeeService
    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    // Create a new employee
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.addEmployee(employee);
    }

    // Update an existing employee by ID
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return service.updateEmployee(id, employee);
    }

    // Delete an employee by ID
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
    }

    // Create a new employee using DTO (EmployeeDTO)
    @PostMapping("/create")
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeDTO.toEmployee(); // Convert DTO to Model
        Employee savedEmployee = service.addEmployee(employee); // Save to DB
        return EmployeeDTO.fromEmployee(savedEmployee); // Convert Model back to DTO
    }

    // Get employee by name
    @GetMapping("/get/{name}")
    public EmployeeDTO getEmployee(@PathVariable String name) {
        Employee employee = service.getEmployeeByName(name);
        return EmployeeDTO.fromEmployee(employee);
    }
}




