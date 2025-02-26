package com.example.employeedepartment.service;

import com.example.employeedepartment.model.Department;
import com.example.employeedepartment.repository.IDepartmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {


    @Mock
    private IDepartmentRepository departmentRepository;

    @InjectMocks
    private DepartmentService departmentService;


    @Test
    void testGetDepartmentById() {

        //Arrange
        Department department = new Department(1L, "HR", null);
        Mockito.when(departmentRepository.findById(1L)).thenReturn(Optional.of(department));
        //Act
        Optional<Department> result = departmentService.findDepartment(1L);
        //Assert
        assertTrue(result.isPresent());
        assertEquals("HR", result.get().getName());
    }

    @Test
    void testGetAllDepartment() {
        // Arrange
        List<Department> departmentList = new ArrayList<>();
        Department department = new Department(1L, "HR", null);
        departmentList.add(department);
        Mockito.when(departmentRepository.findAll()).thenReturn(departmentList);

        // Act
        List<Department> departmentResultList = departmentService.getAllDepartment();

        // Assert
        assertFalse(departmentResultList.isEmpty(), "Department list should not be empty");
        assertEquals(1, departmentResultList.size(), "There should be one department");
        assertEquals("HR", departmentResultList.get(0).getName(), "Department name should be 'HR'");
    }

    @Test
    void testSaveDepartment() {
        //Arrange
        Department department = new Department();
        department.setId(1L);
        department.setName("Accounts");
        Mockito.when(departmentRepository.save(department)).thenReturn(department);

        //Act
        Department departmentSaved = departmentService.saveDepartment(department);

        //Assert
        assertNotNull(departmentSaved, "Saved department should not be null");
        assertEquals(department.getId(), departmentSaved.getId(), "IDs should be the same");
        assertEquals(department.getName(), departmentSaved.getName(), "Names should be the same");
    }

    @Test
    void testDeleteDepartment() {
        // Arrange
        Department department = new Department(1L, "HR", null);

        // Act
        departmentService.deleteDepartment(department);

        // Assert
        Mockito.verify(departmentRepository, Mockito.times(1)).delete(department);
    }

    @Test
    void testDeleteDepartmentById() {
        // Arrange
        long id = 1L;

        // Act
        departmentService.deleteDepartmentbyId(id);

        // Assert
        Mockito.verify(departmentRepository, Mockito.times(1)).deleteById(id);
    }
}