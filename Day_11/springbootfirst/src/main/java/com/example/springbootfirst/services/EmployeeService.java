package com.example.springbootfirst.services;

import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.models.Roles;
import com.example.springbootfirst.models.UserDetailsDto;
import com.example.springbootfirst.repository.RegisterDetailsRepository;
import com.example.springbootfirst.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    @Autowired
    RegisterDetailsRepository registerDetailsRepository;

    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public List<RegisterDetails> getMethod() {
        return registerDetailsRepository.findAll();
    }


    public String addEmployee(UserDetailsDto register) {
        RegisterDetails registerDetails=new RegisterDetails();
        registerDetails.setEmpId(register.getEmpId());
        registerDetails.setName(register.getName());
        registerDetails.setEmail(register.getEmail());
        registerDetails.setPassword(passwordEncoder.encode(register.getPassword()));
        registerDetails.setUserName(register.getUserName());
        Set<Roles> roles=new HashSet<>();
        for(String roleName:register.getRoles()){
            Roles role=rolesRepository.findByRoleName(roleName).orElseThrow(()->new RuntimeException("Role not found"));
            System.out.println(role);
            roles.add(role);
        }
        registerDetails.setRoles(roles);
        registerDetailsRepository.save(registerDetails);
        return "User Details saved successfully";
    }

    public RegisterDetails getEmployeeById(int id) {
        return registerDetailsRepository.findById(id).orElse(new RegisterDetails());
    }

    public String updateEmployee(int id,UserDetailsDto employee) {
        Optional<RegisterDetails> Employee = registerDetailsRepository.findById(id);

        if (Employee.isPresent()) {
            RegisterDetails addEmployee = Employee.get();
            addEmployee.setName(employee.getName());
            addEmployee.setEmail(employee.getEmail());
            addEmployee.setPassword(employee.getPassword());
            addEmployee.setUserName(employee.getUserName());
            Set<Roles> roles=new HashSet<>();
            for(String roleName:employee.getRoles()){
                Roles role=rolesRepository.findByRoleName(roleName).orElseThrow(()->new RuntimeException("Role not found"));
                System.out.println(role);
                roles.add(role);
            }
            addEmployee.setRoles(roles);
            registerDetailsRepository.save(addEmployee);
            return "Employee updated successfully";
        } else {
            throw new RuntimeException("Employee not found with id: " + id);
        }
    }

    public String deleteMethod(int id) {
//        RegisterDetails user = registerDetailsRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
//        user.getRoles().clear();
//        registerDetailsRepository.save(user);
        registerDetailsRepository.deleteByRoleById(id);
        registerDetailsRepository.deleteById(id);
        return "Employee deleted successfully";
    }

    public List<RegisterDetails> getbyroles(String role) {
        List<RegisterDetails> employees = new ArrayList<>();

        for(RegisterDetails registerDetails : registerDetailsRepository.findAll()){

            for(Roles roles : registerDetails.getRoles()){
                if(roles.getRoleName().equals(role.toUpperCase())){
                    employees.add(registerDetails);
                }
            }
        }
        return employees;

    }

//    public List<RegisterDetails> getEmployeeByJob(String job) {
//        return registerDetailsRepository.getEmployeeByJob();
//    }
}
