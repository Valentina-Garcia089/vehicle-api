package com.vehiculos.vehiculos_api.dto.vehicle;

import com.vehiculos.vehiculos_api.entity.enums.VehicleFuel;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class VehicleUpdateRequestDTO {
    private String marca;
    private String modelo;
    private String color;

    @Positive
    private int year;

    @Positive
    private BigDecimal precio;


    private BigDecimal kilometraje;
    private VehicleFuel gasolina;
    private String descripcion;
    private boolean disponible;
    private String imageUrl;
    private LocalDateTime fechaPublicacion;

    public VehicleUpdateRequestDTO () {}


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(BigDecimal kilometraje) {
        this.kilometraje = kilometraje;
    }

    public VehicleFuel getGasolina() {
        return gasolina;
    }

    public void setGasolina(VehicleFuel gasolina) {
        this.gasolina = gasolina;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDateTime fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}
