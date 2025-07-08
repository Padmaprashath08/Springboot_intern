package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloWorld {
    @Autowired
    private HelloWorldService hws;
    @GetMapping("/")
    public String  hello(){
        return "Spring security";
    }
    @GetMapping("/employee")
    public List<Employee> getMethod() {
       return hws.getMethod();
    }
    @PostMapping("/employee")
    public String postMethod(@RequestBody Employee employee) {
        return hws.addEmployee(employee);
    }
    @GetMapping("/employee/id/{id}")
    public Employee getEmployeeById(@PathVariable int id) {

        return hws.getEmployeeById(id);
    }
    @GetMapping("/employee/job/{job}")
    public List<Employee> getEmployeeByJob(@PathVariable String job) {

        return hws.getEmployeeByJob(job);
    }

    @PutMapping("/employee")
    public String putMethod(@RequestBody Employee employee) {
        return hws.putMethod( employee);
    }
    @DeleteMapping("/employee/{id}")

    public String deleteMethod(@PathVariable int id) {
        return hws.deleteMethod(id);
    }
    @DeleteMapping("/employee")

    public String deleteallMethod() {
        return hws.deleteallMethod();
    }
}
