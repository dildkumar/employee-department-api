package com.example.employeedepartment.controller;

import com.example.employeedepartment.common.ApplicationException;
import com.example.employeedepartment.model.Employee;
import com.example.employeedepartment.model.Department;
import com.example.employeedepartment.service.IDepartmentService;
import com.example.employeedepartment.service.IEmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final IEmployeeService employeeService;
    private final IDepartmentService departmentService;

    public EmployeeController(IEmployeeService employeeService, IDepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }


    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployee();
    }

    @PostMapping("/{departmentId}")
    public Employee createEmployee(@PathVariable Long departmentId, @RequestBody Employee employee) {
        Optional<Department> department = departmentService.findDepartment(departmentId);
        if (department.isPresent()) {
            employee.setDepartment(department.get());
            return employeeService.saveEmployee(employee);
        } else {
            throw new ApplicationException("Department not found!");
        }
    }

    @DeleteMapping
    public void deleteEmployeebyId(@PathVariable Long employeeId) {
        employeeService.deleteEmployeebyId(employeeId);
    }
}
