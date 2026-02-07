package de.clinic.cms.service;

import de.clinic.cms.dto.AppointmentRequestDTO;
import de.clinic.cms.dto.AppointmentResponseDTO;
import de.clinic.cms.entity.Appointment;
import de.clinic.cms.entity.Doctor;
import de.clinic.cms.entity.Patient;
import de.clinic.cms.mapper.AppointmentMapper;
import de.clinic.cms.repository.AppointmentRepository;
import de.clinic.cms.repository.DoctorRepository;
import de.clinic.cms.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final AppointmentMapper appointmentMapper;

    public List<Appointment> getAllAppointment() {
        return appointmentRepository.findAll();
    }

    public AppointmentResponseDTO createAppointment(AppointmentRequestDTO dto) {
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

        Appointment saveAppointment = appointmentRepository.save(appointment);
        return appointmentMapper.toDTO(saveAppointment);
    }
}
