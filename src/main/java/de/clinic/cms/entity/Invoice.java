package de.clinic.cms.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "invoices")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;
    private LocalDateTime issueDate;
    private String status; //e.g., PAID, PENDING, CANCELLED

    @OneToOne
    @JoinColumn(name = "appointment_id", unique = true)
    private Appointment appointment;

}
