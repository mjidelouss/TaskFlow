package com.example.taskflow.service;

import com.example.taskflow.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService userDetailsService();
    Long getUserIdByUsername(String username);

    User getUserByUsername(String username);

    User getUserById(Long id);
}
