package com.example.to_do.list.entity.taskList;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "task_list")
@IdClass(TaskListEntityId.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskListEntity {
    @Id
    private int userId;
    @Id
    private String taskCategoryName;
    private int taskId;

}
