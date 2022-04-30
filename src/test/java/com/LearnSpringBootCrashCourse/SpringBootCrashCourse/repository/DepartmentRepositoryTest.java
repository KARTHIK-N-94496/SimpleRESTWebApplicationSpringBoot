package com.LearnSpringBootCrashCourse.SpringBootCrashCourse.repository;

import com.LearnSpringBootCrashCourse.SpringBootCrashCourse.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest // Test by JPA
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    // TestEntityManager is available for JUnit and Mockito
    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        // This helps to test database without changing anything in database
        Department department = Department.builder().
                                            departmentName("Software Engineering").
                                            departmentCode("SE-08").
                                            departmentAddress("Bengaluru").
                                            build();
        entityManager.persist(department);// This data will persist before actual test case is called
    }

    @Test
    public void whenFindByID_thenReturnDepartment() {
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(), "Software Engineering");
    }
}