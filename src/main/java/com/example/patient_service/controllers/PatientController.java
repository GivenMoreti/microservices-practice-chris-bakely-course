package com.example.patient_service.controllers;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.patient_service.dto.PatientRequestDto;
import com.example.patient_service.dto.PatientResponseDto;
import com.example.patient_service.exceptions.CreatePatientValidationGroup;
import com.example.patient_service.services.PatientService;

import jakarta.validation.groups.Default;

import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/patients")
public class PatientController {
    
    private final PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientResponseDto>> getPatients(){
        
        List<PatientResponseDto> patients = patientService.getPatients();
        return ResponseEntity.ok(patients); 
        
    
    }

    @PostMapping
    public ResponseEntity<PatientResponseDto> createPatient(@Validated({Default.class,CreatePatientValidationGroup.class})   @RequestBody PatientRequestDto dto){

        PatientResponseDto response = patientService.createPatient(dto);
        
        return ResponseEntity.ok(response);
    }
}
