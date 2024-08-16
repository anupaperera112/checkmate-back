package com.example.to_do.list.repository;

import com.example.to_do.list.entity.taskList.TaskListEntity;
import com.example.to_do.list.entity.taskList.TaskListEntityId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskEntityRepository extends JpaRepository<TaskListEntity, TaskListEntityId> {
}
