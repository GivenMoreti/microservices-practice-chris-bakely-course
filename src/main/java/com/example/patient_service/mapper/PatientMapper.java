package com.example.patient_service.mapper;

import com.example.patient_service.dto.PatientResponseDto;
import com.example.patient_service.models.Patient;

public class PatientMapper {
    
    public static PatientResponseDto toDto(Patient patient){
    
      PatientResponseDto dto = new PatientResponseDto();

      dto.setId(patient.getId().toString());
      dto.setName(patient.getName());
      dto.setDateOfBirth(patient.getDateOfBirth().toString());
      dto.setAddress(patient.getAddress());
      
      return dto;

        


    }
}
