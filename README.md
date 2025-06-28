# TODO Application

## Overview
A simple task management system with basic CRUD operations.

## Features
- Create, read, update, delete tasks  
- Mark tasks as complete/incomplete  
- Search functionality  
- Created/updated timestamps  

## API Wrapper Package

```java
// Maven Dependency
<dependency>
    <groupId>learning</groupId>
    <artifactId>todo-system</artifactId>
    <version>1.0.0</version>
</dependency>

// Basic Usage
TodoClient client = new TodoClient();
Task newTask = client.createTask("Buy groceries");
```

## API Endpoints

| Method | Endpoint              | Description        |
|--------|-----------------------|--------------------|
| GET    | `/api/tasks`          | Get all tasks      |
| POST   | `/api/tasks`          | Create new task    |
| PATCH  | `/api/tasks/{id}`     | Update task status |
| DELETE | `/api/tasks/{id}`     | Delete a task      |

## Quick Start

Run with Docker:

```bash
docker-compose up
```

Access Swagger UI at:

```
http://localhost:8080/swagger-ui.html
```
