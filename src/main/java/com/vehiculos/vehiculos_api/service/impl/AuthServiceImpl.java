package com.vehiculos.vehiculos_api.service.impl;

import com.vehiculos.vehiculos_api.dto.auth.AuthResponse;
import com.vehiculos.vehiculos_api.dto.auth.LoginRequest;
import com.vehiculos.vehiculos_api.dto.auth.UserRegisterRequestDTO;
import com.vehiculos.vehiculos_api.dto.user.UserResponseDTO;
import com.vehiculos.vehiculos_api.entity.User;
import com.vehiculos.vehiculos_api.entity.enums.UserRole;
import com.vehiculos.vehiculos_api.exception.DuplicatedEmailException;
import com.vehiculos.vehiculos_api.mapper.UserMapper;
import com.vehiculos.vehiculos_api.service.AuthService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserServiceImpl userService;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserServiceImpl userService, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }


    public AuthResponse register (UserRegisterRequestDTO dto){
        if (userService.existsByEmail(dto.getEmail()))
            throw new DuplicatedEmailException("Email "+dto.getEmail()+" duplicado");

        User user = userMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRol(UserRole.USER);
        User savedUser = userService.saveUser(user); //REVISAR ESTO PORQUE NO SÉ SI LO QUE RECIBE DEBERÍA SER DE TIPO USER

        //TODO: generar el token con JWT

        UserResponseDTO userResponseDTO = userMapper.toResponse(user);

        return new AuthResponse("", userResponseDTO);
    }



    public AuthResponse login(LoginRequest dto) {
        User user = userService.getUserByEmail(dto.getEmail());

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Email o contraseña incorrectos");
        }

        //TODO: generar el token con JWT

        UserResponseDTO userResponseDTO = userMapper.toResponse(user);

        return new AuthResponse("", userResponseDTO);
    }
}
