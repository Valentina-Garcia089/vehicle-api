package com.vehiculos.vehiculos_api.repository;
import com.vehiculos.vehiculos_api.entity.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    //Mostrar todos los vehiculos por disponibilidad - USERS/PUBLIC
    Page<Vehicle> findByDisponibleTrue(Pageable pageable);

    //filtrar vehiculos por marca y precio - PUBLICO
    Page<Vehicle> findByDisponibleTrueAndPrecioLessThanEqualAndMarcaIn(
            Double precioMax,
            List<String> marcas,
            Pageable pageable
    );

    //filtrar vehiculos por precio maximo - PUBLICO
    Page<Vehicle> findByDisponibleTrueAndPrecioLessThanEqual(
            Double precioMax,
            Pageable pageable
    );

    //ver detalles de un vehiculo especifico por id - publico - ya existe findById()

}
