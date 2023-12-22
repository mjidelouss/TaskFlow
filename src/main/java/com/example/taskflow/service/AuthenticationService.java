package com.example.taskflow.service;
import com.example.taskflow.security.dao.request.SignUpRequest;
import com.example.taskflow.security.dao.request.SigninRequest;
import com.example.taskflow.security.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);
    JwtAuthenticationResponse signin(SigninRequest request);
}
