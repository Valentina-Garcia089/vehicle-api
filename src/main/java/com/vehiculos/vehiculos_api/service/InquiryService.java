package com.vehiculos.vehiculos_api.service;

import com.vehiculos.vehiculos_api.dto.inquiry.InquiryAdminResposeDTO;
import com.vehiculos.vehiculos_api.dto.inquiry.InquiryCreateRequestDTO;
import com.vehiculos.vehiculos_api.dto.inquiry.InquiryResponseDTO;
import com.vehiculos.vehiculos_api.dto.inquiry.InquiryStatusUpdateRequesDTO;
import com.vehiculos.vehiculos_api.entity.enums.InquiryStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InquiryService{

    //USER (el userId es mientras lo cambio a autenticación)
    InquiryResponseDTO createInquiry (InquiryCreateRequestDTO dto, Long userId);
    Page<InquiryResponseDTO> getAllInquiries (Pageable pageable, Long userId);
    InquiryResponseDTO getInquiryById (Long inquiryId);

    //ADMIN
    Page<InquiryAdminResposeDTO> getAllInquiriesAdmin (Pageable pageable);
    Page<InquiryAdminResposeDTO> getInquiriesByStatus (InquiryStatus estado, Pageable pageable);
    InquiryAdminResposeDTO getInquiryByIdAdmin (Long inquiryId);
    InquiryAdminResposeDTO updateInquiryStatus (Long inquiryId,
                                                InquiryStatusUpdateRequesDTO dto);
}
