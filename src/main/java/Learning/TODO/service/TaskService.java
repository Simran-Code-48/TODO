package Learning.TODO.service;

import java.time.LocalDateTime;

import Learning.TODO.model.Task;
import Learning.TODO.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// @Service marks this class as a Spring service component
@Service
public class TaskService {

    // Dependency injection of TaskRepository
    private final TaskRepository taskRepository;

    // Constructor-based dependency injection
    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Get all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    
    // Get incomplete tasks only
    public List<Task> getIncompleteTasks() {
        return taskRepository.findByCompleted(false);
    }
    
    // Search tasks by keyword
    public List<Task> searchTasks(String keyword) {
        return taskRepository.findByDescriptionContainingIgnoreCase(keyword);
    }
    
    // Create a new task
    public Task createTask(Task task) {
        // Set creation timestamp
        task.setCreatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }
    
    // Update task completion status
    // @Transactional ensures database consistency
    @Transactional
    public Task updateTaskStatus(Long id, boolean completed) {
        // Find task by ID or throw exception if not found
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
        
        // Update status
        task.setCompleted(completed);
        return taskRepository.save(task);
    }
    
    // Delete a task
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}