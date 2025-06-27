package Learning.TODO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @SpringBootApplication enables Spring Boot auto-configuration
// and component scanning in the current package and sub-packages
public class TodoApplication {
    public static void main(String[] args) {
        // Starts the Spring Boot application
        SpringApplication.run(TodoApplication.class, args);
    }
}