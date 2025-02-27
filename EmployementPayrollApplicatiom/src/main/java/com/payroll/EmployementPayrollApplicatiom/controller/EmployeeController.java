
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
//
//    // Get all employees
//    @GetMapping
//    public List<Employee> getAllEmployees() {
//        return service.getAllEmployees();
//    }
//
//    // Get employee by ID
//    @GetMapping("/{id}")
//    public Employee getEmployeeById(@PathVariable Long id) {
//        return service.getEmployeeById(id);
//    }
//
//    // Create a new employee
//    @PostMapping
//    public Employee addEmployee(@RequestBody Employee employee) {
//        return service.addEmployee(employee);
//    }
//
//    // Update an existing employee by ID
//    @PutMapping("/{id}")
//    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
//        return service.updateEmployee(id, employee);
//    }
//
//    // Delete an employee by ID
//    @DeleteMapping("/{id}")
//    public void deleteEmployee(@PathVariable Long id) {
//        service.deleteEmployee(id);
//    }
//
//    // Create a new employee using DTO (EmployeeDTO)
//    @PostMapping("/create")
//    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
//        Employee employee = employeeDTO.toEmployee(); // Convert DTO to Model
//        Employee savedEmployee = service.addEmployee(employee); // Save to DB
//        return EmployeeDTO.fromEmployee(savedEmployee); // Convert Model back to DTO
//    }
//
//    // Get employee by name
//    @GetMapping("/get/{name}")
//    public EmployeeDTO getEmployee(@PathVariable String name) {
//        Employee employee = service.getEmployeeByName(name);
//        return EmployeeDTO.fromEmployee(employee);
//    }


    // Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        log.info("GET request received for all employees.");
        List<Employee> employees = service.getAllEmployees();
        log.info("Returning {} employees", employees.size());
        return employees;
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        log.info("GET request received for employee with ID: {}", id);
        Employee employee = service.getEmployeeById(id);
        if (employee != null) {
            log.info("Employee with ID: {} found", id);
        } else {
            log.warn("Employee with ID: {} not found", id);
        }
        return employee;
    }


    // Update an existing employee by ID
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        log.info("PUT request received to update employee with ID: {}", id);
        Employee updatedEmployee = service.updateEmployee(id, employee);
        if (updatedEmployee != null) {
            log.info("Employee with ID: {} updated", id);
        } else {
            log.warn("Employee with ID: {} not found for update", id);
        }
        return updatedEmployee;
    }

    // Delete an employee by ID
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        log.info("DELETE request received to delete employee with ID: {}", id);
        service.deleteEmployee(id);
        log.info("Employee with ID: {} deleted", id);
    }

    // Create a new employee using DTO (EmployeeDTO)
    @PostMapping("/create")

    //Section-04(Data validation by using @Valid))UC-01
    public EmployeeDTO createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        log.info("POST request received to create a new employee using DTO.");
        Employee employee = employeeDTO.toEmployee(); // Convert DTO to Model
        Employee savedEmployee = service.addEmployee(employee); // Save to DB
        log.info("Employee created and saved with ID: {}", savedEmployee.getId());
        return EmployeeDTO.fromEmployee(savedEmployee); // Convert Model back to DTO
    }

    // Get employee by name
    @GetMapping("/get/{name}")
    public EmployeeDTO getEmployee(@PathVariable String name) {
        log.info("GET request received for employee with name: {}", name);
        Employee employee = service.getEmployeeByName(name);
        log.info("Employee with name: {} found", name);
        return EmployeeDTO.fromEmployee(employee);
    }
}


