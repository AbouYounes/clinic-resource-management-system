package de.clinic.cms.service;

import de.clinic.cms.dto.PatientRequestDTO;
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
     * @param dto of the patient entity to save.
     * @return The saved patient entity.
     */
    public Patient savePatient(PatientRequestDTO dto) {
        Patient patient = Patient.builder()
                .firstname(dto.getFirstname())
                .lastname(dto.getLastname())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .dateOfBirth(dto.getDateOfBirth())
                .address(dto.getAddress())
                .build();

        return patientRepository.save(patient);
    }
}
