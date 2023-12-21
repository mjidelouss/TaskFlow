package com.example.taskflow.entities;

import com.example.taskflow.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "")
    private String username;

    @NotBlank(message = "")
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;
}
