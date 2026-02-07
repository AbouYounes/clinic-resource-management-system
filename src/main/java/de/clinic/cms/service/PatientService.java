package de.clinic.cms.service;

import de.clinic.cms.dto.PatientRequestDTO;
import de.clinic.cms.dto.PatientResponseDTO;
import de.clinic.cms.entity.Patient;
import de.clinic.cms.mapper.PatientMapper;
import de.clinic.cms.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

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
    public PatientResponseDTO savePatient(PatientRequestDTO dto) {
        // 1. Mapping RequestDTO -> Entity
        Patient patient = patientMapper.toEntity(dto);

        // 2. Business Logic & Saving
        Patient savedPatient = patientRepository.save(patient);

        // 3. Mapping Entity -> ResponseDTO
        return patientMapper.toResponseDTO(savedPatient);
    }
}
