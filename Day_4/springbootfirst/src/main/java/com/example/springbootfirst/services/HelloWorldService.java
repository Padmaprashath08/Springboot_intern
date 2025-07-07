package com.example.springbootfirst.services;

import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloWorldService {


    @Autowired
    EmployeeRepository empRepo;
    public List<Employee> getMethod(){
        return empRepo.findAll();
    }

    public String addEmployee(Employee employee) {
        empRepo.save(employee);
        return "Employee added successfully!";
    }

    public String putMethod(Employee employee) {
        empRepo.save(employee);

        return "Details updated successfully!";
    }
    public String deleteMethod(int id) {
        empRepo.deleteById(id);
        return "Employee not found with the id "+id;
    }

    public Employee getEmployeeById(int id) {
        if(empRepo.findById(id).isPresent()){
            System.out.println(empRepo.findById(id));
            return empRepo.findById(id).orElse(null);
        }
        else {
            return new Employee();
        }
    }
}
