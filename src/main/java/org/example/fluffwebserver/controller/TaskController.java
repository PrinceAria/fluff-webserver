package org.example.fluffwebserver.controller;

import org.example.fluffwebserver.persistence.TaskRepository;
import org.example.fluffwebserver.entity.Task;
import org.example.fluffwebserver.persistence.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public record TaskController(TaskRepository taskRepository, UserRepository userRepository) {
    @GetMapping("tasks/{id}")
    public List<Task> findAllByUserId(@PathVariable Long id) {
        return taskRepository.findTasksByUserId(id);
    }

    @PostMapping("tasks/{id}/new")
    public ResponseEntity<Task> createTask(@PathVariable Long id, @RequestBody Task task) {
        if (task.getTitle().length() > 255) {
            task.setTitle(task.getTitle().substring(0, 255));
        }
        task.setUser(userRepository.findById(id).orElseThrow());
        task.setId(getHighestId() + 1);
        return ResponseEntity.ok(taskRepository.save(task));
    }

    @DeleteMapping("tasks/delete/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.delete(taskRepository.findById(id).orElseThrow());
    }

    @PutMapping("tasks/{id}/update")
    public void updateTaskCompletion(@PathVariable Long id, @RequestParam boolean value) {
        taskRepository.updateTaskById(id, value);
    }

    public Long getHighestId() {
        if (taskRepository.findAll().isEmpty())
            return 0L;
        return taskRepository.getHighestId();
    }
}
