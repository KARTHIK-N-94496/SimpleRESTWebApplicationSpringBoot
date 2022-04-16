package com.LearnSpringBootCrashCourse.SpringBootCrashCourse.entity;
// It is like creating a schema or table for our database
// We use getters, setters, constructors, default constructors, toString method(Use alt+Insert or cmd+N(On mac) to generate automatically)

// Creating Entity

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

//@Entity // To make the entity to interact with the database using JPA
//public class Department {
//
//    // Creating primary key - departmentID
//    @Id // Making primary key
//    @GeneratedValue(strategy = GenerationType.AUTO) // How we generate primary key
//    private Long departmentID;
//
//    // Creating validation - While creating department name should not be null
//    @NotNull(message = "departmentName should not be empty... Please add departmentName") // Validation - Tells departmentName should not be empty
//    private String departmentName;
//    /*
//    Some other validation annotations
//        @Length(max = 8, min = 2) // To check the length
//        @Size(max = 5, min = 1) // To check the size
//        @Email // For email validation
//        @Positive // To validate positive values
//        @Negative // To validate negative values
//        @PositiveOrZero // To validate only positive or zero values
//        @NegativeOrZero // To validate only negative or zero values
//        @Future // To check whether the date is future
//        @FutureOrPresent // To check whether the date is future or present
//        @Past // To check whether the date is past
//        @PastOrPresent // To check whether the date is past or present
//     */
//
//    private String departmentAddress;
//    private String departmentCode;
//
//    // Getters and Setters
//    public Long getDepartmentID() {
//        return departmentID;
//    }
//
//    public void setDepartmentID(Long departmentID) {
//        this.departmentID = departmentID;
//    }
//
//    public String getDepartmentName() {
//        return departmentName;
//    }
//
//    public void setDepartmentName(String departmentName) {
//        this.departmentName = departmentName;
//    }
//
//    public String getDepartmentAddress() {
//        return departmentAddress;
//    }
//
//    public void setDepartmentAddress(String departmentAddress) {
//        this.departmentAddress = departmentAddress;
//    }
//
//    public String getDepartmentCode() {
//        return departmentCode;
//    }
//
//    public void setDepartmentCode(String departmentCode) {
//        this.departmentCode = departmentCode;
//    }
//
//    // Constructors
//    public Department(Long departmentID, String departmentName, String departmentAddress, String departmentCode) {
//        this.departmentID = departmentID;
//        this.departmentName = departmentName;
//        this.departmentAddress = departmentAddress;
//        this.departmentCode = departmentCode;
//    }
//
//    // Default Constructor
//    public Department() {
//    }
//
//    // toString Method
//
//    @Override
//    public String toString() {
//        return "Department{" +
//                "departmentID=" + departmentID +
//                ", departmentName='" + departmentName + '\'' +
//                ", departmentAddress='" + departmentAddress + '\'' +
//                ", departmentCode='" + departmentCode + '\'' +
//                '}';
//    }
//}

// OR

// Implementing using Lombok - Using lombok we can skip constructors, Getters and Setters, toString() because they are already implemented in @Data of Lombok
@Entity // To make the entity to interact with the database using JPA
@Data // @Data is from Lombok
// @Getter or @Setter can be used if we need only Getters or Setters
@NoArgsConstructor // A default constructor will be created
@AllArgsConstructor // A constructor for all arguments will be created
@Builder // A builder pattern will be created - The builder pattern is a design pattern designed to provide a flexible solution to various object creation problems in object-oriented programming.
public class Department {

    // Creating primary key - departmentID
    @Id // Making primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // How we generate primary key
    private Long departmentID;

    // Creating validation - While creating department name should not be null
    @NotNull(message = "departmentName should not be empty... Please add departmentName") // Validation - Tells departmentName should not be empty
    private String departmentName;

    private String departmentAddress;
    private String departmentCode;
}


// Then create a controller for Department in controllers package - DepartmentController

// We create DepartmentController and DepartmentService in interface manner

// Interfaces - A block same like abstract classes where every method is abstract
//interface myInterface {
//    void greet();
//}
//class myInterfaceImpl implements myInterface {
//    public void greet() {
//        System.out.println("Hello, welcome to interfaces");
//    }
//}
//myInterface obj = new myInterfaceImpl();
//obj.greet();