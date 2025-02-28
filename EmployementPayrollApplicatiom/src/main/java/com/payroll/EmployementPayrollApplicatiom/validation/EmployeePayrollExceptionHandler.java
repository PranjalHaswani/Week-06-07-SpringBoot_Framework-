package com.payroll.EmployementPayrollApplicatiom.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import com.payroll.EmployementPayrollApplicatiom.model.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.ArrayList;
import java.util.List;
//Section-04(Provide User Friendly Error Response in case validation fails)
//UC-02
@ControllerAdvice
@Slf4j
public class EmployeePayrollExceptionHandler {
    private static final String message = "Exception while processing REST Request";
//Section-05(Json-Format)UC2
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(
            HttpMessageNotReadableException exception) {
        log.error("Invalid Date Format", exception);
        ErrorResponse responseDTO = new ErrorResponse(message, List.of("Should have date in the format dd MMM yyyy"));
        return new ResponseEntity<ErrorResponse>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    // Handle validation exceptions
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        // Create a list to hold error messages
        List<String> errorDetails = new ArrayList<>();

        // Loop through all the validation errors
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            // Add the field name and the validation error message to the list
            errorDetails.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
        }

        // Create the ErrorResponse with the validation errors
        ErrorResponse errorResponse = new ErrorResponse("Validation Failed", errorDetails);

        // Return a BAD_REQUEST (400) response with the error message and details
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
//
//    // Handle general exceptions
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponse> handleGeneralExceptions(Exception ex) {
//        ErrorResponse errorResponse = new ErrorResponse("An error occurred", List.of(ex.getMessage()));
//        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//}
//
    //Section-04(Throw User friendly Exception) UC-03
    // Define the global exception handler
    // Handle EmployeeNotFoundException
@ExceptionHandler(EmployeeNotFoundException.class)
public ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
    String errorMessage = (ex.getMessage() != null) ? ex.getMessage() : "Employee Not Found";

    // Create a user-friendly error response
    ErrorResponse errorResponse = new ErrorResponse(
            "Employee Not Found",  // general message
            List.of(errorMessage)  // specific message in a list
    );

    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
}

}


