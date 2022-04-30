package com.LearnSpringBootCrashCourse.SpringBootCrashCourse.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//    @Component - To make the class as component of spring
//    @Controller - But we need a controller, so this annotation tells it, and it also contains @Component
@RestController // REST API Controller
public class REST_API_Controller {

    @Value("${myCustomWelcomeMessage.message}")
    private String welcomeMessage; // A custom config message from application.properties file

//    @RequestMapping(value = "/", method = RequestMethod.GET) // Execute the function whenever an endpoint is created
//    public String restAPIControllerMethod() {
//        return "Hello REST API";
//    }
//    OR
    @GetMapping("/") // Instead of RequestMapping and take Get Method, we can use Get Mapping annotation
    public String restAPIControllerMethod() {
        return "Hello... Today we create REST API, " + welcomeMessage;
    }
}
