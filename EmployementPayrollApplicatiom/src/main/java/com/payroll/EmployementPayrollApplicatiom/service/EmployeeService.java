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
   private final List<Employee> employeeList = new ArrayList<>();
//
//    public EmployeeService() {
//        employeeList.add(new Employee(1L, "John Doe", List.of("Engineering"), 50000, null, "male", "new hire", "profilePic.jpg"));
//        employeeList.add(new Employee(2L, "Jane Smith", List.of("Marketing"), 60000, null, "female", "team lead", "profilePic2.jpg"));
//    }
//
//    public List<Employee> getAllEmployees() {
//        return new ArrayList<>(employeeList);
//    }
//
//    public Employee addEmployee(Employee employee) {
//        long nextId = employeeList.size() + 1;
//        employee.setId(nextId);
//        employeeList.add(employee);
//        return employee;
//    }
//
//    public Employee updateEmployee(Long id, Employee updatedEmployee) {
//        for (int i = 0; i < employeeList.size(); i++) {
//            Employee employee = employeeList.get(i);
//            if (employee.getId().equals(id)) {
//                updatedEmployee.setId(id);
//                employeeList.set(i, updatedEmployee);
//                return updatedEmployee;
//            }
//        }
//        return null;
//    }
//
//    public void deleteEmployee(Long id) {
//        employeeList.removeIf(employee -> employee.getId().equals(id));
//    }
//
    public Employee getEmployeeByName(String name) {
        return employeeList.stream()
                .filter(employee -> employee.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Autowired
    private EmployeeRepository employeeRepository;

//    public Employee getEmployeeById(Long id) {
//        Optional<Employee> employee = employeeRepository.findById(id);
//        if (employee.isEmpty()) {
//            throw new EmployeeNotFoundException("Employee not found with ID: " + id);
//        }
//        return employee.get();
//    }
// Create or Add Employee
public Employee addEmployee(Employee employee) {
    return employeeRepository.save(employee); // Save to DB
}

    // Get All Employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll(); // Fetch all employees from DB
    }

    // Get Employee by ID
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee not found with ID: " + id);
        }
        return employee.get();
    }

    // Update Employee by ID
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if (existingEmployee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee not found with ID: " + id);
        }
        updatedEmployee.setId(id); // Ensure the ID is not modified
        return employeeRepository.save(updatedEmployee); // Update and save to DB
    }

    // Delete Employee by ID
    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee not found with ID: " + id);
        }
        employeeRepository.deleteById(id); // Delete from DB
    }

    // Method to get all employees in the Sales department
    public List<Employee> getEmployeesInSalesDepartment() {
        return employeeRepository.findEmployeesInSalesDepartment();
    }

}
