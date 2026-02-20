package com.vehiculos.vehiculos_api.dto.vehicleImages;

public class VehicleImageResponseDTO {
    private Long id;
    private Long vehicleId;
    private String imageUrl;


    public VehicleImageResponseDTO(Long id, Long vehicleId, String imageUrl) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.imageUrl = imageUrl;
    }


    public Long getId() {
        return id;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
