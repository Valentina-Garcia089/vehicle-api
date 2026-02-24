package com.vehiculos.vehiculos_api.mapper;

import com.vehiculos.vehiculos_api.dto.vehicle.VehicleCreateRequestDTO;
import com.vehiculos.vehiculos_api.dto.vehicle.VehicleResponseDTO;
import com.vehiculos.vehiculos_api.dto.vehicle.VehicleSummaryResponseDTO;
import com.vehiculos.vehiculos_api.dto.vehicle.VehicleUpdateRequestDTO;
import com.vehiculos.vehiculos_api.entity.Vehicle;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    @Mapping(target = "imagenes", ignore = true)
    Vehicle toEntity (VehicleCreateRequestDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "imagenes", ignore = true)
    void updateEntity (@MappingTarget Vehicle vehicle, VehicleUpdateRequestDTO dto);

    VehicleResponseDTO toResponse (Vehicle vehicle); //response trae la galeria

    VehicleSummaryResponseDTO toSummary (Vehicle vehicle);
}
