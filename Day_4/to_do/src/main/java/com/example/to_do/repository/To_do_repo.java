package com.example.to_do.repository;

import com.example.to_do.models.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface To_do_repo extends JpaRepository<Tasks,Integer> {

    List<Tasks> findByTaskName(String taskName);
}
