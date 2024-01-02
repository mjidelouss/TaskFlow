package com.example.taskflow.Dtos;

import com.example.taskflow.entities.User;
import com.example.taskflow.enums.TaskActionType;
import com.example.taskflow.enums.TaskStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotEmpty(message = "At least one tag is required")
    @Size(min = 3, message = "At least three tags are required")
    private List<String> tags;

    @NotNull(message = "Deadline is required")
    @Future(message = "Deadline must be in the future")
    private LocalDateTime deadline;

    @NotNull(message = "Creation date is required")
    @FutureOrPresent(message = "Creation date must be in the present or the future")
    private LocalDateTime creationDate;

    @NotNull(message = "Created By is required")
    private Long createdBy;
}