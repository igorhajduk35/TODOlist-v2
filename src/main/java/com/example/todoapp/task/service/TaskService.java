package com.example.todoapp.task.service;

import com.example.todoapp.task.model.Task;
import com.example.todoapp.task.repository.InMemoryTaskRepository;
import com.example.todoapp.task.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    public List<Task> getAll() {
        return repository.findAll();
    }

    public Task createTask(Task task) {
        return repository.createTask(task);
    }
}
