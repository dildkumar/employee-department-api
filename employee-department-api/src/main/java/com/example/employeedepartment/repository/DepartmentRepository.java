package com.example.employeedepartment.repository;

import com.example.employeedepartment.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    void deleteAll();  // Deletes all employees
}
