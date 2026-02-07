package de.clinic.cms.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@JsonPropertyOrder({"id", "amount", "issuedDate", "status", "patientName"})
public class InvoiceResponseDTO {
    private Long id;
    private BigDecimal amount;
    private LocalDateTime issuedDate;
    private String status;
    private String patientName;
}
