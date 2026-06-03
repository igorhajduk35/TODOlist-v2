package com.example.todoapp.task.repository;

import com.example.todoapp.task.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryTaskRepository implements TaskRepository {

    private final ConcurrentHashMap<Long, Task> store = new ConcurrentHashMap<>();
    private final AtomicLong id_sequence = new AtomicLong(0);

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Task createTask(Task task) {
        if (task.getId() == null) {
            task.setId(id_sequence.incrementAndGet());
        }
        store.put(task.getId(), task);
        return task;
    }

    @Override
    public Task deleteTask(long id) {
        if (store.isEmpty()) return null;

        Task deletedTask = findById(id);

        store.remove(id);

        return deletedTask;
    }

    @Override
    public Task findById(long id) {
        if (store.isEmpty()) return null;

        return store.get(id);
    }
}
