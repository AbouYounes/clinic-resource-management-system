package de.clinic.cms.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MedicalRecordRequestDTO {
    private LocalDateTime recordDate;
    private String diagnosis;
    private String treatment;
    private Long patientId;

}
