package de.clinic.cms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * Represents a patient record in the system.
 * Maps to the 'patients' table in the database:
 */
@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    // Unique constraint to prevent duplicate registrations
    @Column(unique = true, nullable = false)
    private String email;

    private String phoneNumber;

    private LocalDate dateOfBirth;

    private String address;
}
