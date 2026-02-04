package de.clinic.cms.service;

import de.clinic.cms.dto.InvoiceRequestDTO;
import de.clinic.cms.entity.Invoice;
import de.clinic.cms.entity.Appointment;
import de.clinic.cms.repository.InvoiceRepository;
import de.clinic.cms.repository.AppointementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final AppointementRepository appointementRepository;

    public List<Invoice> getAllInvoices() { return invoiceRepository.findAll();}

    public Invoice createInvoice(InvoiceRequestDTO dto) {
        // Business Logic: Check availability or validate IDs if needed
        Appointment appointment = appointementRepository.findById(dto.getAppointmentId())
                .orElseThrow(() -> new RuntimeException("Appointment not foud with id: " + dto.getAppointmentId()));

        Invoice invoice = Invoice.builder()
                .issueDate(LocalDateTime.now())
                .amount(dto.getAmount())
                .status(dto.getStatus())
                .appointment(appointment)
                .build();

        return invoiceRepository.save(invoice);
    }
}
