package com.vehiculos.vehiculos_api.dto.vehicle;

import com.vehiculos.vehiculos_api.entity.enums.VehicleFuel;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class VehicleResponseDTO {
    private Long id;
    private String marca;
    private String modelo;
    private String color;
    private int year;
    private BigDecimal precio;
    private BigDecimal kilometraje;
    private VehicleFuel gasolina;
    private String descripcion;
    private boolean disponible;
    private String imageUrl;
    private LocalDateTime fechaPublicacion;

    public VehicleResponseDTO(Long id, String marca, String modelo, String color, int year,
                              BigDecimal precio, BigDecimal kilometraje, VehicleFuel gasolina,
                              String descripcion, boolean disponible, String imageUrl,
                              LocalDateTime fechaPublicacion) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.year = year;
        this.precio = precio;
        this.kilometraje = kilometraje;
        this.gasolina = gasolina;
        this.descripcion = descripcion;
        this.disponible = disponible;
        this.imageUrl = imageUrl;
        this.fechaPublicacion = fechaPublicacion;
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

    public BigDecimal getKilometraje() {
        return kilometraje;
    }

    public VehicleFuel getGasolina() {
        return gasolina;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }
}
