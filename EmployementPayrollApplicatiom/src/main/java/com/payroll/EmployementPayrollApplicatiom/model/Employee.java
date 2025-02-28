package com.payroll.EmployementPayrollApplicatiom.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employee")
@Data
public class Employee {
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "name")
    @Setter
    private String name;

    @Setter
    private double salary;

    @Setter
    private String gender;

    private LocalDate startDate;

    @Setter
    private String note;

    @Setter
    private String profilePic;

    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    @Setter
    private List<String> department;

    public Employee() {
    }

    public Employee(Long id, String name, List<String> department, double salary, LocalDate startDate, String gender, String note, String profilePic) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.startDate = startDate;
        this.gender = gender;
        this.note = note;
        this.profilePic = profilePic;
    }
}
