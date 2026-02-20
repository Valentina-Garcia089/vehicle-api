package com.vehiculos.vehiculos_api.repository;

import com.vehiculos.vehiculos_api.entity.VehicleImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleImagesRepository extends JpaRepository<VehicleImage, Long> {
    //imagenes adicionales del vehiculo - PUBLICO
    List<VehicleImage> findByVehicleId(Long VehicleId);
}
