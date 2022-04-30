package com.LearnSpringBootCrashCourse.SpringBootCrashCourse.services;

import com.LearnSpringBootCrashCourse.SpringBootCrashCourse.entity.Department;
import com.LearnSpringBootCrashCourse.SpringBootCrashCourse.repository.DepartmentRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

// Service Layer Testing

@SpringBootTest // To mention spring boot that it is a test class
class DepartmentServiceTest {

    @Autowired // Since we use this class we need to autowired it
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    // @BeforeAll // This will be called once before executing all test cases
    @BeforeEach // This will be called before executing each test cases
    void setUp() {
        Department department = Department.builder().
                                            departmentName("DevOps").
                                            departmentAddress("Mumbai").
                                            departmentCode("DO-16").
                                            departmentID(2L).
                                            build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("DevOps"))
                .thenReturn(department); // Whenever findByDepartmentNameIgnoreCase() is called, then use department as value
    }

    // Implementing test cases for - public Department fetchDepartmentByName(String departmentName); from DepartmentService Class
    @Test
    @DisplayName("Get data based on valid name") // On the test cases this name will be used instead of test function name
    // @Disabled // To skip the test case
    public void whenValidDepartmentName_theDepartmentShouldBeFound() {
        String departmentName = "DevOps";
        Department found = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName, found.getDepartmentName());
    }
}