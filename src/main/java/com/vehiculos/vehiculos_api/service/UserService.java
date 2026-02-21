package com.vehiculos.vehiculos_api.service;

import com.vehiculos.vehiculos_api.dto.auth.UserRegisterRequestDTO;
import com.vehiculos.vehiculos_api.dto.user.UserResponseDTO;
import com.vehiculos.vehiculos_api.dto.user.UserUpdateRequestDTO;
import com.vehiculos.vehiculos_api.entity.User;

public interface UserService {
    //AUTH - en AuthService se pasa a DTO
    User saveUser (User user);
    boolean existsByEmail (String email); //register
    User getUserByEmail (String email); //login

    //USER
    UserResponseDTO getUserById (Long userId); //perfil propio
    UserResponseDTO updateUser (Long userId, UserUpdateRequestDTO dto);

}
