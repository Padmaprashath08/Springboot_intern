package com.example.to_do.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tasks {
    @Id
    private int taskId;
    private String taskName;
    private String taskDescription;
    private String taskStatus;
}
