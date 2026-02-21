package com.vehiculos.vehiculos_api.service;

import com.vehiculos.vehiculos_api.dto.auth.AuthResponse;
import com.vehiculos.vehiculos_api.dto.auth.LoginRequest;
import com.vehiculos.vehiculos_api.dto.auth.UserRegisterRequestDTO;

public interface AuthService {
    AuthResponse register (UserRegisterRequestDTO dto);
    AuthResponse login(LoginRequest dto);
}
