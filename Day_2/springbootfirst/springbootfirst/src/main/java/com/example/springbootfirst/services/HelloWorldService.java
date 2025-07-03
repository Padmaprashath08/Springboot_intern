package com.example.springbootfirst.services;

import com.example.springbootfirst.models.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloWorldService {
    List<Employee> emp = new ArrayList<>(
            Arrays.asList(new Employee(1, "prashath", "developer"), new Employee(2, "jack", "Tester"))
    );


    public List<Employee> getMethod(){
        return emp;
    }

    public String postMethod() {
        return "this is post method!";
    }

    public String putMethod() {
        return "this is put method!";
    }
    public String deleteMethod() {
        return "this is delete method!";
    }
}
