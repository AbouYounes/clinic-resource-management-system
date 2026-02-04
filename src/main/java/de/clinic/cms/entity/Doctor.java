package de.clinic.cms.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Represent a medical doctor within the clinic.
 */
@Entity
@Table(name = "doctors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String specialisation;// e.g., Cardiology, Pediatrics

    private String phoneNumber;
}
