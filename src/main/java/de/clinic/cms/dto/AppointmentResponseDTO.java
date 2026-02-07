package de.clinic.cms.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@JsonPropertyOrder({"id", "appointmentDate", "reason", "patientName", "doctorName"})
public class AppointmentResponseDTO {
    private Long id;
    private LocalDateTime appointmentDate;
    private String reason;
    private String patientName;
    private String doctorName;
}
