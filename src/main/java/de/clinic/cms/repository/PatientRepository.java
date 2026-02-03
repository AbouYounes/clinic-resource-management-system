package de.clinic.cms.repository;

import de.clinic.cms.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Data access layer for Patient entity.
 * Provides standard CRUD operations through JpaRepository.
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
