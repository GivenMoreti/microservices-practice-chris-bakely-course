package com.example.patient_service.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.patient_service.dto.PatientRequestDto;
import com.example.patient_service.dto.PatientResponseDto;
import com.example.patient_service.exceptions.EmailAlreadyExistsException;
import com.example.patient_service.mapper.PatientMapper;
import com.example.patient_service.models.Patient;
import com.example.patient_service.repository.PatientRepository;

@Service
public class PatientService {
  
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDto> getPatients(){
        
        List<Patient> patients = patientRepository.findAll();
        
        List<PatientResponseDto> patientDtos = patients
        .stream()
        .map(patient -> PatientMapper.toDto(patient))
        .toList();

        return patientDtos;
    }

    public PatientResponseDto createPatient(PatientRequestDto request){

        //check if patient with matching email already exists
        if(patientRepository.existsByEmail(request.getEmail())){
            throw new EmailAlreadyExistsException("A patient with tha email "+ request.getEmail() + " already exists");
        }

         Patient patient = patientRepository.save(PatientMapper.toPatient(request));

         return PatientMapper.toDto(patient);
    }
}
