package de.clinic.cms.controller;

import de.clinic.cms.dto.PatientRequestDTO;
import de.clinic.cms.entity.Patient;
import de.clinic.cms.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    /**
     * Endpoint to retrieve all patients.
     * @return List of patients.
     */
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    /**
     * Endpoint to create a new patient.
     * @param dto The patient data.
     * @return The created patient with 200 OK or 201 Created.
     */
    @PostMapping
    public ResponseEntity<Patient> createPatient(@Valid @RequestBody PatientRequestDTO dto) {
        return ResponseEntity.ok(patientService.savePatient(dto));
    }
}
