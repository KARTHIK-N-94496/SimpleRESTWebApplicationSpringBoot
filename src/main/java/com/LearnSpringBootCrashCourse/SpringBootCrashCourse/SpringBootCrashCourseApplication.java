package com.LearnSpringBootCrashCourse.SpringBootCrashCourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//What we create(Architecture) - FrontEnd <-> REST API <-> Service Layer <-> Data Access/Repository Layer <-> DataBase
// REST API - Controllers
// Service Layer - Services(Contains logic)
// Data Access Layer - Repository(Responsible to interact with databases) (Spring Data JPA dependency is needed)
// Database - H2 or MySQL (H2 dependency is needed)

// To run on terminal, $ mvn spring-boot:run
// Spring Boot DevTools Dependency - Used to start or stop or restart the server whenever there are some changes
// Spring Boot Starter Validation Dependency - For validation (https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation)

// Loggers - Log4j, Logback, tinylog, SLF4J(Comes default with spring boot) - Logging is a powerful aid for understanding and debugging program's run-time behavior. Logs capture and persist the important data and make it available for analysis at any point in time.
// Loggers help in debugging the application

// Lombok is used to remove boilerplate code from our java application
// Boiler-plate code are sections of code that are repeated in multiple places with little to no variation.
// Lombok dependency (https://mvnrepository.com/artifact/org.projectlombok/lombok) and add Lombok plugin(File->Preferences) to tell IDE that you are using Lombok

// Live reloading functionality adding to Intellij using Spring Boot DevTools
//Steps: 1) Press Ctrl+Shift+A and Search for registry -> Enable compiler.automake.allow.when.app.running
//		 OR 1) Go to Settings -> Advanced Settings -> Enable Allow auto-make to start even if developed application is currently running
//		 2) Go to Settings -> Build,Execution,Deployment -> Compiler -> Enable build project automatically
@SpringBootApplication
public class SpringBootCrashCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrashCourseApplication.class, args);
	}

}
