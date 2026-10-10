package com.hospital.hospital_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hospital.hospital_management.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}