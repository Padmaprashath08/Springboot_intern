package com.example.springbootfirst.repository;

import com.example.springbootfirst.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
