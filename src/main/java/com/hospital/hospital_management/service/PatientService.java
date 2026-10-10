package com.hospital.hospital_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hospital.hospital_management.entity.Patient;
import com.hospital.hospital_management.exception.PatientNotFoundException;
import com.hospital.hospital_management.repository.PatientRepository;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }
    
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    
    public Patient getPatientById(int id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with ID: " + id));
    }
    
    public Patient updateDisease(int id, String disease) {

        Optional<Patient> optionalPatient = patientRepository.findById(id);

        if (optionalPatient.isPresent()) {

            Patient patient = optionalPatient.get();
            patient.setDisease(disease);

            return patientRepository.save(patient);
        }

        return null;
    }
    
    public Patient updatePatient(int id, Patient updatedPatient) {

        Optional<Patient> optionalPatient = patientRepository.findById(id);

        if (optionalPatient.isPresent()) {

            Patient patient = optionalPatient.get();

            patient.setName(updatedPatient.getName());
            patient.setAge(updatedPatient.getAge());
            patient.setGender(updatedPatient.getGender());
            patient.setPhone(updatedPatient.getPhone());
            patient.setDisease(updatedPatient.getDisease());

            return patientRepository.save(patient);
        }

        return null;
    }
    
    public boolean deletePatient(int id) {

        if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
            return true;
        }

        return false;
    }
    
    
}