package com.vehiculos.vehiculos_api.mapper;

import com.vehiculos.vehiculos_api.dto.auth.UserRegisterRequestDTO;
import com.vehiculos.vehiculos_api.dto.user.UserResponseDTO;
import com.vehiculos.vehiculos_api.dto.user.UserUpdateRequestDTO;
import com.vehiculos.vehiculos_api.entity.User;
import org.mapstruct.*;

@Mapper (componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "rol", ignore = true)
    User toEntity (UserRegisterRequestDTO dto);

    @Mapping(target = "email", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "rol", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity (@MappingTarget User user, UserUpdateRequestDTO dto);

    @Mapping(target = "rol", ignore = true)
    UserResponseDTO toResponse (User user);
}
