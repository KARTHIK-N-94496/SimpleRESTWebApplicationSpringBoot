package com.LearnSpringBootCrashCourse.SpringBootCrashCourse.repository;

import com.LearnSpringBootCrashCourse.SpringBootCrashCourse.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // To represent it as repository implementation
// Here we are not implementing DevelopmentRepositoryImpl but we extend JpaRepository to use the methods available in it to interact with the entities in our database
public interface DepartmentRepository extends JpaRepository<Department, Long> { // JpaRepository<EntiryName, primaryKeyType>
    // Documentation - https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
    public Department findByDepartmentName(String departmentName); // NOTE: Naming Conventions are important according to documentation
    public Department findByDepartmentNameIgnoreCase(String departmentName); // Ignoring the case of path variable value

    // Use @Query annotation for complex queries(Refer documentation)
}

/* Use any REST client -  postman, thunder-client or insomnia to add data into the database in json format using post method
    Open postman, create a post request and enter the URL http://localhost:8082/departments/
    In body tab, select raw and choose JSON type the below to insert into Department entity
        {
            "departmentName" : "Software Architecture",
            "departmentAddress" : "Bengaluru",
            "departmentCode" : "SA-01"
        }
* */
