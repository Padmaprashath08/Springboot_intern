package com.example.springbootfirst.services;

import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.models.UserDetailsDto;
import com.example.springbootfirst.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    RegisterDetailsRepository registerDetailsRepository;

    public List<RegisterDetails> getMethod() {
        return registerDetailsRepository.findAll();
    }


    public String addEmployee(RegisterDetails employee) {
        registerDetailsRepository.save(employee);
        return "Employee added successfully";
    }

    public RegisterDetails getEmployeeById(int id) {
        return registerDetailsRepository.findById(id).orElse(new RegisterDetails());
    }

    public String updateEmployee(RegisterDetails employee) {
        registerDetailsRepository.save(employee);
        return "Employee updated successfully";
    }

    public String deleteMethod(int id) {
        registerDetailsRepository.deleteById(id);
        return "Employee deleted successfully";
    }

//    public List<RegisterDetails> getEmployeeByJob(String job) {
//        return registerDetailsRepository.getEmployeeByJob();
//    }
}
