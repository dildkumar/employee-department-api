package com.example.employeedepartment.service;

import com.example.employeedepartment.model.Department;
import com.example.employeedepartment.repository.IDepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService implements IDepartmentService {
    private final IDepartmentRepository departmentRepository;

    public DepartmentService(IDepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Optional<Department> findDepartment(long id) {
        return departmentRepository.findById(id);
    }

    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    public Department saveDepartment(Department employee) {
        return departmentRepository.save(employee);
    }

    public void deleteDepartment(Department employee) {
        departmentRepository.delete(employee);
    }

    public void deleteDepartmentbyId(long id) {
        departmentRepository.deleteById(id);
    }
}


