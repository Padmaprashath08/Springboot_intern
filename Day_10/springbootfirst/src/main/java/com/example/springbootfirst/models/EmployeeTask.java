//package com.example.springbootfirst.models;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "employee_tasks")
//public class EmployeeTask {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int taskId;
//
//    private String title;
//
//    private String description;
//
//    private String dueDate;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "employee_id", nullable = false)
//    @JsonBackReference
//    private RegisterDetails employee;
//}