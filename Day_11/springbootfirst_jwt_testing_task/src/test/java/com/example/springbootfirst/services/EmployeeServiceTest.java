package com.example.springbootfirst.services;

import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.models.Roles;
import com.example.springbootfirst.models.UserDetailsDto;
import com.example.springbootfirst.repository.RegisterDetailsRepository;
import com.example.springbootfirst.repository.RolesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {
    @Mock
    RegisterDetailsRepository registerDetailsRepository;
    @Mock
    private RolesRepository rolesRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    EmployeeService employeeService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetMethod(){
        RegisterDetails emp1=new RegisterDetails();
        RegisterDetails emp2=new RegisterDetails();
        when(registerDetailsRepository.findAll()).thenReturn(Arrays.asList(emp1,emp2));
        List<RegisterDetails> result=employeeService.getMethod();
        assertEquals(2,result.size());
    }
    @Test
    void testAddEmployee() {
        UserDetailsDto dto = new UserDetailsDto();
        dto.setEmpId(1);
        dto.setName("Padma");
        dto.setEmail("padma@example.com");
        dto.setUserName("padma123");
        dto.setPassword("securepass");
        dto.setRoles(Set.of("USER"));

        Roles userRole = new Roles();
        userRole.setRoleName("USER");

        when(passwordEncoder.encode("securepass")).thenReturn("encodedpass");
        when(rolesRepository.findByRoleName("USER")).thenReturn(Optional.of(userRole));

        String result = employeeService.addEmployee(dto);

        assertEquals("User Details saved successfully", result);
    }

    @Test
    void testUpdateEmployee() {
        int id = 1;
        UserDetailsDto dto = new UserDetailsDto();
        dto.setName("Updated Name");
        dto.setEmail("update@example.com");
        dto.setUserName("updateduser");
        dto.setPassword("newpass");
        dto.setRoles(Set.of("ADMIN"));

        RegisterDetails existing = new RegisterDetails();
        existing.setEmpId(id);

        Roles role = new Roles();
        role.setRoleName("ADMIN");

        when(registerDetailsRepository.findById(id)).thenReturn(Optional.of(existing));
        when(rolesRepository.findByRoleName("ADMIN")).thenReturn(Optional.of(role));

        String result = employeeService.updateEmployee(id, dto);

        assertEquals("Employee updated successfully", result);
    }

    @Test
    void testDeleteEmployee() {
        doNothing().when(registerDetailsRepository).deleteByRoleById(1);
        doNothing().when(registerDetailsRepository).deleteById(1);

        String result = employeeService.deleteMethod(1);

        assertEquals("Employee deleted successfully", result);
    }
}
