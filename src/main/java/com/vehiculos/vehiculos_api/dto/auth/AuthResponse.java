package com.vehiculos.vehiculos_api.dto.auth;

import com.vehiculos.vehiculos_api.dto.user.UserResponseDTO;

public class AuthResponse {
    private String token;
    private String type = "Bearer";
    private UserResponseDTO user;

    public AuthResponse(String token, UserResponseDTO user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public String getType() {
        return type;
    }

    public UserResponseDTO getUser() {
        return user;
    }
}
