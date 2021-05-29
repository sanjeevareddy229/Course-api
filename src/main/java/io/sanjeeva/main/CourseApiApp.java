package io.sanjeeva.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseApiApp {

	public static void main(String[] args) {
		
		SpringApplication.run(CourseApiApp.class, args);
		
		/*
		 * Sets up default configuration 
		 * Starts Spring application context 
		 * Performs class path scan 
		 * Starts Tomcat Servers
		 * 
		 * */
	}
}
