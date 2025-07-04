package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.Student;
import com.example.springbootfirst.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService st;


   @GetMapping
    public List<Student> Studentdetails() {

       return st.getStudentdetails();
   }

    @PostMapping
    public String addStudent(@RequestBody Student student) {
       return st.addstudent(student);
    }
    @PutMapping("/{studentid}")
    public String updateStudent(@PathVariable int studentid, @RequestBody Student student) {
         return st.updatestudent(studentid,student);
    }
    @DeleteMapping("/{studentid}")
    public String deleteStudent(@PathVariable int studentid) {
       return st.deletestudent(studentid);

    }

}
