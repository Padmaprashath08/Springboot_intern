package com.example.to_do.services;

import com.example.to_do.models.Tasks;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class To_do_service {
    List<Tasks> emp = new ArrayList<>(
            Arrays.asList(new Tasks(1, "Learn coding", "Learn coding","in_progress"), new Tasks(2, "Learn springboot", "Learn springboot","in_progress"))
    );
    public List<Tasks> getMethod(){
        return emp;
    }

    public String postMethod(Tasks tasks) {
        emp.add(tasks);
        return "Task added successfully!";
    }

    public String putMethod(int id, @RequestBody Tasks tasks) {
        for(int i=0;i<emp.size();i++){
            if(emp.get(i).getTaskId()==id){
                emp.set(i,tasks);
            }
        }
        return "Task updated successfully!";
    }
    public String deleteMethod(int id) {
        for(int i=0;i<emp.size();i++){
            if(emp.get(i).getTaskId()==id){
                emp.remove(i);
                return "Task deleted successfully!";
            }
        }
        return "Task not found with the id "+id;
    }

    public  Tasks getTaskById(int id) {
        for(int i=0;i<emp.size();i++){
            if(emp.get(i).getTaskId()==id){
                return emp.get(i);
            }
        }
        return new Tasks();
    }
}
