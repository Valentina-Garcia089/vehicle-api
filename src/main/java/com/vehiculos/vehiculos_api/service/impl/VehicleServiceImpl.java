package com.vehiculos.vehiculos_api.service.impl;

import com.vehiculos.vehiculos_api.dto.vehicle.VehicleCreateRequestDTO;
import com.vehiculos.vehiculos_api.dto.vehicle.VehicleResponseDTO;
import com.vehiculos.vehiculos_api.dto.vehicle.VehicleSummaryResponseDTO;
import com.vehiculos.vehiculos_api.dto.vehicle.VehicleUpdateRequestDTO;
import com.vehiculos.vehiculos_api.entity.Vehicle;
import com.vehiculos.vehiculos_api.entity.VehicleImage;
import com.vehiculos.vehiculos_api.exception.ResourceNotFoundException;
import com.vehiculos.vehiculos_api.mapper.VehicleMapper;
import com.vehiculos.vehiculos_api.repository.VehicleRepository;
import com.vehiculos.vehiculos_api.service.VehicleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    public VehicleServiceImpl(VehicleRepository vehicleRepository, VehicleMapper vehicleMapper) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleMapper = vehicleMapper;
    }


    //PUBLIC / USER

    public Page<VehicleSummaryResponseDTO> getAvailableVehicles(Pageable pageable){
        //no perder paginación
        Page<Vehicle> vehiclePage = vehicleRepository.findByDisponibleTrue(pageable);
        return vehiclePage.map(vehicleMapper::toSummary);
    }


    public Page<VehicleSummaryResponseDTO> getVehiclesByBrand (String marca, Pageable pageable){
        Page<Vehicle> vehiclePage = vehicleRepository.findByMarcaAndDisponibleTrue(marca,
                pageable);
        return vehiclePage.map(vehicleMapper::toSummary);
    }


    public VehicleResponseDTO getVehicleById (Long vehicleId){
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Vehiculo "+ vehicleId + " no encontrado"));

        return vehicleMapper.toResponse(vehicle);
    }




    //ADMIN

    public Page<VehicleSummaryResponseDTO> getAllVehiclesInventory(Pageable pageable){
        Page<Vehicle> vehiclePage = vehicleRepository.findAll(pageable);
        return vehiclePage.map(vehicleMapper::toSummary);
    }


    public VehicleResponseDTO createVehicle(VehicleCreateRequestDTO dto){
        Vehicle vehicle = vehicleMapper.toEntity(dto);

        if (dto.getUrlsGaleria() != null) {
            dto.getUrlsGaleria().forEach(url -> {
                VehicleImage img = new VehicleImage();
                img.setImageUrl(url);
                vehicle.addImage(img); // Esto conecta ambos objetos
            });
        }

        //retorno ya con id
        Vehicle saved = vehicleRepository.save(vehicle);
        return vehicleMapper.toResponse(saved);
    }


    public VehicleResponseDTO updateVehicle(Long vehicleId, VehicleUpdateRequestDTO dto){
        Vehicle savedVehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Vehiculo "+ vehicleId + " no encontrado"));

        //vehiculo ya actualizado
        vehicleMapper.updateEntity(savedVehicle, dto);
        Vehicle updatedVehicle = vehicleRepository.save(savedVehicle);

        return vehicleMapper.toResponse(updatedVehicle);
    }


    public void deleteVehicle(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Vehiculo "+ vehicleId + " no encontrado"));

        vehicleRepository.delete(vehicle);
    }



    

    //llamado desde InquiryServiceImpl para validar que el vehículo existe
    public Vehicle findEntityById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehículo con ID " + id + " no encontrado"));
    }
}
