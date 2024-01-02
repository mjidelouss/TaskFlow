package com.example.taskflow.service.Impl;

import com.example.taskflow.entities.User;
import com.example.taskflow.repository.UserRepository;
import com.example.taskflow.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    public Long getUserIdByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return (user != null) ? user.getId() : null;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
