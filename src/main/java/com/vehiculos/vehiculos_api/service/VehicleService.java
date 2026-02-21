package com.vehiculos.vehiculos_api.service;

import com.vehiculos.vehiculos_api.dto.vehicle.VehicleCreateRequestDTO;
import com.vehiculos.vehiculos_api.dto.vehicle.VehicleResponseDTO;
import com.vehiculos.vehiculos_api.dto.vehicle.VehicleSummaryResponseDTO;
import com.vehiculos.vehiculos_api.dto.vehicle.VehicleUpdateRequestDTO;
import com.vehiculos.vehiculos_api.entity.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface VehicleService {
    //PUBLICO / USER / ADMIN
    Page<VehicleSummaryResponseDTO> getAllVehicles (Pageable pageable);
    Page<VehicleSummaryResponseDTO> getVehiclesByBrand (String marca, Pageable pageable);
    VehicleResponseDTO getVehicleById (Long vehicleId);

    //ADMIN
    VehicleResponseDTO createVehicle(VehicleCreateRequestDTO dto);
    VehicleResponseDTO updateVehicle(Long id, VehicleUpdateRequestDTO dto);
    void deleteVehicle(Long vehicleId);
    Page<VehicleSummaryResponseDTO> getAvailableVehicles(Pageable pageable);


    //llamado desde VehicleImageService
    Vehicle findEntityById(Long id);
    boolean existsById(Long id);
}
