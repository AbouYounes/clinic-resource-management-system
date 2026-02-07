package de.clinic.cms.mapper;

import de.clinic.cms.dto.AppointmentResponseDTO;
import de.clinic.cms.dto.InvoiceResponseDTO;
import de.clinic.cms.entity.Invoice;
import org.springframework.stereotype.Component;

@Component
public class InvoiceMapper {

    public InvoiceResponseDTO toDTO(Invoice invoice) {
        if (invoice == null) return null;
        return InvoiceResponseDTO.builder()
                .id(invoice.getId())
                .amount(invoice.getAmount())
                .issuedDate(invoice.getIssuedDate())
                .status(invoice.getStatus())
                .patientName(invoice.getAppointment().getPatient().getFirstname() + " " + invoice.getAppointment().getPatient().getLastname())
                .build();
    }
}
