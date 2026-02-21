package com.vehiculos.vehiculos_api.repository;

import com.vehiculos.vehiculos_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //PARA AUTH

    //verificar que no hayan emails duplicados
    boolean existsByEmailIgnoreCase(String email);

    //buscar usuario por email verificando que los datos del login coincidan con la BD
    Optional<User> findByEmail(String email);
}
