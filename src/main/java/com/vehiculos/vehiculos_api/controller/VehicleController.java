package com.vehiculos.vehiculos_api.controller;

import com.vehiculos.vehiculos_api.dto.vehicle.VehicleCreateRequestDTO;
import com.vehiculos.vehiculos_api.dto.vehicle.VehicleResponseDTO;
import com.vehiculos.vehiculos_api.dto.vehicle.VehicleSummaryResponseDTO;
import com.vehiculos.vehiculos_api.dto.vehicle.VehicleUpdateRequestDTO;
import com.vehiculos.vehiculos_api.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }


    //PUBLIC / USER
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("ALIVE");
    }

    @GetMapping
    public ResponseEntity<Page<VehicleSummaryResponseDTO>> getAllVehicles (
            @RequestParam(required = false) List<String> marcas,
            @RequestParam(defaultValue = "700000000") Double precioMax,
            @PageableDefault(size = 12) Pageable pageable){

        if(marcas != null && !marcas.isEmpty())
            return ResponseEntity.ok(vehicleService.getVehiclesByBrand(precioMax, marcas, pageable));

        return ResponseEntity.ok(vehicleService.getAvailableVehicles(precioMax, pageable));
    }


    @GetMapping("/{vehicleId}")
    public ResponseEntity<VehicleResponseDTO> getVehicleById (
            @PathVariable Long vehicleId){
        return ResponseEntity.ok(vehicleService.getVehicleById(vehicleId));
    }






    //ADMIN

    @GetMapping("/inventory")
    public ResponseEntity<Page<VehicleSummaryResponseDTO>> getAllVehiclesInventory(
            @PageableDefault(size = 6) Pageable pageable) {
        return ResponseEntity.ok(vehicleService.getAllVehiclesInventory(pageable));
    }

    @PostMapping
    public ResponseEntity<VehicleResponseDTO> createVehicle(
            @Valid @RequestBody VehicleCreateRequestDTO dto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(vehicleService.createVehicle(dto));
    }


    @PutMapping("/{vehicleId}")
    public ResponseEntity<VehicleResponseDTO> updateVehicle(
            @PathVariable Long vehicleId, @Valid @RequestBody VehicleUpdateRequestDTO dto){

        return ResponseEntity.ok(vehicleService.updateVehicle(vehicleId, dto));
    }


    @DeleteMapping("/{vehicleId}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long vehicleId){
        vehicleService.deleteVehicle(vehicleId);
        return ResponseEntity.noContent().build();
    }
}
