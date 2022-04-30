package com.LearnSpringBootCrashCourse.SpringBootCrashCourse.controllers;

import com.LearnSpringBootCrashCourse.SpringBootCrashCourse.entity.Department;
import com.LearnSpringBootCrashCourse.SpringBootCrashCourse.error.DepartmentNotFoundException;
import com.LearnSpringBootCrashCourse.SpringBootCrashCourse.services.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

// Controller layer will be called when endpoint is countered, for that we use WebMvcTest
@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder().
                                departmentID(1L).
                                departmentName("Data Science").
                                departmentCode("DS-07").
                                departmentAddress("Mumbai").
                                build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder().
                departmentName("Data Science").
                departmentCode("DS-07").
                departmentAddress("Mumbai").
                build();
        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

        // Making POST request
        mockMvc.perform(MockMvcRequestBuilders.post("/departments").contentType(MediaType.APPLICATION_JSON).content("{\n" +
                "    \"departmentName\": \"Data Science\",\n" +
                "    \"departmentAddress\": \"Mumbai\",\n" +
                "    \"departmentCode\": \"DS-07\"\n" +
                "}")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void fetchDepartmentByID() throws Exception {
        Mockito.when(departmentService.fetchDepartmentByID(1L)).thenReturn(department);

        // Making GET request
        mockMvc.perform(MockMvcRequestBuilders.get("/departments/1").contentType(MediaType.APPLICATION_JSON)).
                andExpect(MockMvcResultMatchers.status().isOk()).
                andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").value(department.getDepartmentName()));
    }
}