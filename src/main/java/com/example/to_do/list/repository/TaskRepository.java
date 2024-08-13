package com.example.to_do.list.repository;

import com.example.to_do.list.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {
    TaskEntity findByTaskId(int taskId);
}
