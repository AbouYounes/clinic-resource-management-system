package de.clinic.cms.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class InvoiceRequestDTO {
    private BigDecimal amount;
    private String status;
    private Long appointmentId;
}
