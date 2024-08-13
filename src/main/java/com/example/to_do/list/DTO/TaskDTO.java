package com.example.to_do.list.DTO;

import com.example.to_do.list.entity.TaskEntity;

import java.util.Date;

public class TaskDTO {
    private int taskId;
    private String taskTitle;
    private Date taskStartDate;
    private Date taskEndDate;
    private String taskStatus;

    public TaskDTO(int taskId, String taskTitle, Date taskStartDate, Date taskEndDate, String taskStatus) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.taskStartDate = taskStartDate;
        this.taskEndDate = taskEndDate;
        this.taskStatus = taskStatus;
    }

    public TaskDTO() {
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public Date getTaskStartDate() {
        return taskStartDate;
    }

    public void setTaskStartDate(Date taskStartDate) {
        this.taskStartDate = taskStartDate;
    }

    public Date getTaskEndDate() {
        return taskEndDate;
    }

    public void setTaskEndDate(Date taskEndDate) {
        this.taskEndDate = taskEndDate;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public static TaskDTO getTaskByID(TaskEntity taskEntity){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTaskTitle(taskEntity.getTaskTitle());
        taskDTO.setTaskStartDate(taskEntity.getTaskStartDate());
        taskDTO.setTaskEndDate(taskEntity.getTaskEndDate());
        taskDTO.setTaskStatus(taskEntity.getTaskStatus());
        return taskDTO;
    }
}
