package de.clinic.cms.controller;

import de.clinic.cms.dto.InvoiceRequestDTO;
import de.clinic.cms.entity.Invoice;
import de.clinic.cms.service.InvoiceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/invoices")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;

    @GetMapping
    public List<Invoice> getAll() { return invoiceService.getAllInvoices();}

    @PostMapping
    public Invoice create(@Valid @RequestBody InvoiceRequestDTO dto) {
        return invoiceService.createInvoice(dto);
    }
}
