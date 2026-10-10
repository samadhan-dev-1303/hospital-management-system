package com.hospital.hospital_management.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.hospital_management.entity.Patient;
import com.hospital.hospital_management.service.PatientService;

@RestController
@RequestMapping("/api")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    
    @PostMapping("/patients")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }
    
    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }
    
    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable int id) {
        return patientService.getPatientById(id);
    }
    
    @PutMapping("/patients/{id}/{disease}")
    public Patient updateDisease(
            @PathVariable int id,
            @PathVariable String disease) {

        return patientService.updateDisease(id, disease);
    }
    
    @PutMapping("/patients/{id}")
    public Patient updatePatient(
            @PathVariable int id,
            @RequestBody Patient patient) {

        return patientService.updatePatient(id, patient);
    }
    
    @DeleteMapping("/patients/{id}")
    public boolean deletePatient(@PathVariable int id) {
        return patientService.deletePatient(id);
    }
}