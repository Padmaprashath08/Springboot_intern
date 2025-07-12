//
//package com.example.springbootfirst.services;
//
//import com.example.springbootfirst.models.EmployeeTask;
//import com.example.springbootfirst.models.RegisterDetails;
//import com.example.springbootfirst.repository.EmployeeTaskRepository;
//import com.example.springbootfirst.repository.RegisterDetailsRepository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//@Service
//public class EmployeeTaskService {
//
//    @Autowired
//    private EmployeeTaskRepository taskRepository;
//
//    @Autowired
//    private RegisterDetailsRepository registerRepo;
//
//    public String createTask(int employeeId, EmployeeTask task) {
//        RegisterDetails employee = registerRepo.findById(employeeId)
//                .orElseThrow(() -> new RuntimeException("Employee not found"));
//
//        task.setEmployee(employee);
//        EmployeeTask savedTask = taskRepository.save(task);
////        employee.getTasks().add(savedTask);
//        registerRepo.save(employee);
//
//        return "Task is created";
//    }
//
//}