package com.payroll.EmployementPayrollApplicatiom.DTO;
import com.payroll.EmployementPayrollApplicatiom.model.Employee;

public class EmployeeDTO {
    private String name;
    private double salary;

    // Default constructor
    public EmployeeDTO() {}

    // Parameterized constructor
    public EmployeeDTO(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Convert Employee to EmployeeDTO
    public static EmployeeDTO fromEmployee(Employee employee) {
        return new EmployeeDTO(employee.getName(), employee.getSalary());
    }

    // Convert EmployeeDTO to Employee
    public Employee toEmployee() {
        return new Employee(null, this.name, null, this.salary); // id is null because it would be auto-generated
    }
}
