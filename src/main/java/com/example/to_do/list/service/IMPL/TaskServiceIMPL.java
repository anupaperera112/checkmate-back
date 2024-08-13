package com.example.to_do.list.service.IMPL;

import com.example.to_do.list.DTO.TaskDTO;
import com.example.to_do.list.entity.TaskEntity;
import com.example.to_do.list.repository.TaskRepository;
import com.example.to_do.list.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceIMPL implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public TaskDTO getTasks(int taskId) {
        TaskEntity taskEntity = taskRepository.findByTaskId(taskId);
        if (taskEntity != null){
            TaskDTO taskDTO = TaskDTO.getTaskByID(taskEntity);
            return taskDTO;
        }else {
            throw new RuntimeException("no data");
        }
    }
}
