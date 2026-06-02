package com.example.todoapp.task.repository;

import com.example.todoapp.task.model.Task;

import java.util.List;

public interface TaskRepository {
    List<Task> findAll();

    Task createTask(Task task);
}
