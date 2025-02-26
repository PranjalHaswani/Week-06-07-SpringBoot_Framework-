package com.payroll.EmployementPayrollApplicatiom.DTO;

import com.payroll.EmployementPayrollApplicatiom.model.Employee;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
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
    private String gender;
    private String startDate;
    private String note;
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
        return new EmployeeDTO(employee.getName(), departments, employee.getSalary(), "female", "27 Feb", null, null);
    }

}



