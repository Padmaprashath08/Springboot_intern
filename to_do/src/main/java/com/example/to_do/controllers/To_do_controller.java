package com.example.to_do.controllers;

import com.example.to_do.models.Tasks;
import com.example.to_do.services.To_do_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/tasks")
public class To_do_controller {
        @Autowired
        private To_do_service s;
        @GetMapping
        public List<Tasks> getMethod() {
            return s.getMethod();
        }
        @PostMapping
        public String postMethod(@RequestBody Tasks tasks) {
            return s.postMethod(tasks);
        }
        @GetMapping("/{id}")
        public Tasks getEmployeeById(@PathVariable int id) {

            return s.getTaskById(id);
        }
        @PutMapping("/{id}")
        public String putMethod(@PathVariable int id, @RequestBody Tasks tasks) {
            return s.putMethod(id, tasks);
        }
        @DeleteMapping("/{id}")

        public String deleteMethod(@PathVariable int id) {

            return s.deleteMethod(id);
    }
}
