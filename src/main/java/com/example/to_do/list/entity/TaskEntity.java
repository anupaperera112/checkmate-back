package com.example.to_do.list.entity;

import com.example.to_do.list.DTO.TaskDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "taskentity")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {
    @Id
    @Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskId;
    @Column(name = "task_title")
    private String taskTitle;
    @Column(name = "task_start_date")
    private Date taskStartDate;
    @Column(name = "task_end_date")
    private Date taskEndDate;
    @Column(name = "task_status")
    private String taskStatus;

    public static TaskEntity newTaskEntity(TaskDTO taskDTO){
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTaskTitle(taskDTO.getTaskTitle());
        taskEntity.setTaskStartDate(new Date());
        taskEntity.setTaskEndDate(taskDTO.getTaskEndDate());
        taskEntity.setTaskStatus(taskDTO.getTaskStatus());
        return taskEntity;
    }

}
