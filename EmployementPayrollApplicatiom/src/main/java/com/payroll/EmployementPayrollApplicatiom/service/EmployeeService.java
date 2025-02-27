
package com.payroll.EmployementPayrollApplicatiom.service;

import com.payroll.EmployementPayrollApplicatiom.model.Employee;
import com.payroll.EmployementPayrollApplicatiom.repository.EmployeeRepository;
import com.payroll.EmployementPayrollApplicatiom.validation.EmployeeNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeService {
    // List to store Employee objects in-memory
 private final List<Employee> employeeList = new ArrayList<>();

    // Constructor to simulate some initial data
    public EmployeeService() {
        // Simulate adding some initial data into the list
        employeeList.add(new Employee(1L, "John Doe", "Engineering", 50000));
        employeeList.add(new Employee(2L, "Jane Smith", "Marketing", 60000));
    }
//
//    // Get all employees
//    public List<Employee> getAllEmployees() {
//        return new ArrayList<>(employeeList);
//    }
//
//    // Get employee by ID
//    public Employee getEmployeeById(Long id) {
//        Optional<Employee> employee = employeeList.stream()
//                .filter(e -> e.getId().equals(id))
//                .findFirst();
//        return employee.orElse(null);
//    }
//
    // Add a new employee
    public Employee addEmployee(Employee employee) {
        // Set the id to the next available number (for simulation)
        long nextId = employeeList.size() + 1;
        employee.setId(nextId);
        employeeList.add(employee);
        return employee;
    }
//
    // Update an existing employee
//    public Employee updateEmployee(Long id, Employee updatedEmployee) {
//        // Find employee by ID and update
//        for (int i = 0; i < employeeList.size(); i++) {
//            Employee employee = employeeList.get(i);
//            if (employee.getId().equals(id)) {
//                updatedEmployee.setId(id);  // Keep the existing ID
//                employeeList.set(i, updatedEmployee);
//                return updatedEmployee;
//            }
//        }
//        return null;
//    }
//
//    // Delete an employee
//    public void deleteEmployee(Long id) {
//        employeeList.removeIf(employee -> employee.getId().equals(id));
//    }
//
//    // Find employee by name
//    public Employee getEmployeeByName(String name) {
//        return employeeList.stream()
//                .filter(employee -> employee.getName().equalsIgnoreCase(name))
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("Employee not found"));
//    }

    // List to store Employee objects in-memory
   // private final List<Employee> employeeList = new ArrayList<>();

//    // Constructor to simulate some initial data
//    public EmployeeService() {
//        log.info("Initializing Employee Service with initial data.");
//        employeeList.add(new Employee(1L, "John Doe", "Engineering", 50000));
//        employeeList.add(new Employee(2L, "Jane Smith", "Marketing", 60000));
//        log.info("Initial data added.");
//    }
//
    // Get all employees
 public List<Employee> getAllEmployees() {
  log.info("Fetching all employees.");
        return new ArrayList<>(employeeList);
  }
//
//    // Get employee by ID
//public Employee getEmployeeById(Long id) {
//  log.info("Fetching employee with ID: {}", id);
//        Optional<Employee> employee = employeeList.stream()
//                .filter(e -> e.getId().equals(id))
//                .findFirst();
//        if (employee.isPresent()) {
//            log.info("Employee found: {}", employee.get().getName());
//            return employee.get();
//        } else {
//            log.warn("Employee with ID: {} not found", id);
//            return null;
//        }
//  }
//
   // Add a new employee
//    public Employee addEmployee(Employee employee) {
//        log.info("Adding new employee: {}", employee.getName());
//        long nextId = employeeList.size() + 1;
//        employee.setId(nextId);
//        employeeList.add(employee);
//        log.info("Employee added with ID: {}", nextId);
//        return employee;
//    }

    // Update an existing employee
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        log.info("Updating employee with ID: {}", id);
        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);
            if (employee.getId().equals(id)) {
                updatedEmployee.setId(id);  // Keep the existing ID
                employeeList.set(i, updatedEmployee);
                log.info("Employee with ID: {} updated", id);
                return updatedEmployee;
            }
        }
        log.warn("Employee with ID: {} not found for update", id);
        return null;
    }

    // Delete an employee
    public void deleteEmployee(Long id) {
        log.info("Deleting employee with ID: {}", id);
        employeeList.removeIf(employee -> employee.getId().equals(id));
        log.info("Employee with ID: {} deleted", id);
    }

   // Find employee by name
    public Employee getEmployeeByName(String name) {
        log.info("Fetching employee with name: {}", name);
        return employeeList.stream()
                .filter(employee -> employee.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> {
                    log.warn("Employee with name: {} not found", name);
                    return new RuntimeException("Employee not found");
                });
    }


    //Section-04(Throw User friendly Exception) UC-03
    @Autowired
    private EmployeeRepository employeeRepository;

    // Get employee by ID with exception handling if not found
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee not found with ID: " + id);
        }
        return employee.get();
    }
}



