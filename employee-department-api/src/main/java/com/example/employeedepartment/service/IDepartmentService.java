package com.example.employeedepartment.service;

import com.example.employeedepartment.model.Department;

import java.util.List;
import java.util.Optional;

public interface IDepartmentService {

    Optional<Department> findDepartment(long id);

    List<Department> getAllDepartment();

    Department saveDepartment(Department employee);

    void deleteDepartment(Department employee);

    void deleteDepartmentbyId(long id);
}
