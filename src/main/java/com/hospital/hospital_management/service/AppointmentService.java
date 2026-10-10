package com.hospital.hospital_management.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.hospital.hospital_management.entity.Appointment;
import com.hospital.hospital_management.exception.AppointmentNotFoundException;
import com.hospital.hospital_management.repository.AppointmentRepository;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    // 1. Add Appointment
    public Appointment addAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    // 2. Get All Appointments
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // 3. Get Appointment by ID
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment not found with ID: " + id));
    }

    // 4. Update Appointment
    public Appointment updateAppointment(Long id, Appointment updatedAppointment) {
        Appointment existing = appointmentRepository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment not found with ID: " + id));
        
        
        existing.setPatient(updatedAppointment.getPatient());
        existing.setDoctor(updatedAppointment.getDoctor());
        existing.setAppointmentDateTime(updatedAppointment.getAppointmentDateTime());
        existing.setStatus(updatedAppointment.getStatus());

        return appointmentRepository.save(existing);
    }

    // 5. Delete Appointment
    public boolean deleteAppointment(Long id) {
        if (appointmentRepository.existsById(id)) {
            appointmentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}