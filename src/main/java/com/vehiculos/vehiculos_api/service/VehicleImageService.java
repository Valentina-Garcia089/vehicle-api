package com.vehiculos.vehiculos_api.service;

import com.vehiculos.vehiculos_api.dto.vehicleImages.VehicleImageCreateRequestDTO;
import com.vehiculos.vehiculos_api.dto.vehicleImages.VehicleImageResponseDTO;

import java.util.List;

public interface VehicleImageService {

    VehicleImageResponseDTO addImageToVehicle(
            Long vehicleId,
            VehicleImageCreateRequestDTO dto);


    List<VehicleImageResponseDTO> getImageByVehicleId (Long vehicleId);

    void deleteImage (Long imageId);
}