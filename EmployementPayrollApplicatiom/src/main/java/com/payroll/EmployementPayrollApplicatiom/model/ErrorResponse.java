package com.payroll.EmployementPayrollApplicatiom.model;

import java.util.List;


//Section-04(Provide User Friendly Error Response in case validation fails)
//UC-02
//Section-05(Json_Format)
//UC2
public class ErrorResponse {

    private String message;
    private List<String> details;

    public ErrorResponse(String message, List<String> details) {
        this.message = message;
        this.details = details;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }
}

    //Section-04(Throw User friendly Exception) UC-03
//        private String error;
//        private String message;
//
//        // Constructor
//        public ErrorResponse(String error, String message) {
//            this.error = error;
//            this.message = message;
//        }
//
//        // Getters and Setters
//        public String getError() {
//            return error;
//        }
//
//        public void setError(String error) {
//            this.error = error;
//        }
//
//        public String getMessage() {
//            return message;
//        }
//
//        public void setMessage(String message) {
//            this.message = message;
//        }
//    }

