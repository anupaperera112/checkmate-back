package com.example.to_do.list.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskListDTO {
    private int taskId;
    private int userId;
    private String taskCategoryName;
}
