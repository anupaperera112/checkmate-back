package com.example.to_do.list.service;

import com.example.to_do.list.DTO.TaskDTO;

public interface TaskService {
    TaskDTO getTasks(int taskId);
    int createTask(TaskDTO taskDTO);

    boolean deleteTask(int taskId);
}
