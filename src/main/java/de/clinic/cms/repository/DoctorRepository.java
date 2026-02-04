package de.clinic.cms.repository;

import de.clinic.cms.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Data access layer for Doctor entity.
 * Provides standard CRUD operations through JpaRepository.
 */
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
