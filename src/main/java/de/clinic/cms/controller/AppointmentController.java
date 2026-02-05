package de.clinic.cms.controller;

import de.clinic.cms.dto.AppointmentRequestDTO;
import de.clinic.cms.entity.Appointment;
import de.clinic.cms.service.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> getAll() {
        return appointmentService.getAllAppointment();
    }

    @PostMapping
    public Appointment create(@Valid @RequestBody AppointmentRequestDTO dto) {
        return appointmentService.createAppointment(dto);
    }
}
