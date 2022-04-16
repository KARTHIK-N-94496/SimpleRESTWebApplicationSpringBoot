package com.LearnSpringBootCrashCourse.SpringBootCrashCourse.entity;
// It is like creating a schema or table for our database
// We use getters, setters, constructors, default constructors, toString method(Use alt+Insert or cmd+N(On mac) to generate automatically)

// Creating Entity

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // To make the entity to interact with the database using JPA
public class Department {

    //Creating primary key - departmentID
    @Id // Making primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // How we generate primary key
    private Long departmentID;

    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

    // Getters and Setters
    public Long getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Long departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    // Constructors
    public Department(Long departmentID, String departmentName, String departmentAddress, String departmentCode) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.departmentAddress = departmentAddress;
        this.departmentCode = departmentCode;
    }

    // Default Constructor
    public Department() {
    }

    // toString Method

    @Override
    public String toString() {
        return "Department{" +
                "departmentID=" + departmentID +
                ", departmentName='" + departmentName + '\'' +
                ", departmentAddress='" + departmentAddress + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                '}';
    }
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