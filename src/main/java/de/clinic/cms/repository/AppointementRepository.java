package de.clinic.cms.repository;

import de.clinic.cms.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointementRepository extends JpaRepository<Appointment, Long> {
}
