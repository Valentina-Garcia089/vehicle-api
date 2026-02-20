package com.vehiculos.vehiculos_api.repository;
import com.vehiculos.vehiculos_api.entity.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    //lista de vehiculos - PUBLICO
    Page<Vehicle> findAll(Pageable pageable);

    //filtrar vehiculos por marca - PUBLICO
    Page<Vehicle> findByMarca(String marca, Pageable pageable);

    //ver detalles de un vehiculo especifico por id - publico - ya existe findById()

    //filtrar vehiculo por disponibilidad - ADMIN
    Page<Vehicle> findByDisponibleTrue(Pageable pageable);
}
