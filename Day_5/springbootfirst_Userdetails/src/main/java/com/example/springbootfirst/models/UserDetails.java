package com.example.springbootfirst.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Table(name="user_details")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int empId;
  @Column(name = "emp_name")
  private String empname;
  private String email;
  private String password;
  private String gender;
  @Column(name="Date_of_Birth")
  private Date dob;
  private String role;
}
