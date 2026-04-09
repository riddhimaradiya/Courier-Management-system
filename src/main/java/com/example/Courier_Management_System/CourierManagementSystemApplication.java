package com.example.Courier_Management_System;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class CourierManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourierManagementSystemApplication.class, args);
	}
}
