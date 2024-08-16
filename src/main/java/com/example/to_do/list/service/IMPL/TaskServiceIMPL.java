package com.example.to_do.list.service.IMPL;

import com.example.to_do.list.DTO.TaskDTO;
import com.example.to_do.list.entity.TaskEntity;
import com.example.to_do.list.repository.TaskRepository;
import com.example.to_do.list.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;


@Service
public class TaskServiceIMPL implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    private TaskDTO taskDTO ;

    @Override
    public TaskDTO getTasks(int taskId) {
        TaskEntity taskEntity = taskRepository.findByTaskId(taskId);
        if (taskEntity != null){
            TaskDTO taskDTO;
            taskDTO = TaskDTO.getTaskByID(taskEntity);
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

    @Override
    public TaskDTO updateTask(int taskId, TaskDTO taskDTO) {
        System.out.println(taskId);
        TaskEntity taskEntity = taskRepository.findByTaskId(taskId);
        System.out.println(taskEntity.getTaskTitle());

        if(taskEntity!=null){
            System.out.println(4);
            if(taskDTO.getTaskTitle() != null){
                taskEntity.setTaskTitle(taskDTO.getTaskTitle());
            }
            System.out.println(5);
            if(taskDTO.getTaskStatus() != null){
                taskEntity.setTaskStatus(taskDTO.getTaskStatus());
            }
            if(taskDTO.getTaskEndDate() != null){
                taskEntity.setTaskEndDate(taskDTO.getTaskEndDate());
            }
            if(taskDTO.getTaskStartDate() != null){
                taskEntity.setTaskStartDate(taskDTO.getTaskStartDate());
            }

            taskRepository.save(taskEntity);

            return  TaskDTO.task(taskEntity);
        }else {
            return null;
        }

    }
}
