package com.example.to_do.list.repository;

import com.example.to_do.list.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {
    TaskEntity findByTaskId(int taskId);
}
