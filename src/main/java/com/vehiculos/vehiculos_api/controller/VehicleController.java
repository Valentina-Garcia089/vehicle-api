package com.vehiculos.vehiculos_api.controller;

import com.vehiculos.vehiculos_api.dto.vehicle.VehicleCreateRequestDTO;
import com.vehiculos.vehiculos_api.dto.vehicle.VehicleResponseDTO;
import com.vehiculos.vehiculos_api.dto.vehicle.VehicleSummaryResponseDTO;
import com.vehiculos.vehiculos_api.dto.vehicle.VehicleUpdateRequestDTO;
import com.vehiculos.vehiculos_api.service.VehicleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }


    //PUBLIC / USER

    @GetMapping
    public ResponseEntity<Page<VehicleSummaryResponseDTO>> getAllVehicles (
            @RequestParam(required = false) String marca, Pageable pageable){

        if(marca != null && !marca.isEmpty())
            return ResponseEntity.ok(vehicleService.getVehiclesByBrand(marca, pageable));

        return ResponseEntity.ok(vehicleService.getAvailableVehicles(pageable));
    }


    @GetMapping("/{vehicleId}")
    public ResponseEntity<VehicleResponseDTO> getVehicleById (
            @PathVariable Long vehicleId){
        return ResponseEntity.ok(vehicleService.getVehicleById(vehicleId));
    }






    //ADMIN

    @GetMapping("/inventory")
    public ResponseEntity<Page<VehicleSummaryResponseDTO>> getAllVehiclesInventory(
            Pageable pageable) {
        return ResponseEntity.ok(vehicleService.getAllVehiclesInventory(pageable));
    }

    @PostMapping
    public ResponseEntity<VehicleResponseDTO> createVehicle(
            @RequestBody VehicleCreateRequestDTO dto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(vehicleService.createVehicle(dto));
    }


    @PutMapping("/inventory/{vehicleId}")
    public ResponseEntity<VehicleResponseDTO> updateVehicle(
            @PathVariable Long vehicleId, @RequestBody VehicleUpdateRequestDTO dto){

        return ResponseEntity.ok(vehicleService.updateVehicle(vehicleId, dto));
    }


    @DeleteMapping("/inventory/{vehicleId}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long vehicleId){
        vehicleService.deleteVehicle(vehicleId);
        return ResponseEntity.noContent().build();
    }
}
