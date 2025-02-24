package com.payroll.EmployementPayrollApplicatiom.service;

import com.payroll.EmployementPayrollApplicatiom.DTO.EmployeeDTO;
import com.payroll.EmployementPayrollApplicatiom.model.Employee;
import com.payroll.EmployementPayrollApplicatiom.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        if (repository.existsById(id)) {
            updatedEmployee.setId(id);
            return repository.save(updatedEmployee);
        }
        return null;
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Employee not found");
        }
    }
}




