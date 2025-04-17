package com.samuellmoraes.todoapi.repository;

import com.samuellmoraes.todoapi.model.Task;
import com.samuellmoraes.todoapi.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(TaskStatus status);
    List<Task> findByDataLimite(LocalDate dataLimite);
}
