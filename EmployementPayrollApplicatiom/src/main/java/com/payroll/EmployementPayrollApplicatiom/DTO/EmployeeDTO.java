package com.payroll.EmployementPayrollApplicatiom.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.payroll.EmployementPayrollApplicatiom.model.Employee;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDTO {
    @NotEmpty(message = "Employee name cannot be null")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s](2,)$", message = "Employee name Invalid")
    private String name;

    @NotEmpty(message = "Department cannot be null or empty")
    private List<String> department;

    @Min(value = 500, message = "Min Wage should be more than 500")
    private double salary;

    @Pattern(regexp = "male|female", message = "Gender needs to be male or female")
    private String gender;

    @JsonFormat(pattern = "dd MMM yyyy")
    @NotNull(message = "startDate should not be empty")
    @PastOrPresent(message = "startDate should be past or today's date")
    private LocalDate startDate;

    @NotBlank(message = "Note cannot be empty")
    private String note;

    @NotBlank(message = "profilePic cannot be empty")
    private String profilePic;

    public Employee toEmployee() {
        return new Employee(null, this.name, this.department, this.salary, null, this.gender, this.note, this.profilePic);
    }

    public static EmployeeDTO fromEmployee(Employee employee) {
        return new EmployeeDTO(
                employee.getName(),
                employee.getDepartment(),
                employee.getSalary(),
                employee.getGender(),
                employee.getStartDate(),
                employee.getNote(),
                employee.getProfilePic()
        );
    }
}
