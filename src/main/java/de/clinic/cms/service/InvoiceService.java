package de.clinic.cms.service;

import de.clinic.cms.dto.InvoiceRequestDTO;
import de.clinic.cms.dto.InvoiceResponseDTO;
import de.clinic.cms.entity.Invoice;
import de.clinic.cms.entity.Appointment;
import de.clinic.cms.mapper.InvoiceMapper;
import de.clinic.cms.repository.InvoiceRepository;
import de.clinic.cms.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final AppointmentRepository appointmentRepository;
    private final InvoiceMapper invoiceMapper;

    public List<Invoice> getAllInvoices() { return invoiceRepository.findAll();}

    public InvoiceResponseDTO createInvoice(InvoiceRequestDTO dto) {
        // Business Logic: Check availability or validate IDs if needed
        Appointment appointment = appointmentRepository.findById(dto.getAppointmentId())
                .orElseThrow(() -> new RuntimeException("Appointment not foud with id: " + dto.getAppointmentId()));

        Invoice invoice = Invoice.builder()
                .issuedDate(LocalDateTime.now())
                .amount(dto.getAmount())
                .status(dto.getStatus())
                .appointment(appointment)
                .build();

        return invoiceMapper.toDTO(invoiceRepository.save(invoice));
    }
}
