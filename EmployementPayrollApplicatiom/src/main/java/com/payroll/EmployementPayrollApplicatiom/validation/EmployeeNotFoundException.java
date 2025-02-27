package com.payroll.EmployementPayrollApplicatiom.validation;

//Section-04(Throw User friendly Exception) UC-03
public class EmployeeNotFoundException extends RuntimeException {

    // Constructor
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
