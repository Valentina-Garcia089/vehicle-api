package com.vehiculos.vehiculos_api.dto.vehicle;

import com.vehiculos.vehiculos_api.entity.enums.VehicleFuel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public class VehicleCreateRequestDTO {
    @NotBlank
    private String marca;

    @NotBlank
    private String modelo;

    @NotBlank
    private String color;

    @NotNull
    @Positive
    private int year;

    @NotNull
    @Positive
    private BigDecimal precio;

    @NotNull
    private BigDecimal kilometraje;

    @NotNull
    private VehicleFuel gasolina;


    private String descripcion;

    @NotNull
    private boolean disponible;

    @NotBlank
    private String imageUrl;

    @NotNull
    private List<String> imagenes;


    public VehicleCreateRequestDTO () {}


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

    public List<String> getImagenes() {
        return imagenes;
    }

    public void setUrlsGaleria(List<String> imagenes) {
        this.imagenes = imagenes;
    }
}
