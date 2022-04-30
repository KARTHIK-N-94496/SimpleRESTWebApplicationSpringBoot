package com.LearnSpringBootCrashCourse.SpringBootCrashCourse.services;

import com.LearnSpringBootCrashCourse.SpringBootCrashCourse.entity.Department;
import com.LearnSpringBootCrashCourse.SpringBootCrashCourse.error.DepartmentNotFoundException;
import com.LearnSpringBootCrashCourse.SpringBootCrashCourse.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service // To represent it as service implementation
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department); // save() from JpaRepository to save the enity
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll(); // findAll() returns all the data in a list
    }

    @Override
    public Department fetchDepartmentByID(Long departmentID) throws DepartmentNotFoundException {
        // return departmentRepository.findById(departmentID).get();

        // Using Exception Handling
        Optional<Department> department = departmentRepository.findById(departmentID);
        // If department not found then throw the exception
        if(!department.isPresent()) {
            throw new DepartmentNotFoundException("Department not available");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentByID(Long departmentID) {
        departmentRepository.deleteById(departmentID);
    }

    @Override
    public Department updateDepartment(Long departmentID, Department department) {
        Department deptDB = departmentRepository.findById(departmentID).get();
        // departmentName
        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
            deptDB.setDepartmentName(department.getDepartmentName());
        }
        // departmentAddress
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            deptDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        // departmentCode
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            deptDB.setDepartmentCode(department.getDepartmentCode());
        }

        // Save with new values
        return departmentRepository.save(deptDB);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        // There is no default method available in JPARepository to fetch name so we create a method in DepartmentRepository class
        // return departmentRepository.findByDepartmentName(departmentName); // Case sensitive for end point data
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName); // Case insensitive for end point data
    }
}
