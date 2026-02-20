package com.vehiculos.vehiculos_api.dto.user;

import com.vehiculos.vehiculos_api.entity.enums.UserRole;

public class UserResponseDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String celular;
    private UserRole rol;

    public UserResponseDTO(Long id, String nombre, String apellido, String email, String celular, UserRole rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.celular = celular;
        this.rol = rol;
    }


    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getCelular() {
        return celular;
    }

    public UserRole getRol() {
        return rol;
    }
}
