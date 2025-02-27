package com.payroll.EmployementPayrollApplicatiom.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
public @Data class Employee {

    //Section-05(Using MySQL Repository to store Employee Payroll Data)
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String name;
    @Setter
    private String department;
    @Setter
    private double salary;
    @Setter
    private String gender;
    private LocalDate startDate;
    @Setter
    private String note;
    @Setter
    private String profilePic;


    // No-argument constructor (default)
    public Employee() {
    }

    // Parameterized constructor
    public Employee(Long id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.gender= gender;
        this.startDate= startDate;
        this.note= note;
        this.profilePic= profilePic;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public String getNote() {
        return note;
    }

    public String getProfilePic() {
        return profilePic;
    }

}

