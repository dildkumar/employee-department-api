package com.example.employeedepartment.repository;

import com.example.employeedepartment.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    void deleteAll();  // Deletes all departments
}
