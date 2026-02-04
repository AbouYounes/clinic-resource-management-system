package de.clinic.cms.service;

import de.clinic.cms.entity.Appointment;
import de.clinic.cms.repository.AppointementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointementRepository appointementRepository;

    public List<Appointment> getAllAppointment() {
        return appointementRepository.findAll();
    }

    public Appointment createAppointment(Appointment appointment) {
        // Business Logic: Check availability or validate IDs if needed
        return appointementRepository.save(appointment);
    }
}
