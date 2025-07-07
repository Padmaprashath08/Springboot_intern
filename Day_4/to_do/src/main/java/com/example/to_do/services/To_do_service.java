package com.example.to_do.services;

import com.example.to_do.models.Tasks;
import com.example.to_do.repository.To_do_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class To_do_service {

    @Autowired
    To_do_repo todo;
    public List<Tasks> getTasks() {
        return todo.findAll();

    }

    public String addTasks(Tasks tasks) {
        todo.save(tasks);
        return "Task added successfully!";
    }

    public String UpdateTasks(@RequestBody Tasks tasks) {
       todo.save(tasks);
        return "Task updated successfully!";
    }
    public String DeleteTasks(int id) {
        todo.deleteById(id);
        return "Task  deleted successfully!";
    }

    public  Tasks getTaskById(int id) {
        if(todo.findById(id).isPresent()){
            System.out.println(todo.findById(id));
            return todo.findById(id).orElse(null);
        }
        else {
            return new Tasks();
        }
    }
    public List<Tasks> getTaskByName(String name) {
        return  todo.findByTaskName(name);
    }

    public String deletealltasks() {
        todo.deleteAll();
        return "All tasks deleted successfully!";
    }
}
