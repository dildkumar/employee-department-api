package com.example.employeedepartment.controller;

import com.example.employeedepartment.model.Department;
import com.example.employeedepartment.service.IDepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final IDepartmentService departmentService;

    public DepartmentController(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartment();
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @DeleteMapping
    public void deleteDepartmentbyId(@PathVariable Long departmentId) {
        departmentService.deleteDepartmentbyId(departmentId);
    }
}
