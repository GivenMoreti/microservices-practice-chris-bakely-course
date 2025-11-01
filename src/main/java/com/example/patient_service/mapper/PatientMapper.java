package com.example.patient_service.mapper;

import java.time.LocalDate;

import com.example.patient_service.dto.PatientRequestDto;
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

    public static Patient toPatient(PatientRequestDto dto){
      
      Patient patient = new Patient();
      patient.setAddress(dto.getAddress());
      patient.setDateOfBirth(LocalDate.parse(dto.getDateOfBirth()));
      patient.setEmail(dto.getEmail());
      patient.setName(dto.getName()); 

      return patient;
    }
}
