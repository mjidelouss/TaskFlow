package com.example.taskflow.entities;

import com.example.taskflow.enums.TaskActionType;
import com.example.taskflow.enums.TaskStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @ManyToMany
    private List<Tag> tags;

    @NotNull(message = "Deadline is required")
    @Future(message = "Deadline must be in the future")
    private LocalDateTime deadline;

    @NotNull(message = "Completed status is required")
    private Boolean completed;

    @ElementCollection
    @NotEmpty(message = "Status list cannot be empty")
    @Enumerated(EnumType.STRING)
    private List<TaskStatus> status;

    @Enumerated(EnumType.STRING)
    private TaskActionType actionType;

    @ManyToOne
    @JoinColumn(name = "assigned_to_id")
    private User assignedTo;

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private User createdBy;

    @NotNull(message = "Creation date is required")
    @FutureOrPresent(message = "Creation date must be in the present or the future")
    private LocalDateTime creationDate;

    private LocalDateTime modificationDate;
}