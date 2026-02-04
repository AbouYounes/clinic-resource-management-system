package de.clinic.cms.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentRequestDTO {
    private LocalDateTime appointmentDate;
    private String reason;
    private Long patientId;
    private Long doctorId;
}
