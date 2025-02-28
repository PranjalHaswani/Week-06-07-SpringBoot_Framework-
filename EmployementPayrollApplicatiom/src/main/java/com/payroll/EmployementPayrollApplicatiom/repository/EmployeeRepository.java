package com.payroll.EmployementPayrollApplicatiom.repository;


import com.payroll.EmployementPayrollApplicatiom.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Custom query to find all employees in the Sales department
    @Query("SELECT e FROM Employee e JOIN e.department d WHERE d = 'Sales'")
    List<Employee> findEmployeesInSalesDepartment();
}
