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
    public List<Employee> getMethod() {
       return hws.getMethod();
    }
    @PostMapping("/")
    public String postMethod() {
        return hws.postMethod();
    }
    @PutMapping("/")
    public String putMethod() {
        return hws.putMethod();
    }
    @DeleteMapping("/")
    public String deleteMethod() {
        return hws.deleteMethod();
    }
}
