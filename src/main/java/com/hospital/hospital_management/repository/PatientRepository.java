package com.hospital.hospital_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.hospital_management.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient,Integer>{

}
