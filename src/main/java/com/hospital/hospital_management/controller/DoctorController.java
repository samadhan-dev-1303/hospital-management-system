package com.hospital.hospital_management.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.hospital.hospital_management.entity.Doctor;
import com.hospital.hospital_management.service.DoctorService;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    // 1. Add Doctor (POST)
    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.addDoctor(doctor);
    }

    // 2. Get All Doctors (GET)
    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    // 3. Get Doctor by ID (GET)
    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }

    // 4. Update Doctor (PUT)
    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
        return doctorService.updateDoctor(id, doctor);
    }

    // 5. Delete Doctor (DELETE)
    @DeleteMapping("/{id}")
    public boolean deleteDoctor(@PathVariable Long id) {
        return doctorService.deleteDoctor(id);
    }
}