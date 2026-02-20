package com.vehiculos.vehiculos_api.entity;

import com.vehiculos.vehiculos_api.entity.enums.InquiryStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "inquiries")
public class Inquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    private String comentarios;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InquiryStatus estado;

    @Column(name = "fecha_creacion" , updatable = false, insertable = false, nullable = false)
    private LocalDateTime fechaCreacion;


    public Inquiry () {}


    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public InquiryStatus getEstado() {
        return estado;
    }

    public void setEstado(InquiryStatus estado) {
        this.estado = estado;
    }
}
