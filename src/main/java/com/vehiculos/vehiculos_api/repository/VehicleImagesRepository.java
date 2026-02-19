package com.vehiculos.vehiculos_api.repository;

import com.vehiculos.vehiculos_api.entity.VehicleImages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleImagesRepository extends JpaRepository<VehicleImages, Long> {
    //imagenes adicionales del vehiculo - PUBLICO
    List<VehicleImages> findByVehicleId(Long VehicleId);
}
