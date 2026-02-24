package com.vehiculos.vehiculos_api.service.impl;

import com.vehiculos.vehiculos_api.dto.auth.AuthResponse;
import com.vehiculos.vehiculos_api.dto.auth.LoginRequest;
import com.vehiculos.vehiculos_api.dto.auth.UserRegisterRequestDTO;
import com.vehiculos.vehiculos_api.dto.user.UserResponseDTO;
import com.vehiculos.vehiculos_api.entity.User;
import com.vehiculos.vehiculos_api.entity.enums.UserRole;
import com.vehiculos.vehiculos_api.exception.DuplicatedEmailException;
import com.vehiculos.vehiculos_api.mapper.UserMapper;
import com.vehiculos.vehiculos_api.security.JwtService;
import com.vehiculos.vehiculos_api.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserServiceImpl userService;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthServiceImpl(UserServiceImpl userService, UserMapper userMapper,
                           PasswordEncoder passwordEncoder, JwtService jwtService,
                           AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }


    public AuthResponse register (UserRegisterRequestDTO dto){
        if (userService.existsByEmail(dto.getEmail()))
            throw new DuplicatedEmailException("Email "+dto.getEmail()+" duplicado");

        User user = userMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRol(UserRole.USER);
        User savedUser = userService.saveUser(user);

        String token = jwtService.generateToken(savedUser); //generación de token jwt

        UserResponseDTO userResponseDTO = userMapper.toResponse(user);

        return new AuthResponse(token, userResponseDTO);
    }



    public AuthResponse login(LoginRequest dto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getEmail(),
                        dto.getPassword()
                )
        );

        //flujo de que los datos son correctos:
        User user = userService.getUserByEmail(dto.getEmail());
        String token = jwtService.generateToken(user);

        UserResponseDTO userResponseDTO = userMapper.toResponse(user);

        return new AuthResponse(token, userResponseDTO);
    }
}
