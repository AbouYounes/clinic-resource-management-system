package de.clinic.cms.service;

import de.clinic.cms.entity.Patient;
import de.clinic.cms.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    /**
     * Retrieves all patients from the database.
     * @return List of all patients.
     */
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    /**
     * Saves a new patient or updates an existing one.
     * @param patient The patient entity to save.
     * @return The saved patient entity.
     */
    public Patient savePatient(Patient patient) {
        // Business logic (e.g, validation) can be added here
        return patientRepository.save(patient);
    }
}
