package com.example.to_do.list.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "task")
public class TaskEntity {
    @Id
    @Column(name = "task_id")
    private int taskId;
    @Column(name = "task_title")
    private String taskTitle;
    @Column(name = "task_start_date")
    private Date taskStartDate;
    @Column(name = "task_end_date")
    private Date taskEndDate;
    @Column(name = "task_status")
    private String taskStatus;

    public TaskEntity(int taskId, String taskTitle, Date taskStartDate, Date taskEndDate, String taskStatus) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.taskStartDate = taskStartDate;
        this.taskEndDate = taskEndDate;
        this.taskStatus = taskStatus;
    }

    public TaskEntity() {
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
}
