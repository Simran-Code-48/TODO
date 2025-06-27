package Learning.TODO.controller;

import Learning.TODO.model.Task;
import Learning.TODO.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController marks this as a REST controller
// @RequestMapping sets the base URL for all endpoints in this controller
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    // Inject TaskService via constructor
    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // GET all tasks
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    // GET incomplete tasks only
    @GetMapping("/incomplete")
    public ResponseEntity<List<Task>> getIncompleteTasks() {
        return ResponseEntity.ok(taskService.getIncompleteTasks());
    }

    // GET tasks by search keyword
    @GetMapping("/search")
    public ResponseEntity<List<Task>> searchTasks(@RequestParam String q) {
        return ResponseEntity.ok(taskService.searchTasks(q));
    }

    // POST create a new task
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        // HTTP 201 Created status with the new task in response body
        return new ResponseEntity<>(taskService.createTask(task), HttpStatus.CREATED);
    }

    // PATCH update task status (partial update)
    @PatchMapping("/{id}/status")
    public ResponseEntity<Task> updateTaskStatus(
            @PathVariable Long id, 
            @RequestParam boolean completed) {
        return ResponseEntity.ok(taskService.updateTaskStatus(id, completed));
    }

    // DELETE a task
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        // HTTP 204 No Content for successful deletion
        return ResponseEntity.noContent().build();
    }
}

