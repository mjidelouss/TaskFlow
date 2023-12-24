package com.example.taskflow.service;

import com.example.taskflow.entities.Task;

import java.util.List;

public interface TaskService {
    List<Task> getTasks();

    Task getTaskById(Long id);

    Task createTask(Task task);

    Task updateTask(Task task, Long id);

    void deleteTask(Long id);
}
