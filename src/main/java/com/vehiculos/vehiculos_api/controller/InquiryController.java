package com.vehiculos.vehiculos_api.controller;

import com.vehiculos.vehiculos_api.dto.inquiry.InquiryAdminResposeDTO;
import com.vehiculos.vehiculos_api.dto.inquiry.InquiryCreateRequestDTO;
import com.vehiculos.vehiculos_api.dto.inquiry.InquiryResponseDTO;
import com.vehiculos.vehiculos_api.dto.inquiry.InquiryStatusUpdateRequesDTO;
import com.vehiculos.vehiculos_api.entity.enums.InquiryStatus;
import com.vehiculos.vehiculos_api.service.InquiryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inquiries")
public class InquiryController {
    private final InquiryService inquiryService;

    public InquiryController(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }


    //USER

    @GetMapping("/users/{userId}/my-inquiries")
    public ResponseEntity<Page<InquiryResponseDTO>> getAllInquiries (
            Pageable pageable, @PathVariable Long userId){

        return ResponseEntity.ok(inquiryService.getAllInquiries(pageable, userId));
    }

    @GetMapping("/users/{userId}/my-inquiries/{inquiryId}")
    public ResponseEntity<InquiryResponseDTO> getInquiryById (
            @PathVariable Long inquiryId, @PathVariable Long userId){
        return ResponseEntity.ok(inquiryService.getInquiryById(inquiryId, userId));
    }


    @PostMapping("/users/{userId}")
    public ResponseEntity<InquiryResponseDTO> createInquiry (
            @RequestBody InquiryCreateRequestDTO dto, @PathVariable Long userId){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(inquiryService.createInquiry(dto, userId));
    }






    //ADMIN

    @GetMapping("/admin")
    public ResponseEntity<Page<InquiryAdminResposeDTO>> getInquiriesAdmin (
            @RequestParam (required = false) InquiryStatus estado ,Pageable pageable){

        if(estado != null)
            return ResponseEntity.ok(inquiryService.getInquiriesByStatus(estado, pageable));

        return ResponseEntity.ok(inquiryService.getAllInquiriesAdmin(pageable));
    }


    @GetMapping("/admin/{inquiryId}")
    public ResponseEntity<InquiryAdminResposeDTO> getInquiryByIdAdmin (
            @PathVariable Long inquiryId){
        return ResponseEntity.ok(inquiryService.getInquiryByIdAdmin(inquiryId));
    }


    @PutMapping("/admin/{inquiryId}/status")
    public ResponseEntity<InquiryAdminResposeDTO> updateInquiryStatus (
            @PathVariable Long inquiryId, @RequestBody InquiryStatusUpdateRequesDTO dto){

        return ResponseEntity.ok(inquiryService.updateInquiryStatus(inquiryId, dto));
    }

}
