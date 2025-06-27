package Learning.TODO.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Learning.TODO.model.Task;

import java.util.List;

// JpaRepository provides CRUD operations for Task entity
// First generic parameter: Entity type
// Second generic parameter: Type of the primary key
public interface TaskRepository extends JpaRepository<Task, Long> {
    
    // Spring Data JPA automatically implements this method
    // based on method name convention
    List<Task> findByCompleted(boolean completed);
    
    // Custom query method to find tasks containing keyword
    // (case-insensitive search)
    List<Task> findByDescriptionContainingIgnoreCase(String keyword);
}

