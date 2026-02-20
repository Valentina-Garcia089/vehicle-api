package com.vehiculos.vehiculos_api.dto.vehicle;

import com.vehiculos.vehiculos_api.entity.enums.VehicleFuel;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class VehicleSummaryResponseDTO {
    private Long id;
    private String marca;
    private String modelo;
    private String color;
    private int year;
    private BigDecimal precio;
    private VehicleFuel gasolina;
    private String imageUrl;

    public VehicleSummaryResponseDTO(Long id, String marca, String modelo, String color, int year,
                                     BigDecimal precio, VehicleFuel gasolina, String imageUrl) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.year = year;
        this.precio = precio;
        this.gasolina = gasolina;
        this.imageUrl = imageUrl;
    }


    public Long getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public VehicleFuel getGasolina() {
        return gasolina;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
