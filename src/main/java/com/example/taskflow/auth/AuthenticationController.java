package com.example.taskflow.auth;

import com.example.taskflow.Dtos.request.AuthenticateRequest;
import com.example.taskflow.Dtos.request.RegisterRequest;
import com.example.taskflow.Dtos.response.AuthenticationResponse;
import com.example.taskflow.service.Impl.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticateRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}