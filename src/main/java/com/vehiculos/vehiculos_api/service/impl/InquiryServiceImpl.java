package com.vehiculos.vehiculos_api.service.impl;

import com.vehiculos.vehiculos_api.dto.inquiry.InquiryAdminResposeDTO;
import com.vehiculos.vehiculos_api.dto.inquiry.InquiryCreateRequestDTO;
import com.vehiculos.vehiculos_api.dto.inquiry.InquiryResponseDTO;
import com.vehiculos.vehiculos_api.dto.inquiry.InquiryStatusUpdateRequesDTO;
import com.vehiculos.vehiculos_api.entity.Inquiry;
import com.vehiculos.vehiculos_api.entity.User;
import com.vehiculos.vehiculos_api.entity.Vehicle;
import com.vehiculos.vehiculos_api.entity.enums.InquiryStatus;
import com.vehiculos.vehiculos_api.exception.ResourceNotFoundException;
import com.vehiculos.vehiculos_api.mapper.InquiryMapper;
import com.vehiculos.vehiculos_api.repository.InquiryRepository;
import com.vehiculos.vehiculos_api.repository.UserRepository;
import com.vehiculos.vehiculos_api.service.InquiryService;
import com.vehiculos.vehiculos_api.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InquiryServiceImpl implements InquiryService {
    private final InquiryRepository inquiryRepository;
    private final InquiryMapper inquiryMapper;

    private final UserService userService;
    private final VehicleServiceImpl vehicleService;


    public InquiryServiceImpl(InquiryRepository inquiryRepository, InquiryMapper inquiryMapper, UserServiceImpl userService, VehicleServiceImpl vehicleService) {
        this.inquiryRepository = inquiryRepository;
        this.inquiryMapper = inquiryMapper;
        this.userService = userService;
        this.vehicleService = vehicleService;
    }

    //USER
    //TODO - debe asociarse al contexto del usuario con el contexto de seguridad
    public InquiryResponseDTO createInquiry (InquiryCreateRequestDTO dto){
        User user = userService.getAuthenticatedUserEntity();

        Vehicle vehicle = vehicleService.findEntityById(dto.getVehicleId());

        Inquiry inquiry = inquiryMapper.toEntity(dto);
        //valores que se autocompletarán
        inquiry.setUser(user);
        inquiry.setVehicle(vehicle);
        inquiry.setEstado(InquiryStatus.PENDIENTE);

        Inquiry saved = inquiryRepository.save(inquiry);
        return inquiryMapper.toResponse(saved);
    }


    /*
        TODO - el id del usuario debe obtenerse del contexto de seguridad porque el usuario ya
        está autenticado
    */
    public Page<InquiryResponseDTO> getAllInquiries (Pageable pageable){
        User user = userService.getAuthenticatedUserEntity();

        Page<Inquiry> inquiryPage = inquiryRepository.findAllInquiriesWithVehicle(
                user.getId(), pageable);

        return inquiryPage.map(inquiryMapper::toResponse);
    }


    public InquiryResponseDTO getInquiryById (Long inquiryId){
        User user = userService.getAuthenticatedUserEntity();
        Inquiry inquiry = inquiryRepository.findById(inquiryId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Consulta "+inquiryId+" no encontrada"));

        //si pertenece al usuario del token??
        if(!inquiry.getUser().getId().equals(user.getId()))
            throw new RuntimeException("No tiene autorización para ver esto");

        return inquiryMapper.toResponse(inquiry);
    }





    //ADMIN
    public Page<InquiryAdminResposeDTO> getAllInquiriesAdmin (Pageable pageable){
        Page<Inquiry> inquiryPage = inquiryRepository.findAllWithUserAndVehicle(pageable);
        return inquiryPage.map(inquiryMapper::toAdminResponse);
    }


    public Page<InquiryAdminResposeDTO> getInquiriesByStatus (InquiryStatus estado,
                                                              Pageable pageable){
        Page<Inquiry> inquiryPage = inquiryRepository.findByStatus(estado, pageable);

        return inquiryPage.map(inquiryMapper::toAdminResponse);
    }


    public InquiryAdminResposeDTO getInquiryByIdAdmin (Long inquiryId){
        Inquiry inquiry = inquiryRepository.findById(inquiryId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Consulta "+inquiryId+" no encontrada"));

        return inquiryMapper.toAdminResponse(inquiry);
    }


    public InquiryAdminResposeDTO updateInquiryStatus (Long inquiryId,
                                                InquiryStatusUpdateRequesDTO dto){

        Inquiry inquiry = inquiryRepository.findById(inquiryId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Consulta "+inquiryId+" no encontrada"));

        inquiryMapper.updateStatus(inquiry, dto);
        Inquiry updatedInquiry = inquiryRepository.save(inquiry);

        return inquiryMapper.toAdminResponse(updatedInquiry);
    }
}
