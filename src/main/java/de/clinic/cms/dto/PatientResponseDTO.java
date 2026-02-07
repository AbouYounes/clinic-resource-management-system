package de.clinic.cms.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatientResponseDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
}
