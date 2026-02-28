package com.vehiculos.vehiculos_api.dto.inquiry;

import com.vehiculos.vehiculos_api.entity.enums.InquiryStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class InquiryStatusUpdateRequesDTO {
    @NotNull
    private InquiryStatus estado;

    public InquiryStatusUpdateRequesDTO () {}


    public InquiryStatus getEstado() {
        return estado;
    }

    public void setEstado(InquiryStatus estado) {
        this.estado = estado;
    }
}
