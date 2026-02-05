package de.clinic.cms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MedicalRecordRequestDTO {

    @NotNull(message = "Medical record date is required")
    private LocalDateTime recordDate;

    @NotBlank(message = "Diagnosis description is required")
    private String diagnosis;

    @NotBlank(message = "Treatment plan is required")
    private String treatment;

    @NotNull(message = "Patient ID is required")
    private Long patientId;

}
