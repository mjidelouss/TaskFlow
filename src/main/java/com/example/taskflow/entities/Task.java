package com.example.taskflow.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.util.Date;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "")
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @PastOrPresent(message = "")
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Future(message = "")
    private Date deadline;

    private boolean completed;
}
