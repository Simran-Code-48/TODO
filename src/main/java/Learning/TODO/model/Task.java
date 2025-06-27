package Learning.TODO.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

// @Entity marks this class as a JPA entity (database table)
@Entity
@Table(name = "tasks") // Specifies the table name in the database
public class Task {
    
    // @Id marks this field as the primary key
    // @GeneratedValue configures auto-generation strategy
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // @Column defines column properties
    @Column(nullable = false) // This field cannot be null
    private String description;
    
    // Default value for completed status
    private boolean completed = false;
    
    // Automatically set creation timestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    // Will be set when task is updated
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Default constructor (required by JPA)
    public Task() {
    }
    
    // Convenience constructor for creating new tasks
    public Task(String description) {
        this.description = description;
        this.createdAt = LocalDateTime.now();
    }
    
    // Lifecycle callback - automatically called before update
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    //----- Getters and Setters -----//
    // Required for JPA to access private fields
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    // toString() for debugging/logging
    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}

