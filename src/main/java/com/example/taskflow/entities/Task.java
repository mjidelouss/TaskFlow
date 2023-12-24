package com.example.taskflow.entities;

import com.example.taskflow.enums.TaskActionType;
import com.example.taskflow.enums.TaskStatus;
import jakarta.persistence.*;
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

    private String title;

    private String description;

    @ManyToMany
    private List<Tag> tags;

    private LocalDateTime deadline;

    private boolean completed;

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

    private LocalDateTime creationDate;

    private LocalDateTime modificationDate;
}