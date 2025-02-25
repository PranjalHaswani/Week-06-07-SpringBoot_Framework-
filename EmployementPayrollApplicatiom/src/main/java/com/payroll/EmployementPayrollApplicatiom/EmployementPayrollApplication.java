package com.payroll.EmployementPayrollApplicatiom;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class EmployementPayrollApplication {

	public static void main(String[] args) {

	//	SpringApplication.run(EmployementPayrollApplication.class, args);
		ApplicationContext context= SpringApplication.run(EmployementPayrollApplication.class, args);
    //Section-03 UC2 (Lombok For Logging)
	//	log.info("Employee payroll App Started Environment");

		//Section-03 UC3 (determine the logging)
		log.info("Enployee Payroll App Started in {} Environment", context.getEnvironment(). getProperty("environment"));

		//SECTION-03 UC4 (Database setting as environment variable)
		log.info("Employee Payroll DB User is {} ", context.getEnvironment().getProperty("spring.datasource.username"));
	}
}
