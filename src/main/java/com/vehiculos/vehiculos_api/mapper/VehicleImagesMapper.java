package com.vehiculos.vehiculos_api.mapper;
import com.vehiculos.vehiculos_api.dto.vehicleImages.VehicleImageCreateRequestDTO;
import com.vehiculos.vehiculos_api.dto.vehicleImages.VehicleImageResponseDTO;
import com.vehiculos.vehiculos_api.entity.VehicleImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper (componentModel = "spring")
public interface VehicleImagesMapper {

    @Mapping(target = "vehicle", ignore = true)
    VehicleImage toEntity (VehicleImageCreateRequestDTO dto);

    @Mapping(source = "vehicle.id", target = "vehicleId")
    VehicleImageResponseDTO toResponse (VehicleImage vehicleImage);
}
