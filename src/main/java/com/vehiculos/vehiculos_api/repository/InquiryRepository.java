package com.vehiculos.vehiculos_api.repository;

import com.vehiculos.vehiculos_api.entity.Inquiry;
import com.vehiculos.vehiculos_api.entity.User;
import com.vehiculos.vehiculos_api.entity.enums.InquiryStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
    //consultar todas mis inquiries - USER
    @Query("SELECT i " +
            "FROM Inquiry i " +
            "JOIN FETCH i.vehicle " +
            "WHERE i.user.id = :userId")
    Page<Inquiry> findAllInquiriesWithVehicle(@Param("userId") Long userId,Pageable pageable);


    //consultar todas las inquiries - ADMIN con todas las relaciones
    @Query("SELECT i " +
            "FROM Inquiry i " +
            "JOIN FETCH i.user " +
            "JOIN FETCH i.vehicle ")
    Page<Inquiry> findAllWithUserAndVehicle(Pageable pageable);


    //consultar todas las inquiries fitradas por su estado - ADMIN
    @Query("SELECT i " +
            "FROM Inquiry i " +
            "JOIN FETCH i.user " +
            "JOIN FETCH i.vehicle " +
            "WHERE i.estado = :estado")
    Page<Inquiry> findByStatus(@Param("estado") InquiryStatus estado, Pageable pageable);
}
