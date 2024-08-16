package com.example.to_do.list.DTO;

import com.example.to_do.list.entity.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
    private int taskId;
    private String taskTitle;
    private Date taskStartDate;
    private Date taskEndDate;
    private String taskStatus;


    public static TaskDTO getTaskByID(TaskEntity taskEntity){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTaskTitle(taskEntity.getTaskTitle());
        taskDTO.setTaskStartDate(taskEntity.getTaskStartDate());
        taskDTO.setTaskEndDate(taskEntity.getTaskEndDate());
        taskDTO.setTaskStatus(taskEntity.getTaskStatus());
        return taskDTO;
    }

    public static TaskDTO task(TaskEntity taskEntity){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTaskTitle(taskEntity.getTaskTitle());
        taskDTO.setTaskStartDate(taskEntity.getTaskStartDate());
        taskDTO.setTaskEndDate(taskEntity.getTaskEndDate());
        taskDTO.setTaskStatus(taskEntity.getTaskStatus());
        return taskDTO;
    }
}
