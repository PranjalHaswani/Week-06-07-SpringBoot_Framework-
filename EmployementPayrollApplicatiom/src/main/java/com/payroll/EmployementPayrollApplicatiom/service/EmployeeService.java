package com.payroll.EmployementPayrollApplicatiom.service;

import com.payroll.EmployementPayrollApplicatiom.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    // List to store Employee objects in-memory
    private final List<Employee> employeeList = new ArrayList<>();

    // Constructor to simulate some initial data
    public EmployeeService() {
        // Simulate adding some initial data into the list
        employeeList.add(new Employee(1L, "John Doe", "Engineering", 50000));
        employeeList.add(new Employee(2L, "Jane Smith", "Marketing", 60000));
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeList);
    }

    // Get employee by ID
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeList.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
        return employee.orElse(null);
    }

    // Add a new employee
    public Employee addEmployee(Employee employee) {
        // Set the id to the next available number (for simulation)
        long nextId = employeeList.size() + 1;
        employee.setId(nextId);
        employeeList.add(employee);
        return employee;
    }

    // Update an existing employee
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        // Find employee by ID and update
        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);
            if (employee.getId().equals(id)) {
                updatedEmployee.setId(id);  // Keep the existing ID
                employeeList.set(i, updatedEmployee);
                return updatedEmployee;
            }
        }
        return null;
    }

    // Delete an employee
    public void deleteEmployee(Long id) {
        employeeList.removeIf(employee -> employee.getId().equals(id));
    }

    // Find employee by name
    public Employee getEmployeeByName(String name) {
        return employeeList.stream()
                .filter(employee -> employee.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }
}
