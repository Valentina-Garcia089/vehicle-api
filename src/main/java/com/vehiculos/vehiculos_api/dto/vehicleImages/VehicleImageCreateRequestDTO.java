package com.vehiculos.vehiculos_api.dto.vehicleImages;

import jakarta.validation.constraints.NotBlank;

public class VehicleImageCreateRequestDTO {
    @NotBlank
    private String imageUrl;

    public VehicleImageCreateRequestDTO () {}


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
