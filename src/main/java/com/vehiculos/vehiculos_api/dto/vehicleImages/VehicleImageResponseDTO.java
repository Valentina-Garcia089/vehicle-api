package com.vehiculos.vehiculos_api.dto.vehicleImages;

public class VehicleImageResponseDTO {
    private Long id;
    private String imageUrl;


    public VehicleImageResponseDTO(Long id, String imageUrl) {
        this.id = id;
        this.imageUrl = imageUrl;
    }


    public Long getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
