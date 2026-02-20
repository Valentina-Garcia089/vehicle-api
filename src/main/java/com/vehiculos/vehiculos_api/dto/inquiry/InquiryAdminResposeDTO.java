package com.vehiculos.vehiculos_api.dto.inquiry;

import com.vehiculos.vehiculos_api.dto.user.UserResponseDTO;
import com.vehiculos.vehiculos_api.dto.vehicle.VehicleResponseDTO;
import com.vehiculos.vehiculos_api.entity.enums.InquiryStatus;

import java.time.LocalDateTime;

public class InquiryAdminResposeDTO {
    private Long id;
    private VehicleResponseDTO vehicle;
    private UserResponseDTO user;
    private String comentarios;
    private InquiryStatus estado;
    private LocalDateTime fechaCreacion;

    public InquiryAdminResposeDTO(Long id, VehicleResponseDTO vehicle, UserResponseDTO user, String comentarios, InquiryStatus estado, LocalDateTime fechaCreacion) {
        this.id = id;
        this.vehicle = vehicle;
        this.user = user;
        this.comentarios = comentarios;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }


    public Long getId() {
        return id;
    }

    public VehicleResponseDTO getVehicle() {
        return vehicle;
    }

    public UserResponseDTO getUser() {
        return user;
    }

    public String getComentarios() {
        return comentarios;
    }

    public InquiryStatus getEstado() {
        return estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
}
