package com.example.employeedepartment.service;
import com.example.employeedepartment.model.Employee;
import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

    Optional<Employee> findEmployee(long id);

    List<Employee> getAllEmployee();

    Employee saveEmployee(Employee employee);

    void deleteEmployee(Employee employee);

    void deleteEmployeebyId(long id);
}
