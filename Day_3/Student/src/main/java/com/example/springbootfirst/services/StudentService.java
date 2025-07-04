package com.example.springbootfirst.services;

import com.example.springbootfirst.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class StudentService {
    List<Student> std = new ArrayList<>(
            Arrays.asList(new Student(1,"padmaprashath",20,"padmaprashath@gmail.com"))
    );


    public List<Student> getStudentdetails() {
        return std;
    }

    public String addstudent(Student student) {
        std.add(student);
        return "Student added sucessfully";
    }

    public String updatestudent(int studentid, Student student) {
        for(int i=0;i<std.size();i++){
            if(std.get(i).getStudentid()==studentid){
                std.set(i,student);
                return "Student updated sucessfully";
            }
        }
        return "Student not found";
    }

    public String deletestudent(int studentid) {
        for(int i=0;i<std.size();i++){
            if(std.get(i).getStudentid()==studentid){
                std.remove(i);
                return "Student deleted sucessfully";
            }
        }
        return "Student not found";
    }


}
