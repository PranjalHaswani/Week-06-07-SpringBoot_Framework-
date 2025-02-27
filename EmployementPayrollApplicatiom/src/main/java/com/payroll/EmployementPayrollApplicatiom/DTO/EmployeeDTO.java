package com.payroll.EmployementPayrollApplicatiom.DTO;

import com.payroll.EmployementPayrollApplicatiom.model.Employee;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//Section -03(UC-1) Application Settings
//@Data // Lombok generates getters, setters, toString, equals, and hashCode methods
//@NoArgsConstructor // Lombok generates a no-argument constructor
//@AllArgsConstructor // Lombok generates a constructor with arguments for all fields
public class EmployeeDTO {
    //Section-04(Data Validation)UC-01
    @NotEmpty(message = "Employee name cannot be null")
   // @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s](2,)$", message = "Employee name Invalid")
    private String name;
    @NotEmpty(message = "Department cannot be null or empty")
    private String department;
    @Min(value = 500, message = "Min Wage should be more than 500")
    private double salary;
    //default constructor
    public EmployeeDTO(){}

    //Parameterized Constructor
    public EmployeeDTO(String name, String department, double salary)
    {
        this.name= name;
        this.department= department;
        this.salary= salary;
    }

    //Getters and setters
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    // Convert EmployeeDTO to Employee
    public Employee toEmployee() {
        return new Employee(null, this.name, null, this.salary);
    }
        // Convert Employee to EmployeeDTO
        public static EmployeeDTO fromEmployee (Employee employee){
            return new EmployeeDTO(employee.getName(), employee.getDepartment(), employee.getSalary());
        }
    }



