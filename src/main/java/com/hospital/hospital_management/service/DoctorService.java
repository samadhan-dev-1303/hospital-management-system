package com.hospital.hospital_management.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.hospital.hospital_management.entity.Doctor;
import com.hospital.hospital_management.exception.DoctorNotFoundException;
import com.hospital.hospital_management.repository.DoctorRepository;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    // Constructor Injection (better than @Autowired)
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    // 1. Add Doctor
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // 2. Get All Doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // 3. Get Doctor by ID
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor not found with ID: " + id));
    }

    // 4. Update Doctor
    public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
        Doctor existing = doctorRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor not found with ID: " + id));

        existing.setFirstName(updatedDoctor.getFirstName());
        existing.setLastName(updatedDoctor.getLastName());
        existing.setEmail(updatedDoctor.getEmail());
        existing.setPhone(updatedDoctor.getPhone());
        existing.setSpecialization(updatedDoctor.getSpecialization());
        existing.setQualification(updatedDoctor.getQualification());
        existing.setExperience(updatedDoctor.getExperience());
        existing.setJoiningDate(updatedDoctor.getJoiningDate());

        return doctorRepository.save(existing);
    }

    // 5. Delete Doctor
    public boolean deleteDoctor(Long id) {
        if (doctorRepository.existsById(id)) {
            doctorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}