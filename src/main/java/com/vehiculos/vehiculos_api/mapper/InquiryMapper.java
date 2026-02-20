package com.vehiculos.vehiculos_api.mapper;

import com.vehiculos.vehiculos_api.dto.inquiry.InquiryAdminResposeDTO;
import com.vehiculos.vehiculos_api.dto.inquiry.InquiryCreateRequestDTO;
import com.vehiculos.vehiculos_api.dto.inquiry.InquiryResponseDTO;
import com.vehiculos.vehiculos_api.dto.inquiry.InquiryStatusUpdateRequesDTO;
import com.vehiculos.vehiculos_api.entity.Inquiry;
import org.mapstruct.*;

@Mapper (componentModel = "spring")
public interface InquiryMapper {

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "vehicle", ignore = true)
    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "fechaCreacion", ignore = true)
    Inquiry toEntity (InquiryCreateRequestDTO dto);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "vehicle", ignore = true)
    @Mapping(target = "comentarios", ignore = true)
    @Mapping(target = "fechaCreacion", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStatus (@MappingTarget Inquiry inquiry, InquiryStatusUpdateRequesDTO dto);

    InquiryResponseDTO toResponse (Inquiry inquiry);

    InquiryAdminResposeDTO toAdminResponse (Inquiry inquiry);
}
