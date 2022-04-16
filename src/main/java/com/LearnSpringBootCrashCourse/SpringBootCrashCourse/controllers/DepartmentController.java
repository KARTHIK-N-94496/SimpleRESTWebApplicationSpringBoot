package com.LearnSpringBootCrashCourse.SpringBootCrashCourse.controllers;

import com.LearnSpringBootCrashCourse.SpringBootCrashCourse.entity.Department;
import com.LearnSpringBootCrashCourse.SpringBootCrashCourse.services.DepartmentService;
import com.LearnSpringBootCrashCourse.SpringBootCrashCourse.services.DepartmentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {
    // Method to save the Department - Create the Department entity in h2 database

    /*
    Autowiring is the dependency injection
        There are two types of autowiring - Constructor based, Setter based
     */

    @Autowired // This is Dependency Injection // To tell spring to autowire the object to this reference
    public DepartmentService departmentService;

    // Adding Logger
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments") // /departments is the endpoint where we need to call the saveDepartment()
    public Department saveDepartment(@Valid @RequestBody Department department) { // Since we use POST, we need to pass the entire request body in JSON to make it as entity // @Valid is used for the validation that we mentioned in Department class
        // @RequestBody converts JSON to object
        // Now we need to call service layer to pass this data
        // DepartmentService service = new DepartmentServiceImpl(); We use interface

        // Log whenever a request comes to saveDepartment - It helps to debug the application
        LOGGER.info("***** INSIDE saveDepartment of departmentController *****");
        return departmentService.saveDepartment(department);
    }

    // To fetch all the Departments list available in entity
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        return departmentService.fetchDepartmentList();
    }

    // To fetch the departments using the ID
    @GetMapping("/departments/{id}") // Path variable is used to mention the ID because it is dynamic value
    public Department fetchDepartmentByID(@PathVariable("id") Long departmentID) {
        return departmentService.fetchDepartmentByID(departmentID);
    }

    // To delete the departement using the ID
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentByID(@PathVariable("id") Long departmentID) {
        departmentService.deleteDepartmentByID(departmentID);
        return "Department with ID "+departmentID+" deleted successfully";
    }

    // To update the department values
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentID, @RequestBody Department department) {
        return departmentService.updateDepartment(departmentID, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
