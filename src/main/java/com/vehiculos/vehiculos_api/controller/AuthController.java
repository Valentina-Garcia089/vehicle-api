package com.vehiculos.vehiculos_api.controller;

import com.vehiculos.vehiculos_api.dto.auth.AuthResponse;
import com.vehiculos.vehiculos_api.dto.auth.UserRegisterRequestDTO;
import com.vehiculos.vehiculos_api.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody UserRegisterRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(dto));
    }
}

