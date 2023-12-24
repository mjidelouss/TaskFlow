package com.example.taskflow.controller;

import com.example.taskflow.Dtos.TaskDto;
import com.example.taskflow.entities.Task;
import com.example.taskflow.mappers.TaskMapper;
import com.example.taskflow.response.ResponseMessage;
import com.example.taskflow.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
@RequestMapping("/api/v1/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("")
    public ResponseEntity getTasks() {
        List<Task> tasks = taskService.getTasks();
        if (tasks.isEmpty()) {
            return ResponseMessage.notFound("Tasks Not Found");
        } else {
            return ResponseMessage.ok("Success", tasks);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getTaskById(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        if (task == null) {
            return ResponseMessage.notFound("Task Not Found");
        } else {
            return ResponseMessage.ok("Success", task);
        }
    }

    public ResponseEntity createTask(@RequestBody @Valid TaskDto taskDto) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime deadline = taskDto.getDeadline();

        if (deadline != null && now.until(deadline, ChronoUnit.DAYS) > 3) {
            return ResponseMessage.badRequest("Task deadline cannot be more than 3 days in advance");
        }
        Task task = TaskMapper.mapTaskDtoToTask(taskDto);
        Task task1 = taskService.createTask(task);
        if (task1 == null) {
            return ResponseMessage.badRequest("Failed To Create Task");
        } else {
            return ResponseMessage.created("Task Created Successfully", task1);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTask(@RequestBody @Valid TaskDto taskDto, @PathVariable Long id) {
        Task existingTask = taskService.getTaskById(id);
        if (existingTask == null) {
            return ResponseMessage.notFound("Task Not Found");
        }
        LocalDateTime deadline = existingTask.getDeadline();
        boolean isCompleted = taskDto.getCompleted() != null && taskDto.getCompleted();

        if (deadline != null && isCompleted && LocalDateTime.now().isAfter(deadline)) {
            return ResponseMessage.badRequest("Task cannot be marked as completed after the deadline");
        }

        Task updatedTask = TaskMapper.mapTaskDtoToTask(taskDto);
        Task task1 = taskService.updateTask(updatedTask, id);
        if (task1 == null) {
            return ResponseMessage.badRequest("Task Not Updated");
        } else {
            return ResponseMessage.created("Task Updated Successfully", task1);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTask(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        if (task == null) {
            return ResponseMessage.notFound("Task Not Found");
        } else {
            taskService.deleteTask(id);
            return ResponseMessage.ok("Task Deleted Successfully", task);
        }
    }
}
