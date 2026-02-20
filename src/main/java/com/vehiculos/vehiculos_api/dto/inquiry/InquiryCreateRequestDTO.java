package com.vehiculos.vehiculos_api.dto.inquiry;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class InquiryCreateRequestDTO {
    @NotBlank
    @Positive
    private Long vehicleId;

    private String comentarios;

    public InquiryCreateRequestDTO() {}


    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
