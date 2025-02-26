package com.example.employeedepartment.repository;
import com.example.employeedepartment.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository extends JpaRepository<Department, Long> {
}
