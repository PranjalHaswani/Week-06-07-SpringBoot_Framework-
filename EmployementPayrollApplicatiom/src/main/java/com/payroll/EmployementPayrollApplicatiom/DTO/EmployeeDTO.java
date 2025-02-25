package com.payroll.EmployementPayrollApplicatiom.DTO;

import com.payroll.EmployementPayrollApplicatiom.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//Section -03(UC-1) Application Settings
@Data // Lombok generates getters, setters, toString, equals, and hashCode methods
@NoArgsConstructor // Lombok generates a no-argument constructor
@AllArgsConstructor // Lombok generates a constructor with arguments for all fields
public class EmployeeDTO {
    private String name;
    private double salary;

    // Convert EmployeeDTO to Employee
    public Employee toEmployee() {
        return new Employee(null, this.name, null, this.salary);
    }

    // Convert Employee to EmployeeDTO
    public static EmployeeDTO fromEmployee(Employee employee) {
        return new EmployeeDTO(employee.getName(), employee.getSalary());
    }
}



