package com.vehiculos.vehiculos_api.service;

import com.vehiculos.vehiculos_api.dto.vehicle.VehicleCreateRequestDTO;
import com.vehiculos.vehiculos_api.dto.vehicle.VehicleResponseDTO;
import com.vehiculos.vehiculos_api.dto.vehicle.VehicleSummaryResponseDTO;
import com.vehiculos.vehiculos_api.dto.vehicle.VehicleUpdateRequestDTO;
import com.vehiculos.vehiculos_api.entity.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VehicleService {
    //PUBLICO / USER / ADMIN
    Page<VehicleSummaryResponseDTO> getAvailableVehicles(Pageable pageable);
    Page<VehicleSummaryResponseDTO> getVehiclesByBrand (String marca, Pageable pageable);
    VehicleResponseDTO getVehicleById (Long vehicleId);

    //ADMIN
    Page<VehicleSummaryResponseDTO> getAllVehiclesInventory(Pageable pageable);
    VehicleResponseDTO createVehicle(VehicleCreateRequestDTO dto);
    VehicleResponseDTO updateVehicle(Long vehicleId, VehicleUpdateRequestDTO dto);
    void deleteVehicle(Long vehicleId);


    //llamado desde VehicleImageService
    Vehicle findEntityById(Long id);
}
