package com.example.employeedepartment.controller;

import com.example.employeedepartment.common.ApplicationException;
import com.example.employeedepartment.model.Employee;
import com.example.employeedepartment.model.Department;
import com.example.employeedepartment.repository.EmployeeRepository;
import com.example.employeedepartment.repository.DepartmentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeController (EmployeeRepository employeeRepository,DepartmentRepository departmentRepository )
    {
        this.employeeRepository=employeeRepository;
        this.departmentRepository=departmentRepository;
    }


    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping("/{departmentId}")
    public Employee createEmployee(@PathVariable Long departmentId, @RequestBody Employee employee) {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if (department.isPresent()) {
            employee.setDepartment(department.get());
            return employeeRepository.save(employee);
        } else {
            throw new ApplicationException("Department not found!");
        }
    }

    @DeleteMapping
    public void deleteEmployee() {
        employeeRepository.deleteAll();
    }
}
