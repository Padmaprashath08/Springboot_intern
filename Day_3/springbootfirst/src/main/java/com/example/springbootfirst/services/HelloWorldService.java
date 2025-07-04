package com.example.springbootfirst.services;

import com.example.springbootfirst.models.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

    public String postMethod(Employee employee) {
        emp.add(employee);
        return "Employee posted successfully!";
    }

    public String putMethod(int id, @RequestBody Employee employee) {
        for(int i=0;i<emp.size();i++){
            if(emp.get(i).getEmpID()==id){
               emp.set(i,employee);
            }
        }
        return "Details updated successfully!";
    }
    public String deleteMethod(int id) {
        for(int i=0;i<emp.size();i++){
            if(emp.get(i).getEmpID()==id){
                emp.remove(i);
                return "Employee deleted successfully!";
            }
        }
        return "Employee not found with the id "+id;
    }

    public Employee getEmployeeById(int id) {
        for(int i=0;i<emp.size();i++){
            if(emp.get(i).getEmpID()==id){
                return emp.get(i);
            }
        }
        return new Employee();
    }
}
