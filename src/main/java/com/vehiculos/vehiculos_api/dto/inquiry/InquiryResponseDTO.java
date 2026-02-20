package com.vehiculos.vehiculos_api.dto.inquiry;

import com.vehiculos.vehiculos_api.dto.vehicle.VehicleResponseDTO;
import com.vehiculos.vehiculos_api.dto.vehicle.VehicleSummaryResponseDTO;
import com.vehiculos.vehiculos_api.entity.enums.InquiryStatus;
import java.time.LocalDateTime;

public class InquiryResponseDTO {
    private Long id;
    private VehicleSummaryResponseDTO vehicle;// modo lista
    private String comentarios;
    private InquiryStatus estado;
    private LocalDateTime fechaCreacion;


    public InquiryResponseDTO(Long id, VehicleSummaryResponseDTO vehicle, String comentarios,
                              InquiryStatus estado, LocalDateTime fechaCreacion) {
        this.id = id;
        this.vehicle = vehicle;
        this.comentarios = comentarios;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }


    public Long getId() {
        return id;
    }

    public VehicleSummaryResponseDTO getVehicle() {
        return vehicle;
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
