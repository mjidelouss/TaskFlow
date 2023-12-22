package com.example.taskflow.service;

import com.example.taskflow.Dtos.request.SignInRequest;
import com.example.taskflow.Dtos.request.SignUpRequest;
import com.example.taskflow.Dtos.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);
    JwtAuthenticationResponse signin(SignInRequest request);
}
