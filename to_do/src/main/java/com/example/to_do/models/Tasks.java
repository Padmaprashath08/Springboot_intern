package com.example.to_do.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tasks {
    private int taskId;
    private String taskName;
    private String taskDescription;
    private String taskStatus;
}
