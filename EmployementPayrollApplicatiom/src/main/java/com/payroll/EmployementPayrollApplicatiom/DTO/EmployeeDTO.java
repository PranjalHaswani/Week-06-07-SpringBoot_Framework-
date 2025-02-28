package com.payroll.EmployementPayrollApplicatiom.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.payroll.EmployementPayrollApplicatiom.model.Employee;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


//Section -03(UC-1) Application Settings
@Data // Lombok generates getters, setters, toString, equals, and hashCode methods
@NoArgsConstructor // Lombok generates a no-argument constructor
@AllArgsConstructor // Lombok generates a constructor with arguments for all fields
public @ToString class EmployeeDTO {
    //Section-04(Data Validation)UC-01
    @NotEmpty(message = "Employee name cannot be null")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s](2,)$", message = "Employee name Invalid")
    public String name;
   @NotEmpty(message = "Department cannot be null or empty")
    private List<String> department;
    @Min(value = 500, message = "Min Wage should be more than 500")
    private double salary;

    //Section-05(Using MySQL Repository to store Employee Payroll Data)
    @Pattern(regexp = "male|female", message = "Gender needs to be male or female")
    private String gender;
    @JsonFormat(pattern = "dd MMM yyyy")
    @NotNull(message = "startDate should not be empty")
    @PastOrPresent(message = "startDate should be past or todays date")
    private String startDate;
    @NotBlank(message = "Note cannot be empty")
    private String note;
    @NotBlank(message = "profilePic cannot be empty")
    private String profilePic;

    // Convert EmployeeDTO to Employee
    public Employee toEmployee() {
        // Convert department list into a single string (you may need a custom separator)
        String departmentStr = String.join(", ", this.department);
        return new Employee(null, this.name, departmentStr, this.salary);
    }

    // Convert Employee to EmployeeDTO
    public static EmployeeDTO fromEmployee(Employee employee) {
        // Assuming Employee has a 'department' as a string, splitting it into a list
        List<String> departments = List.of(employee.getDepartment().split(", "));
        return new EmployeeDTO(employee.getName(), departments, employee.getSalary(), "female", "27 Dec 2024", "new hire", null);
    }

}



