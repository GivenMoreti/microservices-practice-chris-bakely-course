package com.example.patient_service.controllers;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.patient_service.dto.PatientResponseDto;
import com.example.patient_service.services.PatientService;

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
}
