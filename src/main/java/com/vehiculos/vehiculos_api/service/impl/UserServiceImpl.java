package com.vehiculos.vehiculos_api.service.impl;

import com.vehiculos.vehiculos_api.dto.user.UserResponseDTO;
import com.vehiculos.vehiculos_api.dto.user.UserUpdateRequestDTO;
import com.vehiculos.vehiculos_api.entity.User;
import com.vehiculos.vehiculos_api.exception.ResourceNotFoundException;
import com.vehiculos.vehiculos_api.mapper.UserMapper;
import com.vehiculos.vehiculos_api.repository.UserRepository;
import com.vehiculos.vehiculos_api.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public User getAuthenticatedUserEntity() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado en la sesión actual"));
    }


    //AUTH

    public User saveUser (User user){
        return userRepository.save(user);
    }


    public boolean existsByEmail (String email){
        return userRepository.existsByEmailIgnoreCase(email);
    }


    public User getUserByEmail (String email){
        return userRepository.findByEmail(email)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Email "+ email + " no encontrado"));

    }





    //USER

    public UserResponseDTO getUserById (){
        User user = getAuthenticatedUserEntity();
        return userMapper.toResponse(user);
    }


    public UserResponseDTO updateUser (UserUpdateRequestDTO dto){
        User user = getAuthenticatedUserEntity();
        userMapper.updateEntity(user, dto);
        User updatedUser = userRepository.save(user);
        return userMapper.toResponse(updatedUser);
    }
}
