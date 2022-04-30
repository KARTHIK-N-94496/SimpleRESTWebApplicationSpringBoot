package com.LearnSpringBootCrashCourse.SpringBootCrashCourse.services;

import com.LearnSpringBootCrashCourse.SpringBootCrashCourse.entity.Department;
import com.LearnSpringBootCrashCourse.SpringBootCrashCourse.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentByID(Long departmentID) throws DepartmentNotFoundException;

    public void deleteDepartmentByID(Long departmentID);

    public Department updateDepartment(Long departmentID, Department department);

    public Department fetchDepartmentByName(String departmentName);
}
