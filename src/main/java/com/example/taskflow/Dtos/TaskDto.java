package com.example.taskflow.Dtos;

import com.example.taskflow.enums.TaskActionType;
import com.example.taskflow.enums.TaskStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    private List<String> tags;

    @NotNull(message = "Deadline is required")
    @Future(message = "Deadline must be in the future")
    private LocalDateTime deadline;

    @NotNull(message = "Completed status is required")
    private Boolean completed;

    @NotEmpty(message = "At least one status is required")
    @Enumerated(EnumType.STRING)
    private List<TaskStatus> status;

    @Enumerated(EnumType.STRING)
    private TaskActionType actionType;

    @NotNull(message = "AssignedTo is required")
    private Long assignedToId;

    @NotNull(message = "CreatedBy is required")
    private Long createdById;
}