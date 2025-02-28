
package com.payroll.EmployementPayrollApplicatiom.controller;


import com.payroll.EmployementPayrollApplicatiom.DTO.EmployeeDTO;
import com.payroll.EmployementPayrollApplicatiom.model.Employee;
import com.payroll.EmployementPayrollApplicatiom.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    // Get Employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        Employee employee = service.getEmployeeById(id);
        EmployeeDTO employeeDTO = EmployeeDTO.fromEmployee(employee);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

    // Create a new Employee
    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeDTO.toEmployee();
        Employee savedEmployee = service.addEmployee(employee);
        EmployeeDTO savedEmployeeDTO = EmployeeDTO.fromEmployee(savedEmployee);
        return new ResponseEntity<>(savedEmployeeDTO, HttpStatus.CREATED);
    }

    // Update an existing Employee
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee updatedEmployee = employeeDTO.toEmployee();
        Employee employee = service.updateEmployee(id, updatedEmployee);
        EmployeeDTO updatedEmployeeDTO = EmployeeDTO.fromEmployee(employee);
        return new ResponseEntity<>(updatedEmployeeDTO, HttpStatus.OK);
    }

    // Delete an Employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}




