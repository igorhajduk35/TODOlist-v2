package com.example.todoapp.task.controller;

import com.example.todoapp.task.model.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.todoapp.task.service.TaskService;

import java.util.List;

// [{

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @GetMapping("/all")
    public List<Task> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Task createTask(@RequestBody Task req) {
        return service.createTask(req);
    }

    @PutMapping("/deleteTask/{id}")
    public Task deleteTask(@PathVariable long id) {
        return service.deleteTask(id);
    }

    @GetMapping("/{id}")
    public Task findById(@PathVariable long id) {
        return service.findById(id);
    }
}
