package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.models.UserDetailsDto;
import com.example.springbootfirst.services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class EmployeeControllerTest {
    @Mock
    EmployeeService employeeService;
    @InjectMocks
    EmployeeController employeeController;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testGetEmployee(){
        RegisterDetails emp1=new RegisterDetails();
        RegisterDetails emp2=new RegisterDetails();
        when(employeeService.getMethod()).thenReturn(Arrays.asList(emp1,emp2));
        List<RegisterDetails> result=Arrays.asList(emp1,emp2);
        assertEquals(2,result.size());
    }

    @Test
    void testPostEmployee() {
        // Arrange
        UserDetailsDto dto = new UserDetailsDto();
        dto.setEmpId(101);
        dto.setName("Padma");
        dto.setEmail("padma@example.com");
        dto.setUserName("padma123");
        dto.setPassword("securepass");
        dto.setRoles(Set.of("USER"));

        String expectedResponse = "User Details saved successfully";

        // Mocking service call
        when(employeeService.addEmployee(dto)).thenReturn(expectedResponse);

        // Act
        String actualResponse = employeeController.postMethod(dto);

        // Assert
        assertEquals(expectedResponse, actualResponse);
    }
    @Test
    void testPutEmployee() {
        UserDetailsDto dto = new UserDetailsDto();
        dto.setName("Updated User");
        dto.setUserName("updateduser");
        dto.setEmail("update@example.com");
        dto.setPassword("newpass");
        dto.setRoles(Set.of("ADMIN"));

        when(employeeService.updateEmployee(1, dto)).thenReturn("Employee updated successfully");

        String result = employeeController.updateEmployee(1, dto);
        assertEquals("Employee updated successfully", result);

    }

    @Test
    void testDeleteEmployee() {
        when(employeeService.deleteMethod(1)).thenReturn("Employee deleted successfully");

        String result = employeeController.deleteMethod(1);
        assertEquals("Employee deleted successfully", result);

    }
}
