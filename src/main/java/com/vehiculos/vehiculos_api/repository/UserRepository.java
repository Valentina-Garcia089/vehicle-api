package com.vehiculos.vehiculos_api.repository;

import com.vehiculos.vehiculos_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //buscar usuario por email verificando que los datos del login coincidan con la BD
    Optional<User> findByEmail(String email);

    //verificar que no hayan emails duplicados
    boolean existsByEmailIgnoreCase(String email);
}
