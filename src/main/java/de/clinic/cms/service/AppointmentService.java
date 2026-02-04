package de.clinic.cms.service;

import de.clinic.cms.dto.AppointmentRequestDTO;
import de.clinic.cms.entity.Appointment;
import de.clinic.cms.entity.Doctor;
import de.clinic.cms.entity.Patient;
import de.clinic.cms.repository.AppointementRepository;
import de.clinic.cms.repository.DoctorRepository;
import de.clinic.cms.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointementRepository appointementRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public List<Appointment> getAllAppointment() {
        return appointementRepository.findAll();
    }

    public Appointment createAppointment(AppointmentRequestDTO dto) {
        // Business Logic: Check availability or validate IDs if needed
        Patient patient = patientRepository.findById(dto.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + dto.getPatientId()));

        Doctor doctor = doctorRepository.findById(dto.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + dto.getDoctorId()));

        Appointment appointment = Appointment.builder()
                .appointmentDate(dto.getAppointmentDate())
                .reason(dto.getReason())
                .patient(patient)
                .doctor(doctor)
                .build();

        return appointementRepository.save(appointment);
    }
}
