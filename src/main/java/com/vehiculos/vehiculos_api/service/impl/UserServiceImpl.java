package com.vehiculos.vehiculos_api.service.impl;

import com.vehiculos.vehiculos_api.dto.user.UserResponseDTO;
import com.vehiculos.vehiculos_api.dto.user.UserUpdateRequestDTO;
import com.vehiculos.vehiculos_api.entity.User;
import com.vehiculos.vehiculos_api.exception.ResourceNotFoundException;
import com.vehiculos.vehiculos_api.mapper.UserMapper;
import com.vehiculos.vehiculos_api.repository.UserRepository;
import com.vehiculos.vehiculos_api.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
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

    public UserResponseDTO getUserById (Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Usuario "+ userId + " no encontrado"));

        return userMapper.toResponse(user);
    }


    public UserResponseDTO updateUser (Long userId, UserUpdateRequestDTO dto){
        User user = userRepository.findById(userId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Usuario "+ userId + " no encontrado"));

        userMapper.updateEntity(user, dto);
        User updatedUser = userRepository.save(user);
        return userMapper.toResponse(updatedUser);
    }
}
