package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class HelloWorld {
    @Autowired
    private HelloWorldService hws;
    @GetMapping
    public List<Employee> getMethod() {
       return hws.getMethod();
    }
    @PostMapping
    public String postMethod(@RequestBody Employee employee) {
        return hws.addEmployee(employee);
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {

        return hws.getEmployeeById(id);
    }
    @PutMapping({"/{id}"})
    public String putMethod(@RequestBody Employee employee) {
        return hws.putMethod( employee);
    }
    @DeleteMapping("/{id}")

    public String deleteMethod(@PathVariable int id) {
        return hws.deleteMethod(id);
    }
}
