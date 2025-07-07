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
        public List<Tasks> getTasks() {
            return s.getTasks();
        }
        @PostMapping
        public String addTasks(@RequestBody Tasks tasks) {
            return s.addTasks(tasks);
        }
        @GetMapping("/{id}")
        public Tasks getTaskById(@PathVariable int id) {

            return s.getTaskById(id);
        }
        @PutMapping
        public String Updatetasks(@RequestBody Tasks tasks) {
            return s.UpdateTasks(tasks);
        }
        @DeleteMapping("/{id}")
        public String deletetasksbyid(@PathVariable int id) {

            return s.DeleteTasks(id);
        }
        @GetMapping("/taskname/{name}")
        public List<Tasks> getTasksByName(@PathVariable String name) {
            return s.getTaskByName(name);
        }
        @DeleteMapping
        public String deletealltasks(){
            return s.deletealltasks();
        }


}
