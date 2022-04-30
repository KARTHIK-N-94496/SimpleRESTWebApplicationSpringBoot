package com.LearnSpringBootCrashCourse.SpringBootCrashCourse.entity;

// It contains the data that has to be sent back in the error message

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data // Since we need to have getters and setters, toString(), constructors
@NoArgsConstructor // Default constructor
@AllArgsConstructor // Constructor for all arguments
public class ErrorMessage {
    private HttpStatus status; // HTTP Status code
    private String message; // Error message
}
