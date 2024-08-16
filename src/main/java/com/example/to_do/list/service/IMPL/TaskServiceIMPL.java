package com.example.to_do.list.service.IMPL;

import com.example.to_do.list.DTO.TaskDTO;
import com.example.to_do.list.entity.TaskEntity;
import com.example.to_do.list.repository.TaskRepository;
import com.example.to_do.list.service.TaskService;
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

    @Override
    public int createTask(TaskDTO taskDTO) {
        TaskEntity taskEntity = TaskEntity.newTaskEntity(taskDTO);
        taskRepository.save(taskEntity);
        if(taskEntity.getTaskId() > 0){
            return taskEntity.getTaskId();
        }else{
            throw new RuntimeException("error when creating the task");
        }

    }

    @Override
    public boolean deleteTask(int taskId) {
        if(taskRepository.existsById(taskId)){
            taskRepository.deleteById(taskId);
            return true;
        }else {
            return false;
        }
    }

}
