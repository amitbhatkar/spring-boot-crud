package com.example.em.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {
		System.out.println("-------Starting Successful-------");

		SpringApplication.run(EmployeeApplication.class, args);

		System.out.println("\n --------Finished Successful--------");
 	}

}
	