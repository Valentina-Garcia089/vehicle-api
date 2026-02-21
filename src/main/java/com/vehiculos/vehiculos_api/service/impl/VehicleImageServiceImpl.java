package com.vehiculos.vehiculos_api.service.impl;

import com.vehiculos.vehiculos_api.dto.vehicleImages.VehicleImageCreateRequestDTO;
import com.vehiculos.vehiculos_api.dto.vehicleImages.VehicleImageResponseDTO;
import com.vehiculos.vehiculos_api.entity.Vehicle;
import com.vehiculos.vehiculos_api.entity.VehicleImage;
import com.vehiculos.vehiculos_api.exception.ResourceNotFoundException;
import com.vehiculos.vehiculos_api.mapper.VehicleImagesMapper;
import com.vehiculos.vehiculos_api.repository.VehicleImageRepository;
import com.vehiculos.vehiculos_api.service.VehicleImageService;
import com.vehiculos.vehiculos_api.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleImageServiceImpl implements VehicleImageService {
    private final VehicleService vehicleService;
    private final VehicleImageRepository imageRepository;
    private final VehicleImagesMapper imagesMapper;

    public VehicleImageServiceImpl(VehicleService vehicleService,
                                   VehicleImageRepository imageRepository,
                                   VehicleImagesMapper imagesMapper) {
        this.imageRepository = imageRepository;
        this.imagesMapper = imagesMapper;
        this.vehicleService = vehicleService;
    }


    public VehicleImageResponseDTO addImageToVehicle(
            Long vehicleId,
            VehicleImageCreateRequestDTO dto){

        Vehicle vehicle = vehicleService.findEntityById(vehicleId);
        VehicleImage vehicleImage = imagesMapper.toEntity(dto);
        vehicleImage.setVehicle(vehicle);
        VehicleImage savedVehicleImage = imageRepository.save(vehicleImage);

        return imagesMapper.toResponse(savedVehicleImage);
    }



    public List<VehicleImageResponseDTO> getImageByVehicleId (Long vehicleId){
        if (!vehicleService.existsById(vehicleId)) {
            throw new ResourceNotFoundException("Vehículo con ID " + vehicleId + " no encontrado");
        }

        //uso del metodo del repositorio
        List<VehicleImage> images = imageRepository.findByVehicleId(vehicleId);

        return images.stream()
                .map(imagesMapper::toResponse)
                .toList();
    }



    public void deleteImage (Long imageId){
        VehicleImage vehicleImage = imageRepository.findById(imageId)
                .orElseThrow(
                        () -> new ResourceNotFoundException
                                ("Imagen "+imageId+" no encontrada"));

        imageRepository.delete(vehicleImage);
    }
}
